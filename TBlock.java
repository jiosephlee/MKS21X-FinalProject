public class TBlock extends Tetrimino {
    public TBlock(int x, int y) { //x's and y's don't mean center, but starting point
        super(x + 1, y);
        Piece a = new Piece(x, y); //precondition: x < 8, y < 23
        Piece b = new Piece(x + 1, y);
        Piece c = new Piece(x + 2, y);
        Piece d = new Piece(x + 1, y + 1);
        Piece[] toAdd = {a, b, c, d};
        super.setPieces(toAdd);
    }
    /* this is the shape:
      ---
      | |
    -------
    | | | |
    -------
    */
}
