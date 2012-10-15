package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Model.Car.Color;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Run 
{
	
	static int days;
	static String dt = "2012-09-04";  // Start date
	
	
	public static void main(String args[]) throws ParseException
	{
		
		Car c1 = new Car(Color.BLUE, "Ferrari", "ffek31", 4, 3.2, 2);
		Car c2 = new Car(Color.GREEN, "Lamborghini", "KK999", 4, 3.2, 2);
		Car c3 = new Car(Color.RED, "Porsche", "D52031", 4, 3.2, 2);
		Car c4 = new Car(Color.BLACK, "Audi", "HF2103", 4, 3.2, 2);
		
		CarOwner co1 = new CarOwner("Ole Hansen", c1, 43);
		CarOwner co2 = new CarOwner("Peter Jensen", c2, 41);
		CarOwner co3 = new CarOwner("Kristian Larsen", c3, 38);
		CarOwner co4 = new CarOwner("Svend Poulsen", c4, 49);
		
		CarWash cw = new CarWash();
		int i;
		for(i = 0; i < 20; i++)
		{
			nextDay();
			cw.washCar(co1);
			cw.washCar(co2);
			cw.washCar(co3);
			cw.washCar(co4);			
			
			if(cw.getWashesLeft() == 10)
			{
				cw.refillSoap();
			}
		}
		System.out.println(cw.getMoney());
	}
	
	public static void nextDay() throws ParseException
	{
		days += 5;
		time();
	}
	
	public static void time () throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		c.add(Calendar.DATE, 5);  // number of days to add
		dt = sdf.format(c.getTime());  // dt is now the new date
	}
}
