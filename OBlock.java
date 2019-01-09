public class OBlock extends Tetrimino {
    public OBlock(int x, int y) {
        super(x + 0.5, y + 0.5);
        Piece a = new Piece(x, y); //precondition: x < 9, y < 23
        Piece b = new Piece(x + 1, y);
        Piece c = new Piece(x, y + 1);
        Piece d = new Piece(x + 1, y + 1);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape:
    -----
    | | |
    --r--
    |X| |
    -----
    X = the coords of (x, y)
    r = the center of rotation
    */
}
