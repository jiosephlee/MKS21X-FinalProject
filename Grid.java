public class Grid {

    private Piece[][] grid;
    private Tetrimino dropping, holding, next;
    private int x, y; //these are coords of the dropping tetrimino

    public Grid() {
        grid = new Piece[24][10]; //usually 20 x 10, but 4 is added so blocks can start offscreen
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Piece();
            }
        }
        dropping = new Tetrimino();
        holding = new Tetrimino();
        next = new Tetrimino();
    }

    public String toString() {
        String[] toReturnArr = new String[20];
        toReturnArr[0] = "---------------------\n";
        String[] hold = new String[9];
        String[] next = new String[9];
        for (int i = 4; i < grid.length; i++) { //remember first 4 rows are hidden
            for (int j = 0; j < grid[i].length; j++) {
            }
        }
        String toReturn = "";
        for (int i = 0; i < toReturnArr.length; i++) {
            toReturn += toReturnArr[i] + "\n";
        }
        return toReturn;
    }
}
