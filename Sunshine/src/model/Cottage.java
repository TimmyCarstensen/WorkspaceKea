package model;

import java.util.ArrayList;

/*
 * lavet af Hisayo
 */
public abstract class Cottage {
	
	protected char typeOfCottage;
	protected String CottageName;
	protected int price;
	protected int beds;
	protected boolean renovation;
	private ArrayList<Status> vacancy;
	
	public Cottage (char typeOfCottage, String cottageName, int price, int beds, boolean renovation)
	{
		this.typeOfCottage = typeOfCottage;
		this.CottageName = cottageName;
		this.price = price;
		this.beds = beds;
		this.renovation = renovation;
		this.vacancy = new ArrayList<Status>();
	}
	
	/**
	 * Tilføjer status til hytte så man kan se hvornår den er reserveret.
	 * @param weeks
	 * @param year
	 */
	public void assignNoVancancy(int[] weeks, int year)
	{
		for(int week : weeks)
		{
			vacancy.add(new Status(week, year));	
		}
	}
	
	/**
	 * Lavet af Timmy
	 * Bruges hvis vi sletter en reservation, så sletter vi også statuser.
	 * @param weeks
	 * @param year
	 */
	// burde fungerer, mangler at blive testet!!!!!
	public void assignVancancy(int[] weeks, int year)
	{
		int i = 0;
		for(int week : weeks)
		{
			for(Status status : vacancy)
			{	
				if(status.getWeek() == week && status.getYear() == year)
					{
					this.vacancy.remove(i);
					break;
					}
				i++;
			}
			i = 0;
		}
	}
	
	/**
	 * Lavet af Timmy
	 * Denne bruges i forhold til sikkerhed ved sletning af cottage.
	 * @return true if cottage has reservations otherwise false
	 */
	public boolean isReserved()
	{
		if(this.vacancy.size() == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Lavet af Timmy
	 * Søger efter en specifik status i cottage
	 * @param week
	 * @param year
	 * @return True if cottage is available, otherwise false.
	 */
	public boolean checkVacancy(int week, int year)
	{
		for(Status status : vacancy)
		{
			if(status.getWeek() == week && status.getYear() == year)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Lavet af Timmy
	 * Denne funktioner virker ved at tjekke ledighed af flere uger og benytter sig af
	 * chechVacancy som tjekker på en enkelt uge og status.
	 * @param weeks
	 * @param year
	 * @return
	 */
	public boolean checkVacancyWeeks(int[] weeks, int year)
	{
		boolean is = true;
		boolean[] vacancy = new boolean[weeks.length];
		int i = 0;
		for(int week : weeks)
		{
			vacancy[i] = checkVacancy(week, year);
			i++;
		}
		
		for(boolean isVacant : vacancy)
		{
			if(isVacant == false)
				is = false;
		}
		return is;
	}
		
	public String getCottageName()
	{
		return this.CottageName;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getBeds()
	{
		return beds;
	}
	
	public boolean getRenovation()
	{
		return renovation;
	}
	
	public char getTypeOfCottage()
	{
		return typeOfCottage;
	}
	
	public ArrayList<Status> getVacancy()
	{
		return this.vacancy;
	}
	
	public void setRenovation(boolean renovation)
	{
		this.renovation = renovation;
	}
	
	

}
