package model;

/*
 * Farhiya
 * 
 */

public abstract class Kunde {

	private String navn;
	private int tlf; 
	private String adresse;
	private String email; 

	public Kunde(String navn, int tlf, String adresse, String email)
	{
		this.navn = navn;
		this.tlf = tlf;
		this.adresse = adresse;
		this.email = email;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNavn(){
		return this.navn;
		}

	public int getTlf(){
		return this.tlf;
	}

	public String getAdresse(){
		return this.adresse;
	}
	
	public String getEmail(){
		return this.email;
	}
}



