// lqp693
package dc.model.items;

import dc.model.*;

/**
 * 
 * @author Timmy
 * @version 1.0
 */
public class Armor extends Item
{
	private int resistance;

	/**
	 * 
	 * @param position
	 * @param resistance - extra life.
	 */
	public Armor(Point position, int resistance)
	{
		super(position);
		this.resistance = resistance;
	}
	
	// Get methods.
	public int getResistance(){return this.resistance;}
	public char getType(){return 'A';}
}
