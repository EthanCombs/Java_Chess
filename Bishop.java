public class Bishop extends Piece {
	public Bishop(boolean white, int x, int y)
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
    // Can only move diagonal
		return x / y == 1;
  }

	public boolean canMove(Board board, Square start, Square end)
	{
    // Can't move if your own color piece is on the end square
		if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}

		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
    // Prevents / 0 error
    if (y == 0)
      return false;
    // Can only move diagonal
		return x / y == 1;
	}
  public String toString()
  {
    if (this.isWhite())
      return "White Bishop";
    return "Black Bishop";
  }
}