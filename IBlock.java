public class IBlock extends Tetrimino {
    public IBlock(int x, int y, String colour) {
        super((double)(x + 2), (double)y - 0.5);
        Piece a = new Piece(x, y, colour); //precondition, x < 7 and y < 24
        Piece b = new Piece(x + 1, y, colour);
        Piece c = new Piece(x + 2, y, colour);
        Piece d = new Piece(x + 3, y, colour);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape:
    ---------
    |X| | | |
    ----r----
    X = the coords of (x, y)
    r = the center of rotation
    */
}
