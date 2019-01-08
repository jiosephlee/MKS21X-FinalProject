public class Piece{
    private int xCor;
    private int yCor;
    private Tetrimino owner;
    private String colour; //:)))))

    public Piece(int x, int y, String col){
        xCor = x;
        yCor = y;
        colour = col;
    }

    public Piece(int x, int y) { //this is the emptyPiece
        xCor = x;
        yCor = y;
        colour = " ";
    }

    public String toString() {
        return "" + colour;
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
