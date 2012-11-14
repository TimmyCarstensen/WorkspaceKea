package AbstractClassØvelse;

import java.awt.Color;

public class ElectricCar extends CarBase{
	private int range;
	
	public ElectricCar(int lenght, int width, String color, int range) {
		super(lenght, width, color);
		this.range = range;
	}

	@Override
	public void drive() {
		System.out.println("Real silent electric car running!");
		
	}
	
//	public void print ()
//	{
//		System.out.println("Electric car: " + length + " " + width + " " + color + " " + range);
//	}

}
