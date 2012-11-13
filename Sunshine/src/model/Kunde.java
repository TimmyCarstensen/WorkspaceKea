package model;

/*
 * Farhiya
 * 
 */

public class Kunde {

	private String navn;
	private int tlf; 
	private String adresse;
	private String email; 
	


	public String getnavn(){
		return this.navn; 
	}

	public int getTlf(){
		return this.tlf;
	}

	public String getadresse(){
		return this.adresse;
	}
	
	public String getemail(){
		return this.email;
	}
}



