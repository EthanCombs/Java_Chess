import java.util.ArrayList;
public class Game {
	public static Player[] players = {null, null};
	public static Board board;
	public static Player currentTurn;
	private static boolean statusEnd;
  private static boolean statusWhiteWin;
  private static boolean statusBlackWin;
  private static boolean statusDraw;
	private static ArrayList<Move> movesPlayed = new ArrayList<Move>();
  private static String startSquareString;
  private static String endSquareCoords;

	public static void initialize(Player p1, Player p2)
	{
		players[0] = p1;
		players[1] = p2;

		board = new Board();

		if (p1.isWhiteSide()) {
			currentTurn = p1;
		}
		else {
			currentTurn = p2;
		}
    
		movesPlayed.clear();
	}

	public static boolean isEnd()
	{
		return statusEnd;
	}

	public static void setStatus(boolean status, boolean win, boolean white)
	{
		statusEnd = status;
    if (win && white)
      statusWhiteWin = true;
    if (win && !white)
      statusBlackWin = true;
    if (!win && statusEnd)
      statusDraw = true;
	}

	public static boolean playerMove(Player player, int startX, int startY, int endX, int endY)
	{
		Square startSquare = board.getSquare(startX, startY);
		Square endSquare = board.getSquare(endX, endY);
    startSquareString = startSquare.toString();
    endSquareCoords = endSquare.getCoords();
		Move move = new Move(player, startSquare, endSquare);
		return makeMove(move, player);
	}

  // makes move, if invalid, returns false, if move was made, returns true
	public static boolean makeMove(Move move, Player player)
	{
		Piece sourcePiece = move.getStart().getPiece();
		if (sourcePiece == null) {
      System.out.println("No piece on " + NumLetterConverter.numToLetter(move.getStart().getX()) + (move.getStart().getY() + 1));
			return false;
		}

		// valid player
		if (player != currentTurn) {
      System.out.println("Not your turn");
			return false;
		}

		if (sourcePiece.isWhite() != player.isWhiteSide()) {
      System.out.println("Not your color");
			return false;
		}

		// valid move?
		if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
      System.out.println("Invalid move");
			return false;
		}

		// kill?
		Piece destPiece = move.getEnd().getPiece();
		if (destPiece != null) {
			destPiece.setKilled(true);
			move.setPieceKilled(destPiece);
		}

		// store the move
		movesPlayed.add(move);
    System.out.println(startSquareString + " moved to " + endSquareCoords.toLowerCase());
    
    // move piece from the start Square to end Square
		move.getEnd().setPiece(move.getStart().getPiece());
		move.getStart().setPiece(null);
    move.getEnd().getPiece().addMove();

    if (destPiece != null && destPiece instanceof King) {
			if (player.isWhiteSide()) {
				setStatus(true, true, true);
        System.out.println("White won!");
        Main.addMove();
        Main.printMoves();
        board.printBoard();
			}
			else {
				setStatus(true, true, false);
        System.out.println("Black won!");
        Main.addMove();
        Main.printMoves();
        board.printBoard();
			}
		}

		// set the current turn to the other player
		if (currentTurn == players[0]) {
			currentTurn = players[1];
		}
		else {
			currentTurn = players[0];
		}

		return true;
	}

  public static void changeTurn(){
    if (currentTurn == players[0]) {
			currentTurn = players[1];
		}
		else {
			currentTurn = players[0];
		}
  }
}
