public class Grid {

    Piece[][] grid = new Piece[24][10]; //usually 20 x 10, but 4 is added so blocks can start offscreen

    public Grid() {

    }

    public String toString() {
        String toReturn = "---------------------\n";
        String hold = "";
        String next = "";
        for (int i = 0; i < 9; i++) {
            if (i == 0 || i == 8) {
                hold += "---------\n";
                next += "---------\n";
            } else if (i == 1) {
                hold += "| Hold: |\n";
                next += "| Next: |\n";
            } else if (i == 2 || i == 7){
                hold += "|       |";
                next += "|       |";
            }
        }
        for (int i = 4; i < grid.length; i++) { //remember first 4 rows are hidden
            for (int j = 0; j < grid[i].length; j++) {
                toReturn += "|" + grid[i][j].toString();
            }
            toReturn += "|";
            toReturn += "\n";
        }
        return toReturn + "---------------------";
    }
}
