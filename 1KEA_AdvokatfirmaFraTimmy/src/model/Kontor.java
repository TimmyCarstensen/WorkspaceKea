package model;

import java.util.ArrayList;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Kontor {
	
	private Advokat advokat;
	private ArrayList<Assistent> assistenter;
	
	/**
	 * 
	 * @param advokat - assign new advokat
	 */
	public Kontor(Advokat advokat)
	{
		setAdvokat(advokat);
		assistenter = new ArrayList<Assistent>();
	}
	
	/**
	 * If an office is empty.
	 */
	public Kontor()
	{
		assistenter = new ArrayList<Assistent>();
	}
	
	/**
	 * 
	 * @param assistent - add assistent
	 */
	public void addAssistent(Assistent assistent)
	{
		if(assistent.getHourPay() >= 150)
			assistenter.add(assistent);
		else
			System.out.println("The assistent hour pay is too low! Assistent is not assigned to office!");
	}
	
	/**
	 * 
	 * @return double gennemsnitsloennen
	 */
	public double beregnAssistentersGennemsnitsLoen()
	{
		int i = 0;
		double gennemsnitsLoen = 0.0;
		for(Assistent a : assistenter)
		{
			gennemsnitsLoen += a.getHourPay();
			i++;
		}
		
		gennemsnitsLoen = gennemsnitsLoen / i;
		
		return gennemsnitsLoen;
	} 
	
	/**
	 * Printer alle assistenter fint ud
	 */
	public void printAssistenter()
	{
		for(Assistent a : assistenter)
		{
			System.out.println(a.getName() + ": " + a.getHourPay());
		}
	}
	
	
	// set and get methods for advokat.
	public Advokat getAdvokat(){return advokat;}
	public void setAdvokat(Advokat newAdvokat)
	{
		// we don't wont a lawyer with the name: Hans Hansen.
		if(!newAdvokat.getName().equalsIgnoreCase("Hans Hansen"))
			this.advokat = newAdvokat;
		else 
			System.out.println("No lawyer assigned to this office!");
	}
	
	
	
}
