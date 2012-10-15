package chess;

import chess.Piece.Color;
import java.lang.StringBuilder;

/**
 * IKKE FÆRDIG, MANGLER KOMMENTARER!!!
 * @author Timmy
 *
 */
public class Board {
	private Piece[][] board;
	private boolean gameover;
	private Color winner;
	
	/**
	 * FÆRDIG, MANGLER KOMMENTARER!!!
	 */
	public Board()
	{
		board = new Piece[8][8];
		gameover = false;
		initialize();
		print();
	}
	
	
	/**
	 * FÆRDIG!!! (Kan indeholde fejl!)
	 * @param playerColor
	 * @param start - start position, before moved
	 * @param end - end position, after moved
	 * @return
	 */
	public boolean tryMovePiece(Color playerColor, Position start, Position end){
		boolean temp = false;
		if(gameover){
			System.out.println("Game over, want to start a new one then type 'restart'!");
			return temp;
		}else if(getPiece(start) == null){
			return temp;
		}else if(playerColor != getPiece(start).color){
			return temp;
		}else if(getPiece(start).isLegalMove(start, end, this)){
			// Tjeks if the game is over and change the gameover field to true
			if(getPiece(end).toString().equals("WK")){
				gameover = true;
				this.winner = Color.WHITE;
			}else if(getPiece(end).toString().equals("BK")){
				gameover = true;
				this.winner = Color.BLACK;
			}
			// Piece is moved to new position
			board[end.getX()][end.getY()] = getPiece(start);
			board[start.getX()][start.getY()] = null;
			temp = true;
		}else{
			System.out.print("Not legal move!");
		}
		return temp;
	}
	
	public Color getWinner(){return winner;}
	public boolean getGameover(){return gameover;}
	public void setGameover(boolean over){this.gameover = over;}
	
	/**
	 * Færdig!!!
	 * Creates the board with the chess pieces.
	 */
	public void initialize(){
		for (int row = 1; row < 7; row++) {
			for (int column = 0; column < board[row].length; column++) {
				if(board[row][column] == null && row == 1){
					board[row][column] = new Pawn(Color.BLACK);
				}else if(board[row][column] == null && row == 6){
					board[row][column] = new Pawn(Color.WHITE); 
				
				}
			}
		}
		board[0][4] = new King(Color.BLACK);
		board[7][4] = new King(Color.WHITE);
	}
	
	
	
	
	/**
	 * FÆRDIG!
	 * Return true if and only if all the specified positions contain the value null, 
	 * and false otherwise.
	 * @param positions
	 * @return
	 */
	public boolean allPositionsAraEmpty(Position[] positions){
		boolean empty = true;
		for(Position elem : positions){
			if(board[elem.getX()][elem.getY()] != null){
				empty = false;
			}
		}
		return empty;
	}
	
	/**
	 * Færdig, mangler kommentarer!!!
	 * @param position
	 * @return
	 */
	public Piece getPiece(Position position)
	{
		return board[position.getX()][position.getY()];
	}
	
	/**
	 * FÆRDIG, MANGLER KOMMENTARER!!!
	 */
	public String humanReadableState(){
		StringBuilder builder = new StringBuilder();
		for(int row = 0; row < board.length; row++){
			for(int column = 0; column < board[row].length; column++){
				String temp = "";
				if(board[row][column] == null){temp = "00";}
				else if(board[row][column] != null){temp = board[row][column].toString();}
				builder.append(temp + " ");
			}
			builder.append("\n");
		}
		String result = builder.toString();
		return result;
	}
	
	/**
	 * Færdig!!!
	 * Prints the current state of the board.
	 */
	public void print(){
		System.out.print(humanReadableState());
	
	}	
}
