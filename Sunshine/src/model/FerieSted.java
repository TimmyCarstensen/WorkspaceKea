package model;

import java.util.ArrayList;


public class FerieSted {
	private int ugeNr;
	private Sæson sæson;
	private ArrayList<Hytte> hytter = new ArrayList<Hytte>();
	private ArrayList<Reservation> reservationer = new ArrayList <Reservation>();
	private ArrayList<Kunde> kunder = new ArrayList <Kunde>();

	public int beregnPris()
	{
		return ugeNr;
		
	}
	
	public void opretKunde() 
	{
		
	}
	
	public boolean lavRenovation() 
	{
		return false;
		
	}
	
	public void opretRenovation(boolean lavRenovation)
	{
		
	}
	
	public void sletRenovation()
	{
		
	}
	
	public void betal()
	{
		
	}
	
	public void opretHytte()
	{
		
	}
	
	public void sletHytte()
	{
		
	}
	
	public void setSæson()
	{
		
	}
	
}
