package bolde;

import java.awt.*;

/**
 * @author ArneK og Timmy Carstensen
 */
public class Bold implements Konstanter, Runnable
{
	private double x, y, fartx, farty;
	private int d;
	private Color c;
	private Graphics g;

	public Bold(Graphics g1, int x1, int y1, Color c, int d1)
	{ 
		this.g = g1; 
		x = x1; 
		y = y1; 
		this.c = c; 
		d = d1;
		this.fartx = Math.random() * 1.5;
		this.farty = Math.random();
		

		// showBall();
		
		Thread t = new Thread(this);
		t.start();
	}

	public void showBall()
	{ 
		// Tegn bolden på position
		g.setColor(c);
		g.drawOval((int) x, (int) y, d, d);
	}

	public void run()
	{ 
		while(true) // repeat forever
		{
			synchronized (g) {
				// Slet bold: Tegn bolden over med hvid på den gamle position
				g.setColor(Color.WHITE);
//				 g.drawOval((int) x, (int) y, d, d);
				g.fillRoundRect((int) x, (int) y, d, d, d/4, d/4);	
			}
			

			// Opdater positionen med farten
			x = x + fartx;
			y = y + farty;

			// synchronized skaber en blok, som gør at det ikke kan blive afbrudt i afvikling af koden!
			synchronized (g) {
				// Tegn bolden på den nye position
				g.setColor(c);
//				g.drawOval((int) x, (int) y, d, d);
				g.fillRoundRect((int) x, (int) y, d, d, d/4, d/4);	
			}
			

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