
public class Hut 
{

	private String name;
	private int noOfBeds;
	private int price;
	private String type;

	public Hut(String name, int noOfBeds, int price, String type)
	{
		this.name = name;
		this.noOfBeds = noOfBeds;
		this.price = price;
		this.type = type;
	}
	
	// getters
	public String getName(){return name;}
	public int getBeds(){return noOfBeds;}
	public int getPrice(){return price;}
	public String getType(){return type;}


}
