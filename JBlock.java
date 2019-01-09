public class JBlock extends Tetrimino {
    public JBlock(int x, int y) {
        super(x + 1, y - 1);
        Piece a = new Piece(x, y); //preconditions: x < 8, y < 24
        Piece b = new Piece(x, y - 1);
        Piece c = new Piece(x + 1, y - 1);
        Piece d = new Piece(x + 2, y - 1);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape:
    ---
    |X|
    -------
    | |r| |
    -------
    X = the coords of (x, y)
    r = the center of rotation
    */
}
