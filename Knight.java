public class Knight extends Piece {
	public Knight(boolean white, int x, int y)
	{
		super(white, x, y);
	}

  // Only used for getting correct piece.
  public boolean canMove(int endX, int endY)
	{
    int x = Math.abs(this.getX() - endX);
		int y = Math.abs(this.getY() - endY);
    // Prevents / 0 error
    if (y == 0)
      return false;
    // Can only move 1 in x or y, and 2 in the other
		return x * y == 2;
  }
  
	public boolean canMove(Board board, Square start, Square end)
	{
    // Can't move if your own color piece is on the end square
		if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}

		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
    // Can only move 1 in x or y, and 2 in the other
		return x * y == 2;
	}
  public String toString()
  {
    if (this.isWhite())
      return "White Knight";
    return "Black Knight";
  }
}