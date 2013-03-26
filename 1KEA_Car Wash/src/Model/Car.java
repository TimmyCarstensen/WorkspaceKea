package Model;

public class Car 
{
//	Simple instance variables.
	private Color color;
	private String make;
	private String model;
	private int numberOfWheels;
	private double width;
	private int length;
//	Lastwashed save date for last washed.
	private int lastWashed;
//	A motorclass is defined inside a cars object.
	private Motor motor;
	
	/**
	 * Constructor
	 * @param color String
	 * @param make String
	 * @param model String
	 * @param numberOfWheels int
	 * @param width double
	 * @param length int
	 */
	public Car(Color color, String make, String model, int numberOfWheels, double width, int length)
	{
		this.color = color;
		this.make = make;
		this.model = model;
		this.numberOfWheels = numberOfWheels;
		this.width = width;
		this.length = length;
	}
	
	/**
	 * 
	 * @param s double
	 * @param m String
	 * @param ben String
	 */
	
	public boolean needWash()
	{	
		boolean need = false;
		
		if(this.color == Color.BLUE && (Run.days - lastWashed) > 14){
			need = true;
		} else if (this.color == Color.GREEN && (Run.days - lastWashed) > 10){
			need = true;
		} else if (this.color == Color.RED && (Run.days - lastWashed) > 12){
			need = true;
		} else if (this.color == Color.BLACK && (Run.days - lastWashed) > 5){
			need = true;
		}
		return  need;
	}
	
	public void createMotor(double size, String model, String benzin_diesel)
	{
		motor = new Motor(size, model, benzin_diesel);
	}
	
	/**
	 * Calculate cars area
	 * @return Area of car (length * width)
	 */
	public double getCarsArea()
	{
		return width * length;
	}
	
	/**
	 * change all attributes of a car.
	 * @param color String
	 * @param make String
	 * @param model String
	 * @param numberOfWheels int
	 * @param width double
	 * @param length int
	 */
	public void setAllAttributes(Color color, String make, String model, int numberOfWheels, double width, int length){
		this.color = color;
		this.make = make;
		this.model = model;
		this.numberOfWheels = numberOfWheels;
		this.width = width;
		this.length = length;
	}
	
	/**
	 * Print a cars attributes.
	 */
	public void printAttributes()
	{
		System.out.println("Motorcycle information:");
		System.out.println("Color: " + getColor());
		System.out.println("Maker: " + getMake());
		System.out.println("Model: " + getModel());
		System.out.println("Number of wheels: " + getNumberOfWheels());
		System.out.println("Width: " + getWidth());
		System.out.println("Length: " + getLength());
		System.out.println();
		System.out.println("Motor information:"); 
		System.out.println("Model: " + this.motor.getModel());
		System.out.println("Size: " + this.motor.getSize());
		System.out.println("Type of gas: " + this.motor.getBen_Dies());
	}
	
	/**
	 * 
	 * @author Timmy Carstensen
	 *
	 */
	public enum Color
	{
		RED, BLUE, YELLOW, BLACK, GREEN, BROWN, ORANGE, WHITE 
	}	
	
//	 A lot of simple "set"-methods.
	public void setColor(Color color){this.color = color;}
	public void setMake(String make){this.make = make;}
	public void setModel(String model){this.model = model;}
	public void setNumberOfWheels(int wheels){this.numberOfWheels = wheels;}
	public void setWidth(int width){this.width = width;}
	public void setLength(int length){this.length = length;}	
	public void setLastWash(int days){this.lastWashed = days;}	
	
//	A lot of of simple "get"-methods.
	public Color getColor(){return this.color;}
	public String getMake(){return this.make;}
	public String getModel(){return this.model;}
	public int getNumberOfWheels(){return numberOfWheels;}
	public double getWidth(){return width;}
	public double getLength(){return length;}
	public int getDaysLastWash(){return lastWashed;}
}