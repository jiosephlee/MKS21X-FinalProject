public class Tetrimino{

    private Piece[] pieces;
    private double centerX;
    private double centerY;

    public Tetrimino(Piece[] input){
        pieces = input;
        int sumx = 0;
        int sumy = 0;
        for (int i = 0; i < pieces.length; i++){
            sumx += pieces[i].getX();
            sumy += pieces[i].getY();
        }
        centerX = (double)sumx / pieces.length;
        centerY = (double)sumy / pieces.length;
  }

    public void rotate(){
        for (int i = 0; i < pieces.length; i++) {
            int xcor = pieces[i].getX();
            int ycor = pieces[i].getY();
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
