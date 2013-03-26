package model;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Triangle {

	/**
	 * 
	 */
	public Triangle()
	{
		
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double calculateArea(double a, double b)
	{
		 return a * b * 0.5;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double calculateHypotenuse(double a, double b)
	{
		return  Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
}
