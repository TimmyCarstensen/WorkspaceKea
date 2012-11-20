package model;



/**
 * 
 * @author Matias
 *
 */
public class Reservation {

	private int[] weeks;
	private int year; 
	private double totalPrice;
	private Cottage cottage;
	private Customer customer;
	/**
	 * Bruges af parser til at læse en simpel reservation ind, med string-typer for cottage og customer.
	 * @param weeks
	 * @param totalPrice
	 * @param cottageName
	 * @param customer
	 */
	public Reservation(int[] weeks, int year, String cottageName, String cvrNr_cprNr, Resort resort)
	{

		this.weeks = weeks;
		this.year = year;
		this.cottage = resort.findCottageName(cottageName);
		this.customer = resort.findCustomer(cvrNr_cprNr);

		calculatePrice();
		System.out.println("Price for this reservation is: " + this.totalPrice);
	}

	/**
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
		this.customer = customer;
		calculatePrice();

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
		
		for(double weekPrice : weekPrices)
		{
			sum = sum + weekPrice;
		}
		this.totalPrice = sum;
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
}

