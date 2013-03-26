package bmiGUI;

import java.awt.BorderLayout;
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
 * @author Timmy
 *
 */
public class BmiGui extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField heightField;
	private JTextField weightField;
	private JLabel bmiLabel;
	private JButton computeButton;
	
	public BmiGui()
	{
		// set up components
		heightField = new JTextField(5);
		weightField = new JTextField(5);
		bmiLabel = new JLabel("Type your height and weight");
		computeButton = new JButton("compute");
		computeButton.addActionListener(this);
		// Layout
		JPanel north = new JPanel(new GridLayout(2, 2));
		north.add(new JLabel("Height: "));
		north.add(heightField);
		north.add(new JLabel("Weight: "));
		north.add(weightField);
		
		// Overall frame
		frame = new JFrame("BMI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(north, BorderLayout.NORTH);
		frame.add(bmiLabel, BorderLayout.CENTER);
		frame.add(computeButton, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String args[])
	{
		new BmiGui();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 String heightText = heightField.getText();
		 double height = Double.parseDouble(heightText);
		 String weightText = weightField.getText();
		 double weight = Double.parseDouble(weightText);
		 
		 double bmi = weight / (height * height);
		 bmiLabel.setText("BMI: " + bmi);
		
	}
}
