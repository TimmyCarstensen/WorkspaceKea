package Pratice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

import javax.swing.*;

public class FrameExample{

	
	
	private JFrame frame;
	private JLabel label;
	private Line2D line1 = new Line2D.Double(0, 0, 200, 200);
	private Line2D line2 = new Line2D.Double(70, 80, 100, 200);
	private Line2D line3 = new Line2D.Double(100, 150, 150,150);
	private Stroke drawingStroke = new BasicStroke(2);
	
	public FrameExample()
	{
		createFrame();
	} 	
	
	public void paint(Graphics g) {
		Graphics2D graph = (Graphics2D)g;
		graph.setStroke(drawingStroke);
		graph.setPaint(Color.green);
		graph.draw(line1);
		graph.setPaint(Color.red);
		graph.draw(line2);
		graph.setPaint(Color.yellow);
		graph.draw(line3);
	}
	  
	
	public void createFrame()
	{
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.label = new JLabel("");
		label.setPreferredSize(new Dimension(500,500));
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(300,300);
		frame.setVisible(true);
		paint(frame.getGraphics());
		frame.addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			  System.exit(0);
			 }
			  });
		
	}
	
	public void drawSomething()
	{
		
	}
	
	public static void main(String args[])
	{
		new FrameExample();   
	}
	
}
