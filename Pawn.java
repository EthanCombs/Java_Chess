public class Pawn extends Piece {
  private boolean hasNotMoved = true;
	public Pawn(boolean white, int x, int y)
	{
		super(white, x, y);
	}

  // Only used for getting correct piece.
  public boolean canMove(int endX, int endY)
	{
    int x = Math.abs(this.getX() - endX);
		int y = Math.abs(this.getY() - endY);
    if (y == 1 && x == 1) return true;
    return false;
  }
  
	public boolean canMove(Board board, Square start, Square end)
	{
    int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
    int c;
    if (this.isWhite())
      c = 1;
    else
      c = -1;
    Square path = board.getSquare(start.getX(), start.getY() + c);
    // capture - if the move is 1 in both directions and the spot it wants to move to has a piece of the oppisite color, returns true
    if (y == 1 && x == 1 && end.getPiece() != null){
      return end.getPiece().isWhite() != this.isWhite();
    }
    // if there is a piece in the way, flase
		if (end.getPiece() != null) {
			return false;
		}
    // if the move is up/back 2 and 
    if (y == 2 && path.getPiece() == null && hasNotMoved){
      hasNotMoved = false;
      return true;
    }
    if (y == 1) {
      hasNotMoved = false;
		  return true;
    }
    return false;
	}
  public String toString()
  {
    if (this.isWhite())
      return "White Pawn";
    return "Black Pawn";
  }
}
