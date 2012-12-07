package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Matias
 */
public class Reservation {

	private int[] weeks;
	private int year; 
	private double totalPrice;
	private Cottage cottage;
	private Customer customer;
	private String ID; 
	private Integer number;
	private Scanner input;
	/**
	 * Bruges af parser til at læse en simpel reservation ind, med string-typer for cottage og customer.
	 * Timmy og Matias
	 * @param weeks
	 * @param totalPrice
	 * @param cottageName
	 * @param customer
	 */
	public Reservation(int[] weeks, int year, String cottageName, String cvrNr_cprNr, Resort resort, String ID)
	{
		this.weeks = weeks;
		this.year = year;
		this.cottage = resort.findCottageName(cottageName);
		this.cottage.assignNoVancancy(weeks, year);
		this.customer = resort.findCustomer(cvrNr_cprNr);
		this.ID = ID;
		calculatePrice();
	}
	
	/**
	 * Timmy og Matias
	 * Bruges af resort når vi skal oprette reservation via inputs fra den ansatte.
	 * @param weeks
	 * @param cottage
	 * @param customer
	 */
	public Reservation(int[] weeks, int year, Cottage cottage, Customer customer)
	{
		this.weeks = weeks;
		this.year = year;
		this.cottage = cottage;
		this.cottage.assignNoVancancy(weeks, year);
		this.customer = customer;
		calculatePrice();
		this.ID = createNumberID();
	}

	/**
	 * Denne bruges til at tjekke prisen på en reservation. En reservation bliver aldrig oprettet
	 * gennem denne constructor.
	 * @param weeks
	 * @param cottage
	 * @param customer
	 */
	public Reservation(int[] weeks, Cottage cottage, Customer customer)
	{
		this.weeks = weeks;
		this.cottage = cottage;
		this.customer = customer;
		calculatePrice(); 
	}
	
	/**
	 * Lavet af Timmy
	 * Bruges til at give en reservation et unikt ID.
	 */
	public String createNumberID()
	{
		// Vi får altid det næste nummer.
		readInIDFile();
		int lenghtOfNumber = number.toString().length();
		StringBuilder zeros = new StringBuilder();
		int numberOfZeros = 6 - lenghtOfNumber;
		while(numberOfZeros > 0)
		{
			zeros.append('0');
			numberOfZeros--;
		}
		
		this.ID = "SUNRE" + 2012 + "100A" + zeros.toString() + number.intValue();
		// Vi sørger for at nummeret bliver opdateret.
		writeToIDFile();
		
		return this.ID;
	}
	
	/**
	 * Bruges til at læse hvad nummer reservationsID er kommet til.
	 */
	public void readInIDFile()
	{
		File f = new File("reservationID");
		try 
		{
			this.input = new Scanner(f);
			String line = input.nextLine();
			this.number = Integer.parseInt(line);

		} catch (FileNotFoundException e)
		{
			System.out.println("Fil ikke fundet!!!!!");
		}
	}

	/**
	 * Skriver ud til fil og sikre at ID'et nummeret bliver opdateret.
	 */
	public void writeToIDFile() 
	{
		File f = new File ("reservationID"); 

		try {
			FileOutputStream fos = new FileOutputStream (f, false);
			PrintStream output = new PrintStream(fos);
			
			this.number = this.number.intValue() + 1;
			
			output.print(this.number);
		
			output.close();
		}
		catch (IOException e) 
		{
			System.out.println("error");
		}
	}
	
	
	/**
	 * Kenneth og Peter
	 * 
	 */
	public void calculatePrice()
	{
		double sum = 0.0;
		double[] weekPrices = new double[weeks.length];
		int i = 0;
		// Beregner pris for hver enkelt uge.
		for(int week : weeks){
			if (this.customer.getTypeOfCustomer() == 'f')
			{
				weekPrices[i]  = cottage.getPrice() * 0.9; 
			}
			else if(this.customer.getTypeOfCustomer() == 't')
			{
				weekPrices[i]  = cottage.getPrice();
			}
			if (Resort.seasonOfWeek(week) == Season.HIGH)
			{
				weekPrices[i] = weekPrices[i] * 1.4;	
			}
			else if (Resort.seasonOfWeek(week) == Season.LOW)
			{
				weekPrices[i] = weekPrices[i] * 0.7;
			}
			i++;
		}
		// Lægger prisen sammen for alle ugerne.
		for(double weekPrice : weekPrices)
		{
			sum = sum + weekPrice;
		}
		// TotalPrice bliver sat til den samlede pris
		this.totalPrice = sum;
	}
	
	/**
	 * Denne bruges til at registrere en betaling og sætter beløbet til 0.
	 */
	public void payForReservation()
	{
		this.totalPrice = 0;
	}
	
	public int[] getWeeks() {
		return weeks;
	}

	public void setWeeks(int[] weeks) {
		this.weeks = weeks;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice()
	{
		return this.totalPrice;
	}

	public void setTotalPrice(double price)
	{
		this.totalPrice = price;
	}
	
	public String getID()
	{
		return this.ID;
	}
}

