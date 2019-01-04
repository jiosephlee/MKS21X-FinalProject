public class Grid {

    Piece[][] grid = new Piece[24][10]; //usually 20 x 10, but 4 is added so blocks can start offscreen

    public Grid() {

    }

    public String toString() {
        String toReturn = "---------------------\n";
        for (int i = 4; i < grid.length; i++) { //remember first 4 rows are hidden
            for (int j = 0; j < grid[i].length; j++) {
                toReturn += "|" + grid[i][j].toString();
            }
            toReturn += "|\n";
        }
        return toReturn + "---------------------";
    }
}
