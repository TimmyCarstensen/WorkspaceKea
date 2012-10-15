package model;


import java.lang.Math;
/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// Because I created a construtor I can't follow the task text.
		Advokat lene = new Advokat("Lene Hansen");
		
		// This is how is would had looked otherwise.
		// Kontor kontor = new Kontor(); 
		// kontor.setAdvokat(lene);
		
		Kontor kontor = new Kontor(lene);
		
		
		// Tjekker her med System.out.println om kunden har penge.
		Kunde k1 = new Kunde();
		System.out.println("Kunden har penge: " + k1.hasMoney());
		k1.setWealth(10000);
		System.out.println("Kunden har penge: " + k1.hasMoney());
		
		// Assistent objects is created
		Assistent jens = new Assistent("Jens Jensen", 160.0);
		Assistent gert = new Assistent("Gert Petersen", 135.0);
		Assistent eva = new Assistent("Eva Hansen", 150.0);
		
		// Assistents is added to the office.
		kontor.addAssistent(jens);
		kontor.addAssistent(gert);
		kontor.addAssistent(eva);
		
		// Assistents is printed. 
		kontor.printAssistenter();
		
		// A System.out.println is called to check is beregnAssistentersGennemsnitsLøn fungerer
		System.out.println("Assistenters gennemsnitsløn er: " + kontor.beregnAssistentersGennemsnitsLoen());
	}
}
