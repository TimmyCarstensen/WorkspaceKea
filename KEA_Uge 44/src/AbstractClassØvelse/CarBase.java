package AbstractClassØvelse;

import java.awt.Color;

public abstract class CarBase {
	
	protected int length;
	protected int width;
	protected String color;
	
	public CarBase(int lenght, int width, String color)
	{
		this.length = lenght;
		this.width = width;
		this.color = color;
	}
	
	public abstract void drive();
	public void print()
	{
		System.out.println("Base Car: " + length + " " + width + " " + color);
	}
	
}
