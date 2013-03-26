package Model;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class CarOwner {
	private String name;
	private Car car;
	private int age;
	private int stash;
	
	/**
	 * 
	 * @param name
	 * @param c
	 * @param age
	 */
	public CarOwner(String name, Car c, int age){
		this.name = name;
		this.car = c;
		this.age = age;
		stash = 500;
	}
	
	/**
	 * 
	 */
	public void payForWash(){
		this.stash -= 20;
	}
	
	public Car getCar(){return car;}
	public int getAge(){return age;}
	public int getStach(){return this.stash;}
	public String getName(){return name;}
	
}