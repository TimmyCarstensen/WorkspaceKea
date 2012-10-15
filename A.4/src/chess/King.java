package chess;

public class King extends Piece{

	public King(Color color) {
		super(color);
	}

	@Override
	public char key() {
		return 'K';
	}

}
