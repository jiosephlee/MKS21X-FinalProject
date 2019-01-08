public class Tetrimino{

    private Piece[] pieces;
    private int centerX;
    private int centerY;

    public Tetrimino(Piece[] input){
        pieces = input;
        int sumx = 0;
        int sumy = 0;
        for (int i = 0; i < pieces.length; i++){
            sumx += pieces[i].getX();
            sumy += pieces[i].getY();
        }
        centerX = 0;
        centerY = 0; //place values for now until we implement actual pieces
  }

    public void rotateCC(){
        for (int i = 0; i < pieces.length; i++) { //first translates to 0,0, and then rotates using (x,y) -> (-y,x)
            int xcor = pieces[i].getX();
            int ycor = pieces[i].getY();
            pieces[i].setY(-1 * (xcor - centerX) + centerY);
            pieces[i].setX(ycor - centerY + centerX);
        }
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
