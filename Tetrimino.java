public class Tetrimino{

  private Piece[] pieces;
  private double centerX;
  private double centerY;

  public Tetrimino(Piece[] input){
    pieces = input;
    int sumx = 0;
    int sumy = 0;
    for (int x = 0; x < pieces.length; x++){
      sumx += pieces[x].getX();
      sumy += pieces[x].getY();
    }
    centerX = (double)sumx / pieces.length;
    centerY = (double)sumy / pieces.length;
  }

  public void rotate(){
    
  }

  public double getX(){
    return centerX;
  }

  public double getY(){
    return centerY;
  }
  public void moveDown(){
    for (int x = 0; x < pieces.length; x++){
      pieces[x].moveDown();
    }
    centerY--;
  }
}
