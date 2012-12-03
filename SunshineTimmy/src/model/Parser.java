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

				String[] values = line.split(";");

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
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. File not found");
		}
		// "\\z" to a delimiter gives the opputunity to read the whole file at once!
		while (input.hasNextLine())
		{
			String line = input.nextLine();

			String[] values = line.split(";");

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
				
				String[] valuesLine1 = inputLine.split(";");
				int[] weeks = new int[valuesLine1.length];
	
 				int i = 0;
				for(String v : valuesLine1)
 				{
 					weeks[i] = Integer.parseInt(v);
 					i++;    
 				}
				
				inputLine = input.nextLine();
				String[] valuesLine2 = inputLine.split(";");

			    Reservation r = new Reservation(weeks, Integer.parseInt(valuesLine2[0]), valuesLine2[1], valuesLine2[2], this.resort);
			    reservations.add(r);		
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
			FileOutputStream fos = new FileOutputStream(f, false);
			PrintStream output = new PrintStream(fos);
	
			for(Cottage h : hytter)
			{
				StringBuilder sb = new StringBuilder();
				
				if(h.getTypeOfCottage() == 's')
				{
					sb.append("s;");
					sb.append(h.getCottageName() + ";");
					sb.append(h.getPrice() + ";");
					sb.append(h.getBeds());
					
					
					output.println(sb.toString());
				}else if(h.getTypeOfCottage() == 'l')
				{
					sb.append("l;");
					sb.append(h.getCottageName() + ";");
					sb.append(h.getPrice() + ";");
					sb.append(h.getBeds());
					
					
					output.println(sb.toString());
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
				StringBuilder sb = new StringBuilder();
				//Ved ikke hvorvidt om brugen af hashCode er en god ide?
				if(c.getTypeOfCustomer() == 'f')
				{
					sb.append("f;");
					sb.append(c.getName() + ";");
					sb.append(c.getTelephoneNumber() + ";");
					sb.append(c.getAdress() + ";");
					sb.append(c.getEmail() + ";");
					sb.append(c.getcvrNr_cprNr());

					output.println(sb.toString());

				}else if(c.getTypeOfCustomer() == 't')
				{
					sb.append("t;");
					sb.append(c.getName() + ";");
					sb.append(c.getTelephoneNumber() + ";");
					sb.append(c.getAdress() + ";");
					sb.append(c.getEmail() + ";");
					sb.append(c.getcvrNr_cprNr());
					
					output.println(sb.toString());
				}
			}

			output.close(); //remember to close

		} catch (IOException e) {
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
				StringBuilder sb = new StringBuilder();
				String weeks = "";

				for(int week : r.getWeeks())
				{
					weeks += week + ";";
				}				
				sb.append(weeks + "\n");
				sb.append(r.getYear() + ";");
				sb.append(r.getCottage().getCottageName() + ";");
				sb.append(r.getCustomer().getcvrNr_cprNr());

				output.println(sb.toString());
				 
			}
			output.close();
		}

		catch (IOException e) 
		{
			System.out.println("error");
		}
	}
	


}
