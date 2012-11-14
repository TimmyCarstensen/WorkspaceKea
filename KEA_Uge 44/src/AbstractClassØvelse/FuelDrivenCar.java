package AbstractClassØvelse;

import java.awt.Color;

public class FuelDrivenCar extends CarBase{

	private int mpg;
	private int engineSize;
	
	public FuelDrivenCar (int length, int width, String color, int mpg, int engineSize)
	{
		super(length, width, color);
		this.mpg = mpg;
		this.engineSize = engineSize;
		
	}

	@Override
	public void drive() {
		System.out.println("Noisy fuel driven car running!");	
	} 
	
	public void print()
	{
		System.out.println("Fuel driven car: " + length + " " + width + " " + color + " " + mpg + " " + engineSize);
	}
	
}
