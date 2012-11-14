package model;

// Matias

public class Reservation {

	private double totalPris;
	private Hytte hytteNavn; 
	private Kunde kunde;
	private int [] Uger;
	
	

	public double getTotalPris() 
	{
		return totalPris;
	}
	public Hytte getHytteNavn() 
	{
		return hytteNavn;
	}
	public Kunde getKunde() 
	{
		return kunde;
	}
	
	public void setHytteNavn(Hytte nyHytte)
	{
		this.hytteNavn = nyHytte;
	}
	
	public void setKunde(Kunde nyKunde)
	{
		this.kunde = nyKunde;
	}
	
}

