package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Parser {

	private Scanner input;
	private Resort resort;
	
	public Parser(Resort resort)
	{
		this.resort = resort;
	}
	/**
 * 
 * @author Matias og Kenneth
 *
 */

	public void readInFileCustomers(ArrayList<Customer> customers)
	{
		File f = new File("customers");
		try 
		{
			this.input = new Scanner(f);

			while (input.hasNextLine())
			{
				String line = input.nextLine();

				String[] values = line.split(",");

				// typeOfCustomer, name, telephoneNumber, adress, email, cprNr
				if(values[0].equals("t"))
				{
					TuristCustomer turistCustomer = new TuristCustomer('t', values[1], values[2], values[3], values[4], values[5]);
					customers.add(turistCustomer);
				}
				else if (values[0].equals("f"))
				{
					FirmCustomer firmCustomer = new FirmCustomer('f', values[1], values[2], values[3], values[4], values[5]);
					customers.add(firmCustomer);
				}

			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Fil ikke fundet!!!!!");
		}
	}


	/**
	 * Lavet af Timmy
	 * @param hytter
	 */
	public void readInFileCottages(ArrayList<Cottage> hytter)
	{
		File f = new File("cottages");

		try {
			this.input = new Scanner(f);		
			//		this.input.useDelimiter(",");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. File not found");
		}
		// "\\z" to a delimiter gives the opputunity to read the whole file at once!
		while (input.hasNextLine())
		{
			String line = input.nextLine();

			// hver linje indeholder: hyttetype , hyttenavn, pris, antalsenge, 

			String[] values = line.split(",");

			if(values[0].equals("s"))
			{
				StandardCottage sc = new StandardCottage('s', values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
				hytter.add(sc);
			} else if(values[0].equals("l"))
			{
				LuxuryCottage lc = new LuxuryCottage('l', values[1], Integer.parseInt(values[2]),Integer.parseInt(values[3]));
				hytter.add(lc);
			}
		}
		input.close();
	}

	
	
	// Lavet af Hisayo & Farhiya
	
	public void readFromFileReservation(ArrayList<Reservation> reservations)
	{
		try
		{
			File f = new File("reservations");
			this.input = new Scanner(f);
			
			while ( input.hasNextLine())
			{
				String inputLine = input.nextLine();
				
				String[] valuesLine1 = inputLine.split(",");
				int[] weeks = new int[valuesLine1.length];

				//example	weeks[0] = v;	
 				int i = 0;
				for(String v : valuesLine1)
 				{
 					weeks[i] = Integer.parseInt(v);
 					i++; //i = i + 1;    
 				}
				
				inputLine = input.nextLine();
				String[] valuesLine2 = inputLine.split(",");
				//String[] price = new String [values.length];
			    Reservation r = new Reservation(weeks, Integer.parseInt(valuesLine2[0]), valuesLine2[1], valuesLine2[2], this.resort);
			    reservations.add(r);
			   	
				//new Reservation(weeks, price, cottageName, customer)
		
			}
		}catch(FileNotFoundException e)
		{
			System.out.println("File is not found.");
		}
		input.close();
	}
	
	
	
	/**
	 * Lavet af Timmy
	 */
	public void writeToFileCottages(ArrayList<Cottage> hytter)
	{
		File f = new File("cottages");

		try {
			// filOutputStream skal have en boolean værdi med som input, hvis false overskriver
			// den filen, hvis true skriver den på enden af filen.
			FileOutputStream fos = new FileOutputStream(f, false);
			PrintStream output = new PrintStream(fos);
			//			output.println();
			for(Cottage h : hytter)
			{
				String temp = "";
				if(h.getTypeOfCottage() == 's')
				{
					temp = temp + "s,";
					temp = temp + h.getCottageName() + ",";
					temp = temp + h.getBeds() + ",";
					temp = temp + h.getPrice();
					output.println(temp);
				}else if(h.getTypeOfCottage() == 'l')
				{
					temp = temp + "l,";
					temp = temp + h.getCottageName() + ",";
					temp = temp + h.getBeds() + ",";
					temp = temp + h.getPrice();
					output.println(temp);
				}
			}

			output.close(); //remember to close

		} catch (IOException e) {
			//handle an exception by telling the user that something went wrong.
			System.out.println("Something went wrong!");
		}
	}	
	
	
	/**
	 * Lavet af Timmy
	 */
	public void writeToFileCustomers(ArrayList<Customer> customers)
	{
		File f = new File("customers");

		try {
			// filOutputStream skal have en boolean værdi med som input, hvis false overskriver
			// den filen, hvis true skriver den på enden af filen.
			FileOutputStream fos = new FileOutputStream(f, false);
			PrintStream output = new PrintStream(fos);
			// typeOfCustomer, name, telephoneNumber, adress, email
			for(Customer c : customers)
			{
				String temp = "";
				//Ved ikke hvorvidt om brugen af hashCode er en god ide?
				if(c.getTypeOfCustomer() == 'f')
				{
					c = (FirmCustomer) c;
					temp += "f,";
					temp += c.getName() + ",";
					temp += c.getTelephoneNumber() + ",";
					temp += c.getAdress() + ",";
					temp += c.getEmail() + ",";
					temp += c.getcvrNr_cprNr();

					output.println(temp);
					//Ved ikke hvorvidt om brugen af hashCode er en god ide?
				}else if(c.getTypeOfCustomer() == 't')
				{
					temp += "t,";
					temp += c.getName() + ",";
					temp += c.getTelephoneNumber() + ",";
					temp += c.getAdress() + ",";
					temp += c.getEmail() + ",";
					temp += c.getcvrNr_cprNr();
					
					output.println(temp);
				}
			}

			output.close(); //remember to close

		} catch (IOException e) {
			//handle an exception by telling the user that something went wrong.
			System.out.println("Something went wrong!");
		}
	}	
	

	/**
	  * Lavet af Peter
	  */
	public void writeToFileReservations(ArrayList<Reservation> reservations) 
	{
		File f = new File ("reservations"); 

		try {
			// filOutputStream skal have en boolean værdi med som input, hvis false overskriver
			// den filen, hvis true skriver den på enden af filen.
			FileOutputStream fos = new FileOutputStream (f, false);
			PrintStream output = new PrintStream(fos);

			for(Reservation r : reservations)
			{
				String temp = "";
				String weeks = "";

				for(int week : r.getWeeks())
				{
					weeks += week + ",";
				}				

				temp += weeks + "\n";
				temp += r.getYear() + ",";
				temp += r.getCottage().getCottageName() + ",";
				temp += r.getCustomer().getcvrNr_cprNr();

				output.println(temp);
				 
			}
			output.close();
		}

		catch (IOException e) 
		{
			System.out.println("error");
		}
	}
	


}
