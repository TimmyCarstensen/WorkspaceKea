package chess;

import java.util.Scanner;
import chess.Piece.Color;
import chess.Position;

/**
 * IKKE FÆRDIG, MANGLER KOMMENTARER!!!
 * @author Timmy
 *
 */
public class Game {
	
	private Board board;
	
	/**
	 * IKKE FÆRDIG, MANGLER KOMMENTARER
	 */
	public Game()
	{
		boolean quit = true;
		
		this.board = new Board();
		welcome();
		while(quit){
			
			System.out.print("> "); // hvordan skal jeg printe player1/player2?
			Scanner reader = new Scanner(System.in).useDelimiter(" ");
			String input = reader.nextLine().trim().toLowerCase();
			if(input.equals("quit")){
				System.out.println("Thanks for playing!!!");
				break;
			}if(input.equals("handshake")){
				board.setGameover(true);
			}else if(input.equals("board")){
				board.print();
			}else if(board.getGameover()){
				System.out.println("Game is over!");
				System.out.println("Enter 'quit' if you don't want to play no more.");
				System.out.println("Or enter 'restart' for another game.");
			}else if (!board.getGameover()){
			// move piece!
				String[] s = input.toUpperCase().split(" ");
				Position start = Position.fromRepresentation(s[0]);
				Position end = Position.fromRepresentation(s[1]);
				tryMovePiece(start, end);
				
			}
		}
	}
	
	public void welcome(){
		System.out.println("Welcome to chess!");
		System.out.println("player 1 is white (bottom); player 2 is black (top)");
		
	}
	
	/**
	 * IKKE FÆRDIG, MANGLER KOMMENTARER!!!
	 */
	public void restart()
	{
	
	}
	
	/**
	 * IKKE FÆRDIG, MANLGER KOMMENTARER!!!
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean tryMovePiece(Position start, Position end)
	{
		if(board.getPiece(start).color == Color.WHITE){
			return board.tryMovePiece(Color.WHITE, start, end);
		}else{
			return board.tryMovePiece(Color.BLACK, start, end);
		}
	}
	
	
}


