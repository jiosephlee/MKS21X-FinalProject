public class Grid {

    private Piece[][] grid;
    private Tetrimino dropping, holding, next;
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
        next = new Tetrimino();
    }

    public String toString() {
        String[] toReturnArr = new String[20]; //each cell is a row in the tetris board
        toReturnArr[0] = "---------------------\n";
        String[] hold = new String[9]; //each cell is a row in the tetris board
        String[] next = new String[9];
        hold[0] = "---------";
        hold[1] = "| Hold: |";
        hold[2] = "|       |";
        hold[7] = "|       |";
        hold[8] = "---------";
        next[0] = "---------";
        next[1] = "| Next: |";
        next[2] = "|       |";
        next[7] = "|       |";
        next[8] = "---------";
        for (int i = 3; i < 7; i++) {
            next[i] = "|   " + next.getPieces()[i - 3].toString() + "   |";
            hold[i] = "|   " + hold.getPieces()[i - 3].toString() + "   |";
        }
        for (int i = 4; i < grid.length; i++) { //remember first 4 rows are hidden
            String row = "";
            for (int j = 0; j < grid[i].length; j++) {
                row += "|" + grid[i][j].toString();
            }
            row += "|";
            if (i >= 7 && i <= 15) { //these ifs append the hold and the next strings
                row += "\t\t" + next[i - 7];
            }
            if (i >= 19 && i <= 27) {
                row += "\t\t" + hold[i - 19];
            }
            toReturnArr[i - 4] = row;
        }
        String toReturn = "";
        for (int i = 0; i < toReturnArr.length; i++) {
            toReturn += toReturnArr[i] + "\n";
        }
        return toReturn;
    }
}
