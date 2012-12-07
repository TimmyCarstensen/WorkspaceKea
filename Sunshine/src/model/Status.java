package model;

/**
 * Bruges til at holde styr på om en hytte er reserveret
 * @author Timmy
 *
 */
public class Status {

	private int week;
	private int year;
	
	/**
	 * @param week
	 * @param year
	 */
	public Status (int week, int year)
	{
		this.week = week;
		this.year = year;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
