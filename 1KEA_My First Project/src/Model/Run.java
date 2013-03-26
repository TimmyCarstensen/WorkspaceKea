package Model;

import Model.Car.Color;


public class Run {

	/**
	 * @param args
	 * Car(String color, String make, String model, int numberOfWheels, double width, int length)
	 */
	
	public static void main(String[] args) {
		// This is homework creating a motorcycle and hide a motor-class inside it.
		Car c = new Car(Color.GREEN, "Toyota", "kagemand", 4, 1.5, 2);
		c.createMotor(2500, "honda", "Diesel");
		c.printAttributes();
		System.out.println("Cars area: " + c.getCarsArea());
	}
}