// lqp693
package dc.model;

/**
 * A point is simulation a imaginary coordinatsystem, which is never really drawn, but
 * realised though all instance like player, item and door object has a point as their
 * position.
 * @author Timmy
 * @version 1.0
 * 
 */
public class Point 
{
	private int x,y;
	
	/**
	 * Constructs a point
	 * @param x 
	 * @param y
	 */
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	/**
	 * Set the x-coordinate.
	 * @param x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Set the y-coordinate.
	 * @param y
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	@Override
	public int hashCode()
	{
		return ((x+1)*3529 + (y+1)*7142);	
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Point)
		{
			return this.hashCode() == o.hashCode();
		}
		return false;
	}
}