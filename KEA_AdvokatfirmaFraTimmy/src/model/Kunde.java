package model;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Kunde {
	
	private double wealth;
	
	/**
	 * 
	 * @return boolean, true if kunde has money, false otherwise
	 */
	public boolean hasMoney()
	{
		return wealth > 0;
	}
	
	// get and set methods for wealth
	public double getWealth(){return this.wealth;}
	public void setWealth(double newWealth){this.wealth = newWealth;}
}
