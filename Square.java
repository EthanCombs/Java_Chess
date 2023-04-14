public class Square {
  private Piece piece;
  private int x;
  private int y;
  // Constructor
  public Square(int x, int y, Piece piece){
    setPiece(piece);
    setX(x);
    setY(y);
  }
  // Mutators
  public void setPiece(Piece p){
    piece = p;
  }
  public void setX(int num){
    x = num;
  }
  public void setY(int num){
    y = num;
  }
  // Accessors 
  public Piece getPiece(){
    return piece;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public String getCoords(){
    return NumLetterConverter.numToLetter(x) + (y + 1);
  }
  public String toString(){
    String temp;
    if (piece == null) temp = "nothing";
    else temp = piece.toString();
    return temp + " on " + NumLetterConverter.numToLetter(x).toLowerCase() + (y + 1);
  }
}