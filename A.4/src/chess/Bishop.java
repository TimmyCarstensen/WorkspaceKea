package chess;

public class Bishop extends Piece{

	public Bishop(Color color) {
		super(color);
	}

	@Override
	public char key() {
		return 'B';
	}
}
