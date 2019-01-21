import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Grid {
    public static Piece[][] copyOf(Piece[][] og) {
        Piece[][] toReturn = new Piece[og.length][og[0].length];
        for (int i = 0; i < og.length; i++) {
            for (int j = 0; j < og[i].length; j++) {
                toReturn[i][j] = og[i][j];
            }
        }
        return toReturn;
    }
    public static void removeRow(Piece[][] grid, int row) {
        for (int i = row; i > 3; i--) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = grid[i - 1][j];
            }
        }
    }

    private Piece[][] grid;
    private Tetrimino dropping, holding, nexting;
    private int x, y; //these are coords of the dropping tetrimino
    private ArrayList<Tetrimino> queue;
    private boolean held;
    private boolean play;
    public int score, level, highscore;


    public Grid() {
        grid = new Piece[24][10]; //usually 20 x 10, but 4 is added so blocks can start offscreen
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Piece(j, i);
            }
        }
        holding = new Tetrimino();
        queue = new ArrayList<Tetrimino>();
        queue.add(new SBlock(5, 4));
        queue.add(new IBlock(5, 4));
        queue.add(new LBlock(5, 4));
        queue.add(new JBlock(5, 4));
        queue.add(new OBlock(5, 4));
        queue.add(new ZBlock(5, 4));
        queue.add(new TBlock(5, 4));
        dropping = whatsNext();
        nexting = whatsNext();
        play = false;
        score = 0;
        level = 1;
        highscore = 0;
        held = false;
    }

    public String toString() {
        Piece[][] grid2 = copyOf(grid);
        for (int i = 0; i < dropping.getPieces().length; i++) {
            grid2[dropping.getPieces()[i].getY()][dropping.getPieces()[i].getX()] = dropping.getPieces()[i];
        }
        String[] toReturnArr = new String[21]; //each cell is a row in the tetris board
        toReturnArr[0] = ".--------------------.";
        String[] hold = new String[9]; //each cell is a row in the tetris board
        String[] next = new String[9];
        hold[0] = ".----------.";
        hold[1] = ".[ Hold:  |.";
        hold[2] = ".[        |.";
        hold[7] = ".[        |.";
        hold[8] = ".----------.";
        next[0] = ".----------.";
        next[1] = ".[ Next:  |.";
        next[2] = ".[        |.";
        next[7] = ".[        |.";
        next[8] = ".----------.";
        for (int i = 3; i < 7; i++) {
            next[i] = ".[   " + nexting.getPieces()[i - 3].toString() + nexting.getPieces()[i - 3].toString()+ "   |.";
            hold[i] = ".[   " + holding.getPieces()[i - 3].toString() + nexting.getPieces()[i - 3].toString()+ "   |.";
        }
        for (int i = 4; i < grid2.length; i++) { //remember first 4 rows are hidden
            String row = ".";
            for (int j = 0; j < grid2[i].length; j++) {
                row += "" + grid2[i][j].toString()+ grid2[i][j].toString();
            }
            row += ".";
            toReturnArr[i - 3] = row;
        }
        for (int i = 0; i < toReturnArr.length; i++) {
            String row = "";
            if (i >= 1 && i <= 9) { //these ifs append the hold and the next strings
                row += "\t\t" + next[i - 1];
            }
            if (i >= 11 && i <= 19) {
                row += "\t\t" + hold[i - 11];
            }
            toReturnArr[i] += row;
        }
        String toReturn = "";
        for (int i = 0; i < toReturnArr.length; i++) {
            toReturn += toReturnArr[i] + "\n";
        }
        toReturn += "______________________";
        return toReturn;
    }

    public void setHold() {
        holding = dropping;
        setHeld(true);
    }
    public void setNext() {
        nexting = whatsNext();
    }
    public void setDrop() {
        dropping = nexting;
    }
    public void setDrop(Tetrimino toPut) {
        dropping = toPut;
    }
    public void moveDown(int x) {
        if (!isDoneDropping()){
            dropping.moveDown(x);
        }
        else{
            setDrop(whatsNext());
        }
    }

    public boolean getHeld(){
        return held;
    }

    public void setHeld(boolean input){
        held = input;
    }
    public void moveLeft(int cordx) {
        dropping.moveLeft(cordx);
        boolean isDone = true;
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            if (x < 0 || x > 9) {
                isDone = false;
            } else if (!grid[y][x].toString().equals(" ")) {
                isDone = false;
            }
        }
        if (!isDone) {
            dropping.moveRight(cordx);
        }
    }
    public void moveRight(int cordx) {
        dropping.moveRight(cordx);
        boolean isDone = true;
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            if (x < 0 || x > 9) {
                isDone = false;
            } else if (!grid[y][x].toString().equals(" ")) {
                isDone = false;
            }
        }
        if (!isDone) {
            dropping.moveLeft(cordx);
        }
    }
    public void hardDrop() {
        while (!isDoneDropping()) {
            moveDown(1);
        }
        setInStone();
        setDrop();
        setNext();
        setHeld(false);
    }

    public void rotateCW() {
        dropping.rotateCW();
        boolean isDone = true;
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            if (x < 0 || x > 9 || y < 0 || y > 23 || !grid[y][x].toString().equals(" ")) { //checks if it's a valid rotation
                isDone = false;
            }
        }
        if (!isDone) {
            dropping.rotateCCW();
        }
    }
    public void rotateCCW() {
        dropping.rotateCCW();
        boolean isDone = true;
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            if (x < 0 || x > 9 || y < 0 || y > 23 || !grid[y][x].toString().equals(" ")) { //checks if it's a valid rotation
                isDone = false;
            }
        }
        if (!isDone) {
            dropping.rotateCW();
        }
    }

    public boolean isDoneDropping() {
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            if (y == 23 || !grid[y + 1][x].toString().equals(" ")) { //checks if its on top of the ground or on top of a piece;
                return true;
            }
        }
        return false;
    }
    public void setInStone() { //precondition: isDoneDropping is
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            grid[y][x] = dropping.getPieces()[i];
        }
        dropping = new Tetrimino(); //now there is nothing thats "dropping"
    }

    public int[] checkTetris() { //returns the rows that have tetris
        ArrayList<Integer> toReturn = new ArrayList<Integer>(); //makes arraylist cuz we don't know how many there are
        for (int i = grid.length - 1; i >= 0; i--) {
            boolean isDone = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].toString().equals(" ")) {
                    isDone = false;
                }
            }
            if (isDone) {
                toReturn.add(i);
            }
        }
        int[] toReturnActually = new int[toReturn.size()];
        for (int i = 0; i < toReturn.size(); i++) {
            toReturnActually[i] = toReturn.get(i);
        }
        return toReturnActually;
    }
    public void removeTetris(int[] rows) {
        for (int i = 0; i < rows.length; i++) {
            removeRow(grid, rows[i]);
        }
    }
    public boolean checkFailure() {
        for (int i = 0; i < grid[4].length; i++) {
            if (!grid[4][i].toString().equals(" ")) {
                int[] input = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
                removeRow(input);
                holding = new Tetrimino();
                queue = new ArrayList<Tetrimino>();
                queue.add(new SBlock(5, 4));
                queue.add(new IBlock(5, 4));
                queue.add(new LBlock(5, 4));
                queue.add(new JBlock(5, 4));
                queue.add(new OBlock(5, 4));
                queue.add(new ZBlock(5, 4));
                queue.add(new TBlock(5, 4));
                play = false;
                score = 0;
                level = 1;
                highscore = 0;
                held = false;
                return true;
            }
        }
        return false;
    }

    public Tetrimino whatsNext(){
        Random rand = new Random();
        int input = rand.nextInt(queue.size());
        Tetrimino output = queue.get(input);
        queue.remove(input);
        if (queue.size() == 0){
            queue.add(new SBlock(5, 4));
            queue.add(new IBlock(5, 4));
            queue.add(new LBlock(5, 4));
            queue.add(new JBlock(5, 4));
            queue.add(new OBlock(5, 4));
            queue.add(new ZBlock(5, 4));
            queue.add(new TBlock(5, 4));
        }
        return output;
    }

    public void playGame(boolean input){
        play = input;
    }

    public boolean getPlay(){
        return play;
    }
    public static void main(String[] args) {
        Random print = new Random();
        int yolo = print.nextInt(7);
        System.out.println(yolo);
        int yoo = print.nextInt(7);
        System.out.println(yoo);
        Grid test = new Grid();
        test.moveDown(15);
        test.moveLeft(1);
        test.rotateCW();
        test.moveLeft(1);
        test.rotateCCW();
        test.moveDown(2);
        test.setInStone();
        test.rotateCW();
        test.moveLeft(1);
        System.out.println(test);
        System.out.println(test.isDoneDropping());
    }
}
