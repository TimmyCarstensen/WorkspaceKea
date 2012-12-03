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
	
	public Cottage (char typeOfCottage, String cottageName, int price, int beds)
	{
		this.typeOfCottage = typeOfCottage;
		this.CottageName = cottageName;
		this.price = price;
		this.beds = beds;
		this.renovation = false;
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
	 * Bruges hvis vi sletter en reservation, så sletter vi også statuser.
	 * @param weeks
	 * @param year
	 */
	// burde fungerer, mangler at blive testet!!!!!
	public void assignVancancy(int[] weeks, int year)
	{
		int i = 0;
		for(Status status : vacancy)
		{
			for(int week : weeks)
			{	
				if(status.getWeek() == week && status.getYear() == year)
				vacancy.remove(i);	
			}
			i++;		
		}
	}
	
	/**
	 * Lavet af Timmy
	 * @param week
	 * @param year
	 * @return
	 */
	// Muligvis skal vi bruge lidt logik i Gui'en for at bruge denne i forhold 
	// til at tjekke på flere uger af gangen!
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
			System.out.println("WeekNumber: " + week);
			i++;
		}
		
		for(boolean isVacant : vacancy)
		{
			System.out.println("Boolean for om ugen er ledig: " + isVacant);
			if(isVacant == false)
				is = false;
		}
		return is;
	}
	
	
	public String getCottageName()
	{
		return this.CottageName;
	}
	
	// Bruges til at teste om status er blevet tilføjet!
		public void printStatus()
		{
			for(Status s : vacancy)
			{
				System.out.println("week " + s.getWeek() + ", Year " + s.getYear());
			}
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
	
	public void setRenovation(boolean renovation)
	{
		this.renovation = renovation;
	}
	
	public ArrayList<Status> getVacancy(){return this.vacancy;}

}
