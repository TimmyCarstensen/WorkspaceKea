package model;

/*
 * Lavet af Hisayo.
 */
public class Luksus extends Hytte {
	
	public Luksus ( int pris, int senge, String hytteNavn)
	{
		super(pris, senge, hytteNavn);
	}

	@Override
	public int hashCode()
	{
		return 100111;
	}
	
	
}
