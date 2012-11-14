package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FerieSted {
	private int ugeNr;
	private Saeson Saeson;
	private ArrayList<Hytte> hytter;
	private ArrayList<Reservation> reservationer;
	private ArrayList<Kunde> kunder;
	private Scanner input;

	public FerieSted()
	{
		this.hytter = new ArrayList<Hytte>();
		this.reservationer = new ArrayList <Reservation>();
		this.kunder = new ArrayList <Kunde>();
	}

	public void læsHytterFraFil()
	{
		File f = new File("hytter");

		try {
			this.input = new Scanner(f);		
//			this.input.useDelimiter(",");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. File not found");
		}
		// "\\z" to a delimiter gives the opputunity to read the whole file at once!
		while (input.hasNextLine())
		{
			String line = input.nextLine();
//			System.out.println(item);
			
			// hver linje indeholder: hyttetype , hyttenavn, antalsenge, pris
			
			String[] værdier = line.split(",");
			
			if(værdier[0].equals("s"))
			{
				Standard sh = new Standard(Integer.parseInt(værdier[3]),Integer.parseInt(værdier[2]), værdier[1]);
				this.hytter.add(sh);
			} else if(værdier[0].equals("l"))
			{
				Luksus lh = new Luksus(Integer.parseInt(værdier[3]),Integer.parseInt(værdier[2]), værdier[1]);
				this.hytter.add(lh);
			}
		}
		input.close();
	}

	public void læsReservationer()
	{
		File f = new File("reservationer");

		try {
			this.input = new Scanner(f);
		}

		catch (FileNotFoundException e)
		{
			System.out.println("Fil ikke fundet!");
		}
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			String[] reservationer = line.split(".");
			Reservation r1 = new Reservation();
			this.reservationer.add(r1);

		}
		input.close();
		for(Reservation r : reservationer)
		{
			//System.out.println("Hej" + r.getHytteNavn());
		}
	}
	public int beregnPris()
	{
		return ugeNr;

	}

	public void printHytteArray()
	{
		for(Hytte h : hytter)
		{
			System.out.println("Jeg eksisterer i mit array med en pris p� " + h.getPris());
		}
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
