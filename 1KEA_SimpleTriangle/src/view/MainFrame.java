package view;

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

import model.Triangle;


/**
 * 
 * @author Timmy Carstensen
 *
 */
public class MainFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton calArea, calC;
	private JLabel a, b, result;
	private JTextField aLength, bLength;
	private JPanel north, center, south;
	private Triangle tri = new Triangle();

	/**
	 * 
	 */
	public MainFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//		setSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		setLocation(600, 350);

		// initialise components
		JLabel HeadingText = new JLabel("Ortogonal triangel!");
		a = new JLabel("The side a of a orthogonal triangel: ");
		aLength = new JTextField(5);
		b = new JLabel("The side b of a orthogonal triangel: ");
		bLength = new JTextField(5);
		calArea = new JButton("Calculate Area");
		calC = new JButton("Calculate hypotenuse");
		result = new JLabel("Here the result will show");
		JPanel firstColumn = new JPanel(new GridLayout(2, 1));
		JPanel secondColumn = new JPanel(new GridLayout(2, 1));
		north = new JPanel(new BorderLayout());
		center = new JPanel();
		south = new JPanel(new FlowLayout());


		// add actionlistener
		calC.addActionListener(this);
		calArea.addActionListener(this);

		// add north borderlayout 
		firstColumn.add(a);
		firstColumn.add(b);
		secondColumn.add(aLength);
		secondColumn.add(bLength);
		JPanel wrapperNorth = new JPanel(new FlowLayout());
		wrapperNorth.add(firstColumn);
		wrapperNorth.add(secondColumn);

		north.add(HeadingText, BorderLayout.NORTH);
		north.add(wrapperNorth, BorderLayout.CENTER);


		// add center borderlayout 
		center.add(result);

		//add south borderlayout 
		south.add(calArea);
		south.add(calC);


		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	public static void main(String args[])
	{
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException{
		if(e.getSource() == calArea)
		{
			try{
				String a1tem = aLength.getText();
				double a1 = Double.parseDouble(a1tem);
				String b1tem = bLength.getText();
				double b1 = Double.parseDouble(b1tem);

				double result = tri.calculateArea(a1, b1);

				this.result.setText("Result is: " + result);
			} catch (NumberFormatException e1)
			{
				this.result.setText("You must apply two numbers!");
			}
		}
		else if(e.getSource() == calC)
		{
			try{
				String a1tem = aLength.getText();
				double a1 = Double.parseDouble(a1tem);
				String b1tem = bLength.getText();
				double b1 = Double.parseDouble(b1tem);

				double result = tri.calculateHypotenuse(a1, b1);

				this.result.setText("Result is: " + result);
			} catch (NumberFormatException e1)
			{
				this.result.setText("You must apply two numbers!");
			}
		}

	}

}

