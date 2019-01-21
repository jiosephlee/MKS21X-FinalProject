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
    public static void addTetToArr(String[] lines, Tetrimino toAdd) {
        if (toAdd.getPieces()[0].toString().equals("1")) { //IBlock
            for (int i = 3; i < 7; i++) {
                lines[i] = ".[    11    |.";
            }
        } else if (toAdd.getPieces()[0].toString().equals("2")) { //JBlock
            lines[3] = ".[     22   |.";
            lines[4] = ".[     22   |.";
            lines[5] = ".[   2222   |.";
            lines[6] = ".[          |.";
        } else if (toAdd.getPieces()[0].toString().equals("3")) { //LBlock
            lines[3] = ".[   33     |.";
            lines[4] = ".[   33     |.";
            lines[5] = ".[   3333   |.";
            lines[6] = ".[          |.";
        } else if (toAdd.getPieces()[0].toString().equals("4")) { //OBlock
            lines[3] = ".[          |.";
            lines[4] = ".[   4444   |.";
            lines[5] = ".[   4444   |.";
            lines[6] = ".[          |.";
        } else if (toAdd.getPieces()[0].toString().equals("5")) { //SBlock
            lines[3] = ".[          |.";
            lines[4] = ".[    5555  |.";
            lines[5] = ".[  5555    |.";
            lines[6] = ".[          |.";
        } else if (toAdd.getPieces()[0].toString().equals("6")) { //TBlock
            lines[3] = ".[          |.";
            lines[4] = ".[    66    |.";
            lines[5] = ".[  666666  |.";
            lines[6] = ".[          |.";
        } else if (toAdd.getPieces()[0].toString().equals("7")) { //ZBlock
            lines[3] = ".[          |.";
            lines[4] = ".[  7777    |.";
            lines[5] = ".[    7777  |.";
            lines[6] = ".[          |.";
        } else { //the empty tetrimino
            lines[3] = ".[          |.";
            lines[4] = ".[          |.";
            lines[5] = ".[          |.";
            lines[6] = ".[          |.";
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
        level = 1;
        score = 0;
        highscore = 0;
        held = false;
    }
    public Grid(int prev) {
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
        level = 1;
        score = 0;
        highscore = prev;
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
        hold[0] = ".------------.";
        hold[1] = ".[ Hold:    |.";
        hold[2] = ".[          |.";
        hold[7] = ".[          |.";
        hold[8] = ".------------.";
        next[0] = ".------------.";
        next[1] = ".[ Next:    |.";
        next[2] = ".[          |.";
        next[7] = ".[          |.";
        next[8] = ".------------.";
        addTetToArr(hold, holding); //what the function does is so that it manually adds
        addTetToArr(next, nexting); //the shape of the tetriminos into the toStringArrays
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
        toReturn += "______________________\n";
        toReturn += "    Score: " + score;
        toReturn += "\n    Level: " + level;
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
        if (!isDoneDropping()) {
            dropping.moveDown(x);
        }
        else {
            setDrop(whatsNext());
        }
    }

    public boolean getHeld() {
        return held;
    }

    public void setHeld(boolean input) {
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
    public void removeTetris(int[] rows) { //clears rows that are supposed to be cleared
        for (int i = 0; i < rows.length; i++) {
            removeRow(grid, rows[i]);
            score++;
            if (score % 7 == 0){
                level++;
            }
        }
    }
    public boolean checkFailure() { //checks if the game is finished. if so stop playing and reset the game data
        for (int i = 0; i < grid[4].length; i++) {
            if (!grid[4][i].toString().equals(" ")) {
                return true;
            }
        }
        return false;
    }

    public Tetrimino whatsNext() { //puts in the tetrimino that is queud to be next
        Random rand = new Random();
        int input = rand.nextInt(queue.size());
        Tetrimino output = queue.get(input);
        queue.remove(input);
        if (queue.size() == 0) {
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

    public void playGame(boolean input) { //sets whether the game is in play mode
        play = input;
    }
    public boolean getPlay() {
        return play;
    }

    public static void main(String[] args) {
        Grid test = new Grid();
        Tetrimino toAdd = new ZBlock(0, 4);
        test.setDrop(toAdd);
        test.moveDown(15);
        test.setNext(toAdd);
        System.out.println(test);
        System.out.println(test.isDoneDropping());
    }
}
