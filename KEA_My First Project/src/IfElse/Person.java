package IfElse;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private Boolean male;	
	private String fullName;
	
	/**
	 * Constructor
	 * @param fn firstname
	 * @param ln lastname
	 * @param age
	 * @param male boolean
	 */
	public Person(String fn, String ln, int age, boolean male){
		this.firstName = fn;
		this.lastName = ln;
		this.age = age;
		this.male = male;
		this.fullName = firstName + " " + lastName;
	}
	
	/**
	 * DONE
	 * @param age
	 * @return
	 */
	public boolean isAge(int age)
	{
		boolean isPersonsAge  = false;
		
		if(age == this.age){
			isPersonsAge = true;
		}
		
		return isPersonsAge;
	}
	
	
	/**
	 * DONE
	 * @param name
	 * @return
	 */
	//Exercise: Make method that responds if name is the same as the parameter. Parameter has 
	public boolean isPersonsName(String name)
	{
		boolean isPersonsName = false;
		
		String fullName = firstName + " " + lastName;
		if(fullName.equals(name)){
			isPersonsName = true;
		}
		return isPersonsName;
	}
	
	/**
	 * DONE
	 * @param name
	 * @return
	 */
	//Not operator
	public boolean isPersonsNameNot(String name)
	{
		boolean isPersonsNameNot = false;
		
		if(!fullName.equals(name)){
			return isPersonsNameNot = true;
		}
		
		return isPersonsNameNot;
	}
	
	/**
	 * DONE
	 * @param name
	 * @param age
	 * @return
	 */
	public boolean isPersonsNameNotButAgeIs(String name, int age)
	{
		boolean is = false;
		
		if(!name.equals(fullName) && age == this.age){
			is = true;
		}
		return is;
	}
	
	/**
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	public boolean isPersonAgeAndName(String name, int age)
	{
		//return true if name and age are the same as this person and otherwise false
		boolean isPersonAgeAndName = false;
		
		if(name.equals(fullName) && age == this.age){
			isPersonAgeAndName = true;
		}
		
		return isPersonAgeAndName;
	}
	
	/**
	 * 
	 * @param name
	 * @param age
	 * @param male
	 * @return
	 */
	public boolean isPersonIdentical(String name, int age, boolean male)
	{
		boolean isIden = false;
		
		if(name.equals(fullName) && this.age == age && this.male == male){
			isIden = true;
		}
		
		return isIden;
	}
	
	/**
	 * 
	 * @return
	 */
	public String whichAgeGroup()
	{
		String ageGroup = "not defined";
		
		if(age > 0 && age < 6){
			ageGroup = "Small Child";
		} else if (age >= 6 && age <= 12) {
			ageGroup = "Child";
		} else if (age >= 13 && age <= 19){
			ageGroup = "Teenager";
		} else if (age >= 20 && age <= 45){
			ageGroup = "Adult";
		} else if (age >= 46 && age <= 60){
			ageGroup = "Mid age";
		} else if (age >= 61 && age <= 75){
			ageGroup = "Old";
		} else if (age >= 76)
			ageGroup = "Very old";
		
		return ageGroup;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean isPersonsNameCasInsensitive(String name)
	{
		boolean is = false;
		if(fullName.equalsIgnoreCase(name)){
			is = true;
		}
		return is;
	}

}
