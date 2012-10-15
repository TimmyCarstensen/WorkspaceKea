package chess;

/**
 * PIECE IKKE F�RDIG
 * @author Timmy
 *
 */
public abstract class Piece
{

	protected final Color color;
	/**
     * CONSTRUCTOR F�RDIG, MANGLER KOMMENTARER!!!
     * Either P, R, N, B, Q, or K.
     */
	public Piece(Color color)
	{
		this.color = color;
	}
	
	/** 
	 * TOSTRING F�RDIG, MANGLER KOMMENTARER!!!
	 */
	public String toString()
	{	
		if(color == Color.WHITE){
			return "W"+key();
		}else {
			return "B"+key();
		}
	}
	
	/**
	 * ISLEGALMOVE F�RDIG, IKKE KOMMENTERET!!!
	 * @param start
	 * @param end
	 * @param board
	 * @return
	 */
	public boolean isLegalMove(Position start, Position end, Board board)
	{
		boolean isLegal = false;
		if(board.getPiece(end) != null){
			return isLegal = true;
		} else if(board.getPiece(start).color != board.getPiece(end).color){
			return isLegal = true;
		}
		return isLegal;
	}
	
	public abstract char key();
	
	/**
	 *	This class define the color of the player.
	 */
	public enum Color
	{
		WHITE, BLACK
	}

	
}

