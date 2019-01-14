import java.util.ArrayList;
import java.util.Arrays;

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

    private Piece[][] grid;
    private Tetrimino dropping, holding, nexting;
    private int x, y; //these are coords of the dropping tetrimino

    public Grid() {
        grid = new Piece[24][10]; //usually 20 x 10, but 4 is added so blocks can start offscreen
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Piece(j, i);
            }
        }
        dropping = new Tetrimino();
        holding = new Tetrimino();
        nexting = new Tetrimino();
    }

    public String toString() {
        Piece[][] grid2 = copyOf(grid);
        for (int i = 0; i < dropping.getPieces().length; i++) {
            grid2[dropping.getPieces()[i].getY()][dropping.getPieces()[i].getX()] = dropping.getPieces()[i];
        }
        String[] toReturnArr = new String[20]; //each cell is a row in the tetris board
        toReturnArr[0] = ".---------------------.";
        String[] hold = new String[9]; //each cell is a row in the tetris board
        String[] next = new String[9];
        hold[0] = ".---------.";
        hold[1] = ".[ Hold: |.";
        hold[2] = ".[       |.";
        hold[7] = ".[       |.";
        hold[8] = ".---------.";
        next[0] = ".---------.";
        next[1] = ".[ Next: |.";
        next[2] = ".[       |.";
        next[7] = ".[       |.";
        next[8] = ".---------.";
        for (int i = 3; i < 7; i++) {
            next[i] = ".[   " + nexting.getPieces()[i - 3].toString() + "   |.";
            hold[i] = ".[   " + holding.getPieces()[i - 3].toString() + "   |.";
        }
        for (int i = 4; i < grid2.length; i++) { //remember first 4 rows are hidden
            String row = ".";
            for (int j = 0; j < grid2[i].length; j++) {
                row += "|" + grid2[i][j].toString();
            }
            row += "|.";
            toReturnArr[i - 4] = row;
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
        toReturn += "_______________________";
        return toReturn;
    }

    public void setHold(Tetrimino toPut) {
        holding = toPut;
    }
    public void setNext(Tetrimino toPut) {
        nexting = toPut;
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
            setDrop(new IBlock(5, 4, "1"));
        }
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

    public void rotateCW() {
        dropping.rotateCW();
        boolean isDone = true;
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            if (x < 0 || x > 9 || y < 0 || y > 23 || !grid[y][x].toString().equals(" ")) {
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
            if (x < 0 || x > 9 || y < 0 || y > 23 || !grid[y][x].toString().equals(" ")) {
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
    public void setInStone() { //precondition: isDoneDroopping is
        for (int i = 0; i < dropping.getPieces().length; i++) {
            int x = dropping.getPieces()[i].getX();
            int y = dropping.getPieces()[i].getY();
            grid[y][x] = dropping.getPieces()[i];
        }
        dropping = new Tetrimino(); //now there is nothing thats "dropping"
    }

    public int[] checkTetris() { //returns the rows that have tetris
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (int i = grid.length; i >= 0; i--) {
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

    public static void main(String[] args) {
        Grid test = new Grid();
        Tetrimino toAdd = new IBlock(0, 5, "a");
        test.setDrop(toAdd);
        System.out.println(test);
        test.moveDown(15);
        System.out.println(test);
        test.rotateCCW();
        test.moveDown(3);
        test.setInStone();
        toAdd = new ZBlock(0, 15, "d");
        test.setDrop(toAdd);
        test.rotateCW();
        test.moveLeft(1);
        System.out.println(test);
        System.out.println(test.isDoneDropping());
    }
}
