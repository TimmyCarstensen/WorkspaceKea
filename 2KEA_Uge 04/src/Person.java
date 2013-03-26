
public class Person 
{
	private String name;
	private int age;
	private int phoneNumber;
	
	public Person(String name, int age, int phoneNumber)
	{
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {return name;}
	public int getAge() {return age;}
	public int getPhoneNumber(){return this.phoneNumber;}
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setPhoneNumber(int phoneNumber){this.phoneNumber = phoneNumber;}
	
	
}
