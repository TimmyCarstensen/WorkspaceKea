package model;
//Lavet af Farhiya
public class Firma extends Kunde {

	private int cvrNr;

	public Firma(String navn, int tlf, String adresse, String email, int cvrNr)
	{
		super(navn, tlf, adresse, email);
		this.cvrNr = cvrNr;
	}
	
	public int getCvrNr()
	{
		return cvrNr;
	}
	
	public void setCvrNr (int newCvrNr)
	{
		this.cvrNr = newCvrNr;
	}
}
