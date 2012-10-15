// lqp693
package dc.model.items;

import dc.model.*;

/**
 * 
 * @author Timmy
 * @version 1.0
 */
public abstract class Item 
{
	private Point position;

	/**
	 * Construcs a item.
	 * @param position
	 */
	public Item(Point position){
		this.position = position;
	}
	
	/**
	 * Override the hashcode method.
	 */
	@Override
	public int hashCode()
	{
		return ((position.getX()+1)*3529 + (position.getY()+1)*7142);	
	}
	
	/**
	 * Override the equals method.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Item)
		{
			return this.hashCode() == o.hashCode();
		}
		return false;
	}
	
	// Get methods.
	public Point getPosition(){return this.position;}
	public void SetPosition(Point position){this.position = position;}
	public abstract char getType();
}
