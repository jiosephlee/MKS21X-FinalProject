public class LBlock extends Tetrimino {
    public LBlock(int x, int y) {
        super(x + 1, y);
        Piece a = new Piece(x, y); //preconditions: x < 7, y < 24
        Piece b = new Piece(x + 1, y);
        Piece c = new Piece(x + 2, y);
        Piece d = new Piece(x + 2, y + 1);
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
