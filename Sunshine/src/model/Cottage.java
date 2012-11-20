package model;
/*
 * lavet af Hisayo
 */
public abstract class Cottage {
	
	protected char typeOfCottage;
	protected String CottageName;
	protected int price;
	protected int beds;
	protected boolean renovation;
	
	public Cottage (char typeOfCottage, String cottageName, int beds, int price)
	{
		this.typeOfCottage = typeOfCottage;
		this.CottageName = cottageName;
		this.price = price;
		this.beds = beds;
		this.renovation = false;
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
	
	public void setRenovation(boolean renovation)
	{
		this.renovation = renovation;
	}

}
