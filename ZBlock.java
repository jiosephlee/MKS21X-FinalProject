public class ZBlock extends Tetrimino {
    public ZBlock(int x, int y) {
        super(x + 1, y);
        Piece a = new Piece(x , y); //preconditions: x < 8, y < 24
        Piece b = new Piece(x + 1, y);
        Piece c = new Piece(x + 1, y - 1);
        Piece d = new Piece(x + 2, y - 1);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape
    -----
    | |r|
    -------
      | | |
      -----
    */
}
