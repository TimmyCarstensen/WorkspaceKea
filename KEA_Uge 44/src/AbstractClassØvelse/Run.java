package AbstractClassÿvelse;

import java.awt.Color;
import java.util.ArrayList;

public class Run {

	public static void main(String[] args)
	{
		FuelDrivenCar fdDar = new FuelDrivenCar(3, 2, "white", 250, 900);
		ElectricCar eCar = new ElectricCar(3, 2, "black", 80);
		
		ArrayList<CarBase> cb = new ArrayList<CarBase>();
		
		cb.add(fdDar);
		cb.add(eCar);
		
		for(CarBase c : cb)
		{
			c.print();
			c.drive();
		}
	}
}
