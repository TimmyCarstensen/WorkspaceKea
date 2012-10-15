package chess;

public class Pawn extends Piece{

	public Pawn(Color color) {
		super(color);
	}

	@Override
	public boolean isLegalMove(Position start, Position end, Board board){
		boolean isLegal = false;
		
		// Tjek that the start and end positions are within the boards bounds.
		// Tjek if there already is a piece at the end position
		// Tjek what color the piece at the end position have and compare to the moving piece
		if(end.getX() >= 0 && end.getX() < 8 && end.getY() >= 0 && end.getY() < 8 && 
				(board.getPiece(end) != null || board.getPiece(start).color != 
					board.getPiece(end).color)){
			// If the color is WHITE Pawn can only move with row++ except from initial position
			if(this.color.equals(Color.WHITE)){
				// tjek if it is the start position!
				if(start.getX() == 6 && (end.getX() == 4 || end.getX() == 5)){
				// else do this
				}else if(start.getX() > end.getX() ){
					
				}
			// If the color is BLACK Pawn can only move with row--, except from initial position
			}else if(this.color.equals(Color.BLACK)){
				
			}
		}
		
		return isLegal;
		
	} 
	
	@Override
	public char key() {
		return 'P';
	}
}