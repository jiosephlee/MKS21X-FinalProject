public class Tetrimino{

    private Piece[] pieces;
    private double centerX;
    private double centerY;

    public Tetrimino(Piece[] input, double x, double y){
        pieces = input;
        centerX = x;
        centerY = y;
    }

    public Tetrimino(double x, double y) { //this is used in blocks
        centerX = x;
        centerY = y;
    }

    public Tetrimino() { //this is used for stuff like hold in Grid

    }

    public void rotateCW(){
        for (int i = 0; i < pieces.length; i++) { //first translates to 0,0, and then rotates using (x,y) -> (y,-x)
            int xcor = pieces[i].getX();
            int ycor = pieces[i].getY();
            pieces[i].setY((int)(-1 * (xcor - centerX) + centerY));
            pieces[i].setX((int)(ycor - centerY + centerX));
        }
    }

    public void rotateCCW() {
        for (int i = 0; i < pieces.length; i++) { //first translates to 0,0, and then rotates using (x,y) -> (-y,x)
            int xcor = pieces[i].getX();
            int ycor = pieces[i].getY();
            pieces[i].setY((int)(xcor - centerX + centerY));
            pieces[i].setX((int)(-1 * (ycor - centerY) + centerX));
        } //remember!!! do cases where it ends up being outside or there are other pieces on top
    }

    public double getX(){
        return centerX;
    }

    public double getY(){
        return centerY;
    }

    public void setPieces(Piece[] newPieces) {
        pieces = newPieces;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void moveDown(){
        for (int i = 0; i < pieces.length; i++){
            pieces[i].moveDown();
        }
        centerY--;
    }

    public void moveRight() {
        for (int i = 0; i < pieces.length; i++) {
            pieces[i].moveRight();
        }
        centerX++;
    }
    public void moveRight(int x) {
        for (int i = 0; i < pieces.length; i++) {
            pieces[x].moveRight(x);
        }
        centerX += x;
    }

    public void moveLeft() {
        for (int i = 0; i < pieces.length; i++) {
            pieces[i].moveLeft();
        }
        centerX--;
    }
    public void moveLeft(int x) {
        for (int i = 0; i < pieces.length; i++) {
            pieces[i].moveLeft(x);
        }
        centerX -= x;
    }
}
