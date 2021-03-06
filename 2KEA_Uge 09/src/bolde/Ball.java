package bolde;

import java.awt.*;

/**
 * @author ArneK
 */
public class Ball implements Konstanter
{
	private double x, y, fartx, farty;
	private int d;
	private Color c;
	private Graphics g;

	public Ball(Graphics g1, int x1, int y1, Color c, int d1)
	{ 
		this.g = g1; 
		x = x1; 
		y = y1; 
		this.c = c; 
		d = d1;
		this.fartx = Math.random() * 1.5;
		this.farty = Math.random();

		// showBall();
		moveBall();
	}

	public void showBall()
	{ 
		// Tegn bolden på position
		g.setColor(c);
		g.drawOval((int) x, (int) y, d, d);
	}

	public void moveBall()
	{ 
		while(true) // repeat forever
		{
			
			// Slet bold: Tegn bolden over med hvid på den gamle position
			g.setColor(Color.WHITE);
//			g.drawOval((int) x, (int) y, d, d);
			g.fillRoundRect((int) x, (int) y, d, d, d/4, d/4);
			
			// Opdater positionen med farten
			x = x + fartx;
			y = y + farty;

			// Tegn bolden på den nye position
			g.setColor(c);
//			g.drawOval((int) x, (int) y, d, d);
			g.fillRoundRect((int) x, (int) y, d, d, d/4, d/4);

			farty = farty + gravity;

			if(x     < 0)               fartx =  Math.abs(fartx);
			if(x + d > sizeJFrameX)     fartx = -Math.abs(fartx);
			if(y     < 0)               farty =  Math.abs(farty);
			if(y + d > sizeJFrameY)     farty = -Math.abs(farty);


			//vent lidt
			try {Thread.sleep(20); } catch (Exception e) {};
		}
	}
}