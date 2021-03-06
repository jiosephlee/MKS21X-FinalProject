public class LBlock extends Tetrimino {
    public LBlock(int x, int y, String colour) {
        super(x + 1, y);
        Piece a = new Piece(x, y, colour); //preconditions: x < 7, y < 24
        Piece b = new Piece(x + 1, y, colour);
        Piece c = new Piece(x + 2, y, colour);
        Piece d = new Piece(x + 2, y + 1, colour);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    public LBlock(int x, int y) {
        super(x + 1, y);
        String colour = "3";
        Piece a = new Piece(x, y, colour); //preconditions: x < 7, y < 24
        Piece b = new Piece(x + 1, y, colour);
        Piece c = new Piece(x + 2, y, colour);
        Piece d = new Piece(x + 2, y + 1, colour);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape:
        ---
        | |
    -------
    |X|r| |
    -------
    X = the coords of (x, y)
    r = the center of rotation
    */
}
