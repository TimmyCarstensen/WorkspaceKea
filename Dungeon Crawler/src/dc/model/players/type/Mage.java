// lqp693
package dc.model.players.type;

import dc.model.Dungeon;
import dc.model.Point;
import dc.model.players.Hero;

/**
 * 
 * @author Timmy
 * @version 1.0
 */
public class Mage extends Hero
{	
	/**
	 * 
	 * @param name - name of hero.
	 * @param position
	 * @param d - The dungeon.
	 */
	public Mage(String name, Point position, Dungeon d)
	{
		super(name, 10,2, position, d);
	}
	
}
