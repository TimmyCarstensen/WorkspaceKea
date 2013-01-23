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
	 * Lavet af Kenneth og Matias
	 * @param customers, tager array'et fra resort.
	 */
	public void readInFileCustomers(ArrayList<Customer> customers)
	{
		
		File f = new File("customers");
		try 
		{
			// Scanner sættes til at læse filen customers
			this.input = new Scanner(f);

			// Tjekker for om filen har en næste linje
			while (input.hasNextLine())
			{
				// Læs næste linje i systemet
				String line = input.nextLine();

				// Linen splittes ud fra semikolon og sættes ind i et StringArray
				String[] values = line.split(";");

				// Objektet initialiseres og indsættes i array'et fra inputtet.
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
	 * @param cottages
	 */
	public void readInFileCottages(ArrayList<Cottage> cottages)
	{
		File f = new File("cottages");

		try {
			this.input = new Scanner(f);		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. File not found");
		}
		// Filen bliver læst og parset til resort.
		while (input.hasNextLine())
		{
			String line = input.nextLine();

			String[] values = line.split(";");

			if(values[0].equals("s"))
			{
				StandardCottage sc = new StandardCottage('s', values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Boolean.parseBoolean(values[4]));
				cottages.add(sc);
			} else if(values[0].equals("l"))
			{
				LuxuryCottage lc = new LuxuryCottage('l', values[1], Integer.parseInt(values[2]),Integer.parseInt(values[3]), Boolean.parseBoolean(values[4]));
				cottages.add(lc);
			}
		}
		input.close();
	}

	
	
	/**
	 * Lavet af Hisayo & Farhiya
	 * @param reservations
	 */
	public void readFromFileReservation(ArrayList<Reservation> reservations)
	{
		try
		{
			File f = new File("reservations");
			this.input = new Scanner(f);
			
			String inputLine = input.nextLine();
			this.resort.setResortAmount(Integer.parseInt(inputLine));
			//filen bliver læst og parset til resort.
			while ( input.hasNextLine())
			{
				inputLine = input.nextLine();
				
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

			    Reservation r = new Reservation(weeks, Integer.parseInt(valuesLine2[0]), valuesLine2[1], valuesLine2[2], this.resort, valuesLine2[3]);
			    r.setTotalPrice(Double.parseDouble(valuesLine2[4]));
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
	public void writeToFileCottages(ArrayList<Cottage> cottages)
	{
		File f = new File("cottages");

		try {
			FileOutputStream fos = new FileOutputStream(f, false);
			PrintStream output = new PrintStream(fos);
	
			//Skrives til fil.
			for(Cottage c : cottages)
			{
				StringBuilder sb = new StringBuilder();
				
				if(c.getTypeOfCottage() == 's')
				{
					sb.append("s;");
					sb.append(c.getCottageName() + ";");
					sb.append(c.getPrice() + ";");
					sb.append(c.getBeds() + ";");
					sb.append(c.getRenovation());
					
					
					output.println(sb.toString());
				}else if(c.getTypeOfCottage() == 'l')
				{
					sb.append("l;");
					sb.append(c.getCottageName() + ";");
					sb.append(c.getPrice() + ";");
					sb.append(c.getBeds() + ";");
					sb.append(c.getRenovation());
					
					output.println(sb.toString());
				}
			}

			output.close(); //remember to close

		} catch (IOException e) {
			System.out.println("File is not found!");
		}
	}	
	
	
	/**
	 * Lavet af Timmy
	 */
	public void writeToFileCustomers(ArrayList<Customer> customers)
	{
		File f = new File("customers");

		try {
			FileOutputStream fos = new FileOutputStream(f, false);
			PrintStream output = new PrintStream(fos);
			
			// Skrives til fil.
			for(Customer c : customers)
			{
				StringBuilder sb = new StringBuilder();
				
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
			System.out.println("File is not found!");
		}
	}	
	

	/**
	  * Lavet af Peter
	  */
	public void writeToFileReservations(ArrayList<Reservation> reservations) 
	{
		File f = new File ("reservations"); 

		try {

			FileOutputStream fos = new FileOutputStream (f, false);
			PrintStream output = new PrintStream(fos);
			
			// Det tjente beløb skrives til fil
			output.println(resort.getResortAmount());
			
			// 
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
				sb.append(r.getCustomer().getcvrNr_cprNr() + ";");
				sb.append(r.getID() + ";");
				sb.append(r.getTotalPrice());

				output.println(sb.toString());
				 
			}
			output.close();
		}

		catch (IOException e) 
		{
			System.out.println("File not found!");
		}
	}
}
