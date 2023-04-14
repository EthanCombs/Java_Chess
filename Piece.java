public abstract class Piece {
	private boolean killed = false;
	private boolean white = false;
  private int x;
  private int y;
  private int moveCount = 0;

	public Piece(boolean white, int x, int y)
	{
		setWhite(white);
    setX(x);
    setY(y);
}
  // Accessors
	public boolean isWhite()
	{
		return white;
	}

  public boolean isKilled()
	{
		return killed;
	}
  public boolean hasMoved()
  {
    return moveCount == 0;
  }
  public int getX()
	{
		return x;
	}

  public int getY()
	{
		return y;
	}
  public int getMoveCount(){
    return moveCount;
  }
  // Mutators
	public void setWhite(boolean w)
	{
		white = w;
	}

  public void setX(int x)
	{
		this.x = x;
	}
  public void setY(int y)
	{
		this.y = y;
	}

	public void setKilled(boolean k)
	{
		killed = k;  
	}
  public void setMoveCount(int count)
  {
    moveCount = count;
  }
  public void addMove()
  {
    moveCount++;
  }
  public abstract String toString();
	public abstract boolean canMove(Board board, Square start, Square end);
  public abstract boolean canMove(int endX, int endY);
}
