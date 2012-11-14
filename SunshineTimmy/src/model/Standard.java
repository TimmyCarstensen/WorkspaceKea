package model;

/*
 * Lavet af Hisayo
 */
public class Standard extends Hytte{
	
	public Standard ( int pris, int senge, String hytteNavn)
	{
		super( pris, senge, hytteNavn);
	}
	
	@Override
	public int hashCode()
	{
		return 200222;
	}
	

}
