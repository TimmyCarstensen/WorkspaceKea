package model;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Assistent {

	private String name;
	private double hourPay;

	/**
	 * 
	 * @param name
	 * @param hourPay
	 */
	public Assistent(String name, double hourPay)
	{
		this.name = name;
		this.hourPay = hourPay;
	}
	
	// getters and setters for name and hour pay
	public String getName(){return this.name;}
	public double getHourPay (){return this.hourPay;}
	public void setName(String newName){this.name = newName;}
	public void setHourPay(double newHourPay){this.hourPay = newHourPay;}
	
}
