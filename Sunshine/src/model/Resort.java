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
	private String[] weeksAll = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52"};
	private String[] year20Forward;
	/**
	 * Systemet skal lukkes ned hver dag!
	 */
	public Resort()
	{
		this.cottages = new ArrayList<Cottage>();
		this.reservations = new ArrayList <Reservation>();
		this.customers = new ArrayList <Customer>();
		this.parser = new Parser(this);

		time();
		this.season = seasonOfWeek(this.weekNumber);
		createYears20Forward();


		parser.readInFileCottages(cottages);
		parser.readInFileCustomers(customers);
		parser.readFromFileReservation(this.reservations);

		//		Se udprint af status fra cottages arrayList ;)
		//		for(Cottage c : cottages)
		//		{
		//			c.printStatus();
		//		}

		// Se vores flotte system print out! :D Wuhaaaaj :D
//		System.out.println("Årstal: " + this.year + "\nUge nr: " + weekNumber);
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

	//Mangler implementation!!!!
	public void pay()
	{

	}

	/**
	 * return true means cottage available of this type, false mean no cottage
	 * of this type availably.
	 * @param weeks
	 * @return
	 */
	public boolean checkCottageVancancy(int[] weeks, int year, int beds, char typeOfCottage)
	{
		for(Cottage cottage : cottages)
		{
			if(typeOfCottage == cottage.getTypeOfCottage() && beds == cottage.getBeds())
			{
				return cottage.checkVacancyWeeks(weeks, year);
			}
		}
		return false;
	}
	
	/**
	 * can return null
	 * @param weeks
	 * @param year
	 * @param typeOfCottage
	 * @param beds
	 * @return
	 */
	public Cottage getVacantCottage(int[] weeks, int year, int beds, char typeOfCottage)
	{
		for(Cottage c : cottages)
		{
			if(c.checkVacancyWeeks(weeks, year) && c.getTypeOfCottage() == typeOfCottage && c.getBeds() == beds)
				return c;
		}
		
		return null;
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

	public int[] createWeekArray(int startWeek, int endWeek)
	{
		int[] weeks = new int[endWeek - startWeek + 1];
		int i = 0;
		while(!(startWeek > endWeek))
		{
			weeks[i] = startWeek;
			startWeek++;
			i++;
		}
		
		return weeks;
	}
	
	/**
	 * Kenneth
	 */
	public void createCustomer(char typeOfCustomer, String name, String telephoneNumber, String adress, String email, String cvrNr_cprNr)
	{
		if(typeOfCustomer == 't')
		{
			TuristCustomer turistCustomer = new TuristCustomer(typeOfCustomer, name, telephoneNumber, adress, email, cvrNr_cprNr );
			customers.add(turistCustomer);
		}
		else if(typeOfCustomer == 'f')
		{
			FirmCustomer firmCustomer = new FirmCustomer(typeOfCustomer, name, telephoneNumber, adress, email, cvrNr_cprNr);
			customers.add(firmCustomer);	
		}
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
	 * Lavet af Farhiya og Matias
	 * @param ID
	 * @return
	 */
	public Reservation findReservation(String ID)
	{
		for(Reservation r : reservations)
		{
			if(r.getID().equalsIgnoreCase(ID))
				return r;
		}
		return null;
	}
	
	/**
	 * Matias
	 * Skal bruges til at tjekke inden en cottage skal slettes.
	 * @param cottageName
	 * @return
	 */
	public boolean isCottageInArray(String cottageName)
	{
		for( Cottage c : cottages)
		{
			if(cottageName.equalsIgnoreCase(c.getCottageName()))
				return true;
		}
		return false;
	}


	/**
	 * Kenneth
	 */
	public void createCottage(char typeOfCottage, String cottageName, int price, int beds, boolean renovation)
	{
		if(typeOfCottage == 'l')
		{
			LuxuryCottage luxuryCottage = new LuxuryCottage(typeOfCottage,cottageName, price, beds, renovation);
			cottages.add(luxuryCottage);
		}
		else if (typeOfCottage == 's')
		{	
			StandardCottage standardCottage = new StandardCottage(typeOfCottage, cottageName, price, beds, renovation);
			cottages.add(standardCottage);
		}
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
			{
				cottages.remove(c);
				return;
			}
				
		}
	}


	// This function make that a customer can't be deleted if the customer has a reservation.
	public boolean doesCustomerHaveReservation(String cvr_cpr_nr)
	{
		for(Reservation r : reservations)
		{
			if(r.getCustomer().getcvrNr_cprNr().equalsIgnoreCase(cvr_cpr_nr))
				return true;
		}
		
		return false;
	}
	
	public void deleteCustomer(String cvr_cpr_nr)
	{
		for(Customer c : this.customers)
		{
			if(cvr_cpr_nr.equalsIgnoreCase(c.getcvrNr_cprNr()))
			{
				customers.remove(c);
				return;
			}
		}
	}
	
	public void deleteReservation(String ID)
	{
		for(Reservation r : this.reservations)
		{
			if(r.getID().equalsIgnoreCase(ID))
			{
				reservations.remove(r);
				return;
			}
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
		findCottageName(cottageName).setRenovation(true);
		System.out.println(findCottageName(cottageName).getRenovation());
		
		
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

	/**
	 * 
	 * @return
	 */
	// Is used by reservationclass to create inputs to the combobox there.
	public String[] getCustomerArray()
	{
		String[] customerArray = new String[customers.size()];
		int i = 0;
		for(Customer c : customers)
		{
			customerArray[i] = c.getcvrNr_cprNr() + " " + c.getName();
			i++;
		}
		return customerArray;
	}
	
	public void createYears20Forward()
	{
		int tempYear = this.year;
		String[] year20Forward = new String[20];
		for(int i = 0; i < 20; i++)
		{
			year20Forward[i] = Integer.toString(tempYear);
			tempYear++;
		}
		this.year20Forward = year20Forward;
	}
	
	
	public String[] getWeeksAll()
	{
		return this.weeksAll;
	}
	
	public String[] getYear20Forward()
	{
		return this.year20Forward;
	}
	
	public Season getSeason()
	{
		return this.season;
	}

	public int getYear()
	{
		return this.year;
	}
	
	public int getWeekNumber()
	{
		return this.weekNumber;
	}
	
	public ArrayList<Cottage> getCottages()
	{
		return this.cottages;
	}
	
	public ArrayList<Customer> getCustomer()
	{
		return this.customers;
	}
	
	public ArrayList<Reservation> getReservation()
	{
		return this.reservations;
	}
}