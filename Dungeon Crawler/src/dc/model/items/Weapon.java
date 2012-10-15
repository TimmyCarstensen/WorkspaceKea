// lqp693
package dc.model.items;

import dc.model.*;

/**
 * 
 * @author Timmy
 * @version 1.0
 */
public class Weapon extends Item
{	
	private int damage;
	
	/**
	 * Constructs a weapon.
	 * @param position
	 * @param damage
	 */
	public Weapon(Point position, int damage)
	{
		super(position);
		this.damage = damage;
	}
	
	// Get method
	public int getDamage(){return this.damage;}
	public char getType(){return 'W';}
}
