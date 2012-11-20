package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Resort {
	private int weekNumber;
	private int year;
	private Season season; 
	private ArrayList<Cottage> cottages;
	private ArrayList<Reservation> reservations;
	private ArrayList<Customer> customers;
	private Parser parser;

	/**
	 * 
	 */
	public Resort()
	{
		this.cottages = new ArrayList<Cottage>();
		this.reservations = new ArrayList <Reservation>();
		this.customers = new ArrayList <Customer>();
		this.parser = new Parser(this);

		time();
		this.season = seasonOfWeek(this.weekNumber);
		
		
		
		parser.readInFileCottages(cottages);
		parser.readInFileCustomers(customers);
		parser.readFromFileReservation(this.reservations);


		// Se vores flotte system print out! :D Wuhaaaaj :D
		System.out.println("Årstal: " + this.year + "\nUge nr: " + weekNumber);
	}

	/**
	 * Hisayo, Fahiya og Timmy
	 */
	public void time()
	{
		Calendar c = Calendar.getInstance();
		weekNumber = c.get(Calendar.WEEK_OF_YEAR);
		year = c.get(Calendar.YEAR);
	}

	
	
	/**
	 * Kenneth
	 * @param weeks
	 * @param year
	 * @param cottage
	 * @param customer
	 */
	public void createReservation(int[] weeks, int year, Cottage cottage, Customer customer)
	{
		Reservation r = new Reservation(weeks, year, cottage, customer);
		this.reservations.add(r); 
	}

	/**
	 * Kenneth
	 */
	public void createTourist(char typeOfCustomer, String name, String telephoneNumber, String adress, String email, String cvrNr_cprNr)
	{
		TuristCustomer turistCustomer = new TuristCustomer(typeOfCustomer, name, telephoneNumber, adress, email, cvrNr_cprNr );
		customers.add(turistCustomer);
	}


	/**
	 * Kenneth
	 */
	public void createFirm(char typeOfCustomer, String name, String telephoneNumber, String adress, String email, String cvrNr)
	{
		FirmCustomer firmCustomer = new FirmCustomer(typeOfCustomer, name, telephoneNumber, adress, email, cvrNr);
		customers.add(firmCustomer);
	}


	/**
	 * Hisayo, Farhiya og Matias
	 */
	public Cottage findCottageName(String CottageName)
	{
		for (Cottage c : cottages)
		{
			
			if (CottageName.equalsIgnoreCase(c.getCottageName()))
			{
				return c;
			}
		}
		return null;
	}


	/**
	 * Peter & Kenneth
	 */

	public Customer findCustomer (String cvrNr_cprNr) 
	{ 
		for (Customer c : customers)
		{
			if (cvrNr_cprNr.equalsIgnoreCase(c.getcvrNr_cprNr()))
			{
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Matias
	 * @param cottageName
	 * @return
	 */
	public boolean findCottage(String cottageName)
	{
		for( Cottage c : cottages)
		{
			if(cottageName.equalsIgnoreCase(c.getCottageName()))
				return true;
		}
		return false;
	}
	
	public boolean makeRenovation() 
	{
		return false;

	}

	

	//Mangler implementation!!!!
	public void pay()
	{

	}
	/**
	 * Kenneth
	 */
	public void createStandardCottage(char typeOfCottage, String cottageName, int price, int beds)
	{
		StandardCottage standardCottage = new StandardCottage(typeOfCottage, cottageName, price, beds);
		cottages.add(standardCottage);
	}
	
	/**
	 * Kenneth
	 */
	public void createluxuryCottage(char typeOfCottage, String cottageName, int beds, int price)
	{
		LuxuryCottage luxuryCottage = new LuxuryCottage(typeOfCottage,cottageName, beds, price );
		cottages.add(luxuryCottage);
	}

	/**
	 * Matias
	 * @param Cottagename
	 */
	public void deleteCottage(String cottageName)
	{
		for(Cottage c : cottages)
		{
			if(cottageName.equals(c.getCottageName()))
				cottages.remove(c);
		}
	}
	
	/**
	 * Lavet af Peter
	 * Bruges både af Reservationsklassen og resortklassen!
	 */
	public static Season seasonOfWeek(int weekNumber)
	{		
		if (weekNumber >= 49 && weekNumber < 53 || weekNumber > 0 && weekNumber <= 10 )
			return Season.LOW;
		if (weekNumber >= 11 && weekNumber <= 21 || weekNumber >= 39 && weekNumber <= 48)
			return Season.MEDIUM;
		else //if (weekNumber >= 22 || weekNumber <= 38)
			return Season.HIGH;
	}
	
	/**
	 *Farhiya & Hisayo
	 */
	public void createRenovation(String cottageName)
	{ 
		for( Cottage cottage : cottages)
		{
			if( cottage.getRenovation() == false && cottage.getCottageName().equals(cottageName) )
			{
				cottage.setRenovation(true);
				//System.out.println(cottage.getCottageName() + " is under renovation!");
			}
		}
	}
	
	/**
	 * Farhiya & Hisayo
	 * @param cottageName
	 */
	public void deleteRenovation(String cottageName)
	{
		for( Cottage cottage : cottages)
		{
			if( cottage.getRenovation() == true && cottage.getCottageName().equals(cottageName))
			{
				cottage.setRenovation(false);
				//System.out.println(cottage.getCottageName() + " is available");
			}
		}
	}

	/**
	 * Timmy
	 */
	public void quit()
	{
		parser.writeToFileCottages(this.cottages);
		parser.writeToFileCustomers(this.customers);
		parser.writeToFileReservations(this.reservations);
	}
	
	public Season getSeason()
	{
		return this.season;
	}

	public int getWeekNumber()
	{
		return this.weekNumber;
	}
}