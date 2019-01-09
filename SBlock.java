public class SBlock extends Tetrimino{
    public SBlock(int x, int y) {
        super();
        Piece a = new Piece();
        Piece b = new Piece();
        Piece c = new Piece();
        Piece d = new Piece();
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape
      -----
      | | |
    -------
    | | |
    -----
    */
}
