package model;

/**
 * Lavet af Hisayo.
 */
public class LuxuryCottage extends Cottage {
	
	/**
	 * 
	 * @param typeOfCottage
	 * @param cottageName
	 * @param price
	 * @param beds
	 * @param renovation
	 */
	public LuxuryCottage (char typeOfCottage, String cottageName,  int price, int beds, boolean renovation)
	{
		super(typeOfCottage, cottageName, price, beds, renovation);
	}

}
