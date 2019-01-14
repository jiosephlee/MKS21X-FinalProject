public class TBlock extends Tetrimino {
    public TBlock(int x, int y, String colour) {
        super(x + 1, y);
        Piece a = new Piece(x, y, colour); //precondition: x < 8, y < 23
        Piece b = new Piece(x + 1, y, colour);
        Piece c = new Piece(x + 2, y, colour);
        Piece d = new Piece(x + 1, y + 1, colour);
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
