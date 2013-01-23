package controlEntity;

public class Santa 
{
	private String name;
	private int age;
	private Sled sled;

	public Santa(String name, int age)
	{
		this.age = age;
		this.name = name;
	}
	
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public Sled getSled(){return this.sled;}
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setSled(Sled sled){this.sled = sled;}
	
}
