package bolde;

import java.awt.*;
import javax.swing.*;

/**
 * @author ArneK Og Timmy Carstensen
 */
public class TestBolde implements Konstanter
{
	public static void main(String[] arg)
	{
		JFrame f = new JFrame();
		f.setSize(sizeJFrameX,sizeJFrameY);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);
		
		Graphics g = f.getGraphics();
		
		f.update(g);
		
		
		
//		new Ball(g, 300, 40, Color.BLACK, 60);
//		new Ball(g, 300, 40, Color.GREEN, 40);
		
		new Bold(g, 0, 200, Color.BLACK, 30);
		new Bold(g, 0, 400, Color.GREEN, 40);
		new Bold(g, 0, 600, Color.BLUE, 80);
		
	}
}