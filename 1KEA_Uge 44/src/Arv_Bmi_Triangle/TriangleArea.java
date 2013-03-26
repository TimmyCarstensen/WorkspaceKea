package Arv_Bmi_Triangle;



/**
 * 
 * @author Timmy Carstensen
 *
 */
public class TriangleArea extends Calculator
{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TriangleArea()
	{
		setTitle("Triangle Area");
		setLocation(200, 300);
		setSize(300, 150);
		
		firstLabel.setText("Side a: ");
		secoundLabel.setText("Side b: ");
	}

	/**
	 * Calculates Area with the specified values
	 */
	@Override
	public double calculateformular(double a1, double b1) 
	{
		return a1 * b1 * 0.5;
	}
	
}
