package Arv_Bmi_Triangle;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public abstract class Calculator extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton calArea, calC, compute;
	protected JLabel firstLabel, secoundLabel, resultLabel;
	protected JTextField firstNumber, secoundNumber;
	protected JPanel north, center, south;

	/**
	 * 
	 */
	public Calculator()
	{
		// define frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocation(200, 450);
		setSize(400, 150);
		setTitle("I'm a general Calculator, implement me please!");

		// initialise components
		firstLabel = new JLabel("----: ");
		firstNumber = new JTextField(5);
		secoundLabel = new JLabel("----: ");
		secoundNumber = new JTextField(5);
		compute = new JButton("compute");
		resultLabel = new JLabel("Here the result will show");
		north = new JPanel(new BorderLayout());
		center = new JPanel();
		south = new JPanel(new FlowLayout());


		// add north wrapper
		JPanel firstColumn = new JPanel(new GridLayout(2, 1));
		JPanel secondColumn = new JPanel(new GridLayout(2, 1));
		firstColumn.add(firstLabel);
		firstColumn.add(secoundLabel);
		secondColumn.add(firstNumber);
		secondColumn.add(secoundNumber);
		JPanel wrapperNorth = new JPanel(new FlowLayout());
		wrapperNorth.add(firstColumn);
		wrapperNorth.add(secondColumn);

		
		// add ActionListener
		compute.addActionListener(this);
		
		// add components to north panel
		north.add(wrapperNorth, BorderLayout.CENTER);

		// add components to center panel 
		center.add(resultLabel);

		// add components to south panel
		south.add(compute);

		// add panels to frame
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public abstract double calculateformular(double a1, double b1);
	// missing body?!?! :-O :-O
	@Override
	public void actionPerformed(ActionEvent e)
	{
		double a1 = 0.0;
		double b1 = 0.0;
		try{
			a1 = Double.parseDouble(firstNumber.getText());
			b1 = Double.parseDouble(secoundNumber.getText());
		
		} catch (Exception e1)
		{
			this.resultLabel.setText("You must apply two numbers!");
		}
			double result = calculateformular(a1, b1);
			this.resultLabel.setText("Result is: " + result); 		
	}
	
	public static void main(String args[])
	{
		new Bmi();
		new TriangleArea();
	}	
}