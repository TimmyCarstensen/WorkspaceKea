package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class FerieSted {
	private int ugeNr;
	private Sæson sæson;
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
				Standard sh = new Standard(Integer.parseInt(værdier[3]),Integer.parseInt(værdier[2]), værdier[1]);
				this.hytter.add(sh);
			}
		}
		input.close();
	}

	public void læsHytterTilFil()
	{
		File f = new File("hytter");
		
		try {
			
			FileOutputStream fos = new FileOutputStream(f, true);
			PrintStream output = new PrintStream(fos);
//			output.println();
			for(Hytte h : this.hytter)
			{
				String temp = "";
				//Ved ikke hvorvidt om brugen af hashCode er en god ide?
				if(h.hashCode() == 100111)
				{
					temp = temp + "s,";
					temp = temp + h.getHytteNavn() + ",";
					temp = temp + h.getSenge() + ",";
					temp = temp + h.getPris();
					output.println(temp);
				//Ved ikke hvorvidt om brugen af hashCode er en god ide?
				}else if(h.hashCode() == 200222)
				{
					temp = temp + "s,";
					temp = temp + h.getHytteNavn() + ",";
					temp = temp + h.getSenge() + ",";
					temp = temp + h.getPris();
					output.println(temp);
				}
			}
			
			output.close(); //remember to close

		} catch (IOException e) {
			//handle an exception by telling the user that something went wrong.
			System.out.println("Something went wrong!");
		}
	}	
	
	public int beregnPris()
	{
		return 0;

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
	
	public int getUgeNr()
	{
		return this.ugeNr;
	}

}
