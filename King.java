public class King extends Piece{
  public King(boolean white, int x, int y)
	{
		super(white, x, y);
	}

  // Only used for getting correct piece.
  public boolean canMove(int endX, int endY)
	{
    int x = Math.abs(this.getX() - endX);
		int y = Math.abs(this.getY() - endY);
    // Can move if the end square is 1 away from the start square
    if ((x == 1 && y == 1) || (x == 1 && y == 0) || (x == 0 && y == 1)) {
      return true;
    }
    return false;
  }
  
  public boolean canMove(Board board, Square start, Square end)
  {
    // Can't move if your own color piece is on the end square
    if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
      return false;
    }
    int x = Math.abs(start.getX() - end.getX());
    int y = Math.abs(start.getY() - end.getY());
    // Can move if the end square is 1 away from the start square
    if ((x == 1 && y == 1) || (x == 1 && y == 0) || (x == 0 && y == 1)) {
      return true;
    }
    return false;
  }

  public String toString()
  {
    if (this.isWhite())
      return "White King";
    return "Black King";
  }
}