public class Move {
	private Player player;
	private Square start;
	private Square end;
	private Piece pieceMoved;
	private Piece pieceKilled;
  public static int moveNum;
	public Move(Player player, Square start, Square end)
	{
		this.player = player;
		this.start = start;
		this.end = end;
		this.pieceMoved = start.getPiece();
	}
  public Square getStart(){
    return start;
  }
  
  public Square getEnd(){
    return end;
  }
  
  public void setPieceKilled(Piece piece){
    pieceKilled = piece;
  }
  public String toString(){
    moveNum++;
    return ((moveNum - 1) / 2 + 1) + ": " + pieceMoved;
  }
}
