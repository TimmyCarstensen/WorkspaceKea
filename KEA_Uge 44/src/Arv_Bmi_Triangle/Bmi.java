package Arv_Bmi_Triangle;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Bmi extends Calculator
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public Bmi()
	{
		setTitle("Bmi");
		setLocation(200, 600);
		setSize(300, 150);
		
		firstLabel.setText("Height: ");
		secoundLabel.setText("Weight: ");		
	}
	
	/**
	 * Calculate BMI with specified values
	 */
	@Override
	public double calculateformular(double a1, double b1) {
		return b1 / (a1 * a1);
	}
}
