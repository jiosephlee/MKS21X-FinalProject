public class Tetrimino{

  private Piece[] pieces;
  private int centerX;
  private int centerY;

  public Tetrimino(Piece[] input){
    pieces = input;
    int sumx = 0;
    int sumy = 0;
    for (int x = 0; x < pieces.size; x++){
      sumx += pieces[x].getX();
      sumy += pieces[x].getY();
    }
    centerX = (double) sumx / pieces.size;
    centerY = sumy / pieces.size;
  }

  public void rotate(){
    
  }

  public int getX(){
    return centerX;
  }

  public int getY(){
    return centerY;
  }
  public int moveDown(){

  }
}
