package controlEntity;

public class Present 
{
	private PresentType presentType;
	private int weight;
	private String name;
	
	public Present(String name, int weight, PresentType presentType)
	{
		this.name = name;
		this.weight = weight;
		this.presentType = presentType;
	}
	
	
	public void print()
	{
		System.out.println("Name: " + name + "; Weight: " + weight + "; Present Type: " + presentType);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("; Weight " + weight + "; Present Type: " + presentType + "\n");
		
		return sb.toString();
	}
	
	public PresentType getPresentType(){return this.presentType;}
	public int getWeight(){return weight;}
	public String getName(){return name;}
	public void setPresentType(PresentType presentType){this.presentType = presentType;}
	public void setWeight(int weight){this.weight = weight;} 
	public void setName(String name){this.name = name;}
	
	
	public enum PresentType{
		SOFT, NORMAL, HARD
	}
	
}
