public class Piece{
    private int xCor;
    private int yCor;
    private Tetrimino owner;

    public Piece(int x, int y){
        xCor = x;
        yCor = y;
    }

    public String toString() {
        return " ";
    }

    public void setX(int x){
        xCor = x;
    }

    public void setY(int y){
        yCor = y;
    }

    public int getX(){
        return xCor;
    }

    public int getY(){
        return yCor;
    }

    public Tetrimino getOwner(){
        return owner;
    }

    public void moveDown(){
        yCor--;
    }

    public void moveRight() {
        xCor++;
    }
    public void moveRight(int x) {
        xCor += x;
    }

    public void moveLeft() {
        xCor--;
    }
    public void moveLeft(int x) {
        xCor -= x;
    }
}
