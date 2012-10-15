package chess;

public class Rook extends Piece{

	public Rook(Color color) {
		super(color);
	}

	@Override
	public char key() {
		return 'R';
	}

}
