public class Piece{
    private int xCor;
    private int yCor;
    private Tetrimino owner;

    public Piece(){
        xCor = 5;
        yCor = 21;
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
}
