package guiKristian;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


//public class Gui3 implements ActionListener {
//
//	public Gui3()
//	{
//		JFrame frame = new JFrame();
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the program exit when this frame (window) is closed.
//		
//		Point p = new Point(10, 50);
//		
//		frame.setLocation(p); //Start position
//		frame.setSize(new Dimension(300,120)); //Start size
//		
//		frame.setTitle("Hello world!"); //Frames title
//		frame.setVisible(true); //Make it visible.
//
//		
//		
////		//Button 1
//		JButton button1 = new JButton(); 
//		button1.setText("Click me!");
//		button1.setBackground(Color.GRAY);
//		button1.addActionListener(this);
//		frame.add(button1);
////		
////		//Button 2
//		JButton button2 = new JButton();
//		button2.setText("Please do not click me!");
//		button2.setBackground(Color.RED);
//		button2.addActionListener(this);
//		frame.add(button2);
////		
////		//Add a layout to the frame.
//		frame.setLayout(new FlowLayout());
//
//	}
//	
//	public static void main(String[] args) {
//		Gui3 g = new Gui3();
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent action) {
//		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null, "I clicked a button");
//		
//	}
//}
//



public class Gui3 implements ActionListener {

	JButton button1;
	JButton button2;
	public Gui3() {
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the program exit when this frame (window) is closed.
		frame.setLocation(new Point(10, 50)); //Start position
		frame.setSize(new Dimension(300,120)); //Start size
		
		frame.setTitle("Hello world!"); //Frames title
		frame.setVisible(true); //Make it visible.
		

		//Button 1
		button1 = new JButton(); 
		button1.setText("Click me!");
		button1.setBackground(Color.GRAY);
		button1.addActionListener(this);
		frame.add(button1);
		
		//Button 2
		button2 = new JButton();
		button2.setText("Please do not click me!");
		button2.setBackground(Color.RED);
		button2.addActionListener(this);
		frame.add(button2);
		
		//Add a layout to the frame.
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Gui3 g = new Gui3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button2)
		{
			JOptionPane.showMessageDialog(null, "You are not allowed to click me!");
		}
		else if ( e.getSource() == button1)
		{
			JOptionPane.showMessageDialog(null, "Thank you for clicking me!");
		}
		
	}
}
