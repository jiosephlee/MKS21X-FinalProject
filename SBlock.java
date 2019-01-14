public class SBlock extends Tetrimino{
    public SBlock(int x, int y, String colour) {
        super(x + 1, y + 1);
        Piece a = new Piece(x, y, colour); //precondiions: x < 8, y < 23
        Piece b = new Piece(x + 1, y, colour);
        Piece c = new Piece(x + 1, y + 1, colour);
        Piece d = new Piece(x + 2, y + 1, colour);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape:
      -----
      |r| |
    -------
    |X| |
    -----
    X = the coords of (x, y)
    r = the center of rotation
    */
}
