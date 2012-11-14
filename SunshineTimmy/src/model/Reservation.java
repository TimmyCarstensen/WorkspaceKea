package model;

// Matias

public class Reservation {

	private int antalUger;
	private int ugeNr;
	private double totalPris;
	private Hytte hytteNavn; 
	private Kunde kunde;
	
	
	public Reservation(int antalUger, int ugeNr, double totalPris, Hytte hytteNavn, Kunde kunde) {
		this.antalUger = antalUger;
		this.ugeNr = ugeNr;
		this.totalPris = totalPris;
		this.hytteNavn = hytteNavn;
		this.kunde = kunde;
	}
	
	public int getAntalUger() {
		return antalUger;
	}
	
	public int getUgeNr() {
		return ugeNr;
	}
	
	public double getTotalPris() {
		return totalPris;
	}
	
	public Hytte getHytteNavn() {
		return hytteNavn;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	
	public void setAntalUger(int antalUger) {
		this.antalUger = antalUger;
	}
	public void setUgeNr(int ugeNr) {
		this.ugeNr = ugeNr;
	}
	
	public void setTotalPris(double totalPris) {
		this.totalPris = totalPris;
	}
	
	public void setHytteNavn(Hytte hytteNavn) {
		this.hytteNavn = hytteNavn;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
}

