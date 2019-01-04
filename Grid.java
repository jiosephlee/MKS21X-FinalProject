public class Grid {

    Piece[][] grid = new Piece[24][10]; //usually 20 x 10, but 4 is added so blocks can start offscreen

    public Grid() {

    }

    public String toString() {
        String toReturn = "---------------------";
        for (int i = 1; i < grid.length; i++) {

        }
        return toReturn;
    }
}
