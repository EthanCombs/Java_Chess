public class Board {
  // Chess Pieces
  public static final String WHITE_KING = "\u2654";
  public static final String WHITE_QUEEN = "\u2655";
  public static final String WHITE_ROOK = "\u2656";
  public static final String WHITE_BISHOP = "\u2657";
  public static final String WHITE_KNIGHT = "\u2658";
  public static final String WHITE_PAWN = "\u2659";
  public static final String BLACK_KING = "\u265A";
  public static final String BLACK_QUEEN = "\u265B";
  public static final String BLACK_ROOK = "\u265C";
  public static final String BLACK_BISHOP = "\u265D";
  public static final String BLACK_KNIGHT = "\u265E";
  public static final String BLACK_PAWN = "\u265F";
  // Text and background colors
  // Normal
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_TEST = "\u001b[38;5;202m";
  // Background
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
  // used colors
  String color1 = ANSI_WHITE;
  String color2 = ANSI_BLACK;
  String back1 = ANSI_GREEN_BACKGROUND;
  String back2 = ANSI_WHITE_BACKGROUND;
  String background;
  
	Square[][] boxes = new Square[8][8];

	public Board()
	{
		this.resetBoard();
	}
  public boolean testSquares(int startX, int startY, int endX, int endY, Piece piece){
    if (startX > endX && startY > endY){
      for (int x = startX - 1; x > endX; x--){
        for (int y = startY - 1; y > endY; y--){
          if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
            return false;
        }
      }
    } else if (startX < endX && startY < endY){
      for (int x = startX + 1; x < endX; x++){
        for (int y = startY + 1; y < endY; y++){
          if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
            return false;
        }
      }
    } else if (startX > endX && startY < endY){
      for (int x = startX - 1; x > endX; x--){
        for (int y = startY + 1; y < endY; y++){
          if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
            return false;
        }
      }
    } else if (startX < endX && startY > endY){
      for (int x = startX + 1; x < endX; x++){
        for (int y = startY - 1; y > endY; y--){
          if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
            return false;
        }
      }
    } else if (startX == endX && startY > endY) {
      for (int y = startY - 1; y > endY; y--){
        int x = startX;
        if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
          return false;
      }
    } else if (startX == endX && startY < endY) {
      for (int y = startY + 1; y < endY; y++){
        int x = startX;
        if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
          return false;
        }
      } else if (startX > endX && startY == endY) {
        for (int x = startX - 1; x > endX; x--){
          int y = startY;
          if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
            return false;
        }
      } else {
        for (int x = startX + 1; x < endX; x++){
          int y = startY;
          if (piece.canMove(x, y) && Game.board.getSquare(x,y).getPiece() != null)
            return false;
        }
      }
    return true;
  }
  public void printBoard(){
    for (int y = 7; y >= 0; y--) 
    {
      System.out.print(y + 1 + " |");
			for (int x = 0; x < 8; x++) 
      {
        // Sets background color
        if ((x + y) % 2 == 0)
        {
          background = back1;
        }
        else 
        {
          background = back2;
        }
        if (boxes[x][y].getPiece() == null) 
        {
          System.out.print(background + "__" + ANSI_RESET);
        }
        else if (boxes[x][y].getPiece() instanceof Knight) 
        {
          if (boxes[x][y].getPiece().isWhite())
          {
            System.out.print(background + color1 + WHITE_KNIGHT + " " + ANSI_RESET);
          }
          else 
          {
            System.out.print(background + color2 + BLACK_KNIGHT + " " + ANSI_RESET);
          }
        }
        else if (boxes[x][y].getPiece() instanceof King)
        {
          if (boxes[x][y].getPiece().isWhite())
          {
            System.out.print(background + color1 + WHITE_KING + " " + ANSI_RESET);
          }
          else 
          {
            System.out.print(background + color2 + BLACK_KING + " " + ANSI_RESET);
          }
        }
        else if (boxes[x][y].getPiece() instanceof Queen)
        {
          if (boxes[x][y].getPiece().isWhite())
          {
            System.out.print(background + color1 + WHITE_QUEEN + " " + ANSI_RESET);
          }
          else 
          {
            System.out.print(background + color2 + BLACK_QUEEN + " " + ANSI_RESET);
          }
        }
        else if (boxes[x][y].getPiece() instanceof Rook)
        {
          if (boxes[x][y].getPiece().isWhite())
          {
            System.out.print(background + color1 + WHITE_ROOK + " " + ANSI_RESET);
          }
          else 
          {
            System.out.print(background + color2 + BLACK_ROOK + " " + ANSI_RESET);
          }
        }
        else if (boxes[x][y].getPiece() instanceof Bishop)
        {
          if (boxes[x][y].getPiece().isWhite())
          {
            System.out.print(background + color1 + WHITE_BISHOP + " " + ANSI_RESET);
          }
          else 
          {
            System.out.print(background + color2 + BLACK_BISHOP + " " + ANSI_RESET);
          }
        }
        else
        {
          if (boxes[x][y].getPiece().isWhite())
          {
            System.out.print(background + color1 + WHITE_PAWN + " " + ANSI_RESET);
          }
          else 
          {
            System.out.print(background + color2 + BLACK_PAWN + " " + ANSI_RESET);
          }
        }
			}
      System.out.println("|");
		}
    System.out.println("   a b c d e f g h" + ANSI_RESET);
  }

  public Square getSquare(String pieceName, int endX, int endY){
    for (int x = 0; x < 8; x++) 
    {
			for (int y = 0; y < 8; y++) 
      {
        if (boxes[x][y].getPiece() != null && boxes[x][y].getPiece().toString().equals(pieceName) && boxes[x][y].getPiece().canMove(endX, endY))
          return boxes[x][y];
			}
		}
    return null;
  }
  
  public Square getSquare(String pieceName){
    for (int x = 0; x < 8; x++) 
    {
			for (int y = 0; y < 8; y++) 
      {
        if (boxes[x][y].getPiece() != null && boxes[x][y].getPiece().toString().equals(pieceName))
          return boxes[x][y];
			}
		}
    return null;
  }
  public Square getSquare(String pieceName, String letter){
    int x = NumLetterConverter.letterToNum(letter);
			for (int y = 0; y < 8; y++) 
      {
        if (boxes[x][y].getPiece() != null && boxes[x][y].getPiece().toString().equals(pieceName))
          return boxes[x][y];
			}
    return null;
  }
  public Square getSquare(String pieceName, String strX, int endX, int endY){
    int x = NumLetterConverter.letterToNum(strX);
    for (int y = 0; y < 8; y++) 
    {
      if (boxes[x][y].getPiece() != null && boxes[x][y].getPiece().toString().equals(pieceName) && boxes[x][y].getPiece().canMove(endX, endY))
        return boxes[x][y];
    }
    return null;
  }
  public Square getSquare(String pieceName, int y){
    for (int x = 0; x < 8; x++) 
    {
      if (boxes[x][y].getPiece() != null && boxes[x][y].getPiece().toString().equals(pieceName))
        return boxes[x][y];
		}
    return null;
  }

	public Square getSquare(int x, int y)
	{
		if (x < 0 || x > 7 || y < 0 || y > 7) 
    {
			return boxes[0][0];
		}

		return boxes[x][y];
	}
  

	public void resetBoard(){
		// initialize white pieces
		boxes[0][0] = new Square(0, 0, new Rook(true, 0, 0));
		boxes[1][0] = new Square(1, 0, new Knight(true, 1, 0));
		boxes[2][0] = new Square(2, 0, new Bishop(true, 2, 0));
    boxes[3][0] = new Square(3, 0, new Queen(true, 3, 0));
    boxes[4][0] = new Square(4, 0, new King(true, 4, 0));
    boxes[5][0] = new Square(5, 0, new Bishop(true, 5, 0));
    boxes[6][0] = new Square(6, 0, new Knight(true, 6, 0));
    boxes[7][0] = new Square(7, 0, new Rook(true, 7, 0));
		boxes[0][1] = new Square(0, 1, new Pawn(true, 0, 0));
		boxes[1][1] = new Square(1, 1, new Pawn(true, 1, 1));
    boxes[2][1] = new Square(2, 1, new Pawn(true, 2, 1));
		boxes[3][1] = new Square(3, 1, new Pawn(true, 3, 1));
    boxes[4][1] = new Square(4, 1, new Pawn(true, 4, 1));
		boxes[5][1] = new Square(5, 1, new Pawn(true, 5, 1));
    boxes[6][1] = new Square(6, 1, new Pawn(true, 6, 1));
		boxes[7][1] = new Square(7, 1, new Pawn(true, 7, 1));

		// initialize black pieces
		boxes[0][7] = new Square(0, 7, new Rook(false, 0, 7));
		boxes[1][7] = new Square(1, 7, new Knight(false, 1, 7));
		boxes[2][7] = new Square(2, 7, new Bishop(false, 2, 7));
    boxes[3][7] = new Square(3, 7, new Queen(false, 3, 7));
    boxes[4][7] = new Square(4, 7, new King(false, 4, 7));
    boxes[5][7] = new Square(5, 7, new Bishop(false, 5, 7));
    boxes[6][7] = new Square(6, 7, new Knight(false, 6, 7));
    boxes[7][7] = new Square(7, 7, new Rook(false, 7, 7));
		boxes[0][6] = new Square(0, 6, new Pawn(false, 0, 6));
		boxes[1][6] = new Square(1, 6, new Pawn(false, 1, 6));
    boxes[2][6] = new Square(2, 6, new Pawn(false, 2, 6));
		boxes[3][6] = new Square(3, 6, new Pawn(false, 3, 6));
    boxes[4][6] = new Square(4, 6, new Pawn(false, 4, 6));
		boxes[5][6] = new Square(5, 6, new Pawn(false, 5, 6));
    boxes[6][6] = new Square(6, 6, new Pawn(false, 6, 6));
		boxes[7][6] = new Square(7, 6, new Pawn(false, 7, 6));

		// initialize remaining boxes without any piece
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[j][i] = new Square(j, i, null);
			}
		}
	}
}
