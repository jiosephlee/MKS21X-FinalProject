public class Tetrimino{

    private Piece[] pieces;
    private int centerX;
    private int centerY;

    public Tetrimino(Piece[] input, int x, int y){
        pieces = input;
        centerX = x;
        centerY = y;
  }

    public void rotateCW(){
        for (int i = 0; i < pieces.length; i++) { //first translates to 0,0, and then rotates using (x,y) -> (y,-x)
            int xcor = pieces[i].getX();
            int ycor = pieces[i].getY();
            pieces[i].setY(-1 * (xcor - centerX) + centerY);
            pieces[i].setX(ycor - centerY + centerX);
        }
    }

    public void rotateCCW() {
        for (int i = 0; i < pieces.length; i++) { //first translates to 0,0, and then rotates using (x,y) -> (-y,x)
            int xcor = pieces[i].getX();
            int ycor = pieces[i].getY();
            pieces[i].setY(xcor - centerX + centerY);
            pieces[i].setX(-1 * (ycor - centerY) + centerX);
        } //remember!!! do cases where it ends up being outside or there are other pieces on top
    }

    public double getX(){
        return centerX;
    }

    public double getY(){
        return centerY;
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
