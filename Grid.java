public class Grid {

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
        String[] toReturnArr = new String[41]; //each cell is a row in the tetris board
        toReturnArr[0] = "---------------------";
        String[] hold = new String[9]; //each cell is a row in the tetris board
        String[] next = new String[9];
        hold[0] = "---------";
        hold[1] = "[ Hold: |";
        hold[2] = "[       |";
        hold[7] = "[       |";
        hold[8] = "---------";
        next[0] = "---------";
        next[1] = "[ Next: |";
        next[2] = "[       |";
        next[7] = "[       |";
        next[8] = "---------";
        for (int i = 3; i < 7; i++) {
            next[i] = "|   " + nexting.getPieces()[i - 3].toString() + "   |";
            hold[i] = "|   " + holding.getPieces()[i - 3].toString() + "   |";
        }
        for (int i = 4; i < grid.length; i++) { //remember first 4 rows are hidden
            String row = "";
            for (int j = 0; j < grid[i].length; j++) {
                row += "|" + grid[i][j].toString();
            }
            row += "|";
            toReturnArr[2 * (i - 4) + 1] = row;
            toReturnArr[2 * (i - 4) + 2] = "---------------------";
        }
        for (int i = 0; i < toReturnArr.length; i++) { //remember first 4 rows are hidden
            String row = "";
            if (i >= 7 && i <= 15) { //these ifs append the hold and the next strings
                row += "\t\t" + next[i - 7];
            }
            if (i >= 19 && i <= 27) {
                row += "\t\t" + hold[i - 19];
            }
            toReturnArr[i] += row;
        }
        String toReturn = "";
        for (int i = 0; i < toReturnArr.length; i++) {
            toReturn += toReturnArr[i] + "\n";
        }
        return toReturn;
    }

    public void setHold(Tetrimino toPut) {
        holding = toPut;
    }

    public void setNext(Tetrimino toPut) {
        nexting = toPut;
    }

    private void setDrop() { //the reason it's private is 'coz we can just move the next as the things that's dropping
        dropping = nexting;
    }
}
