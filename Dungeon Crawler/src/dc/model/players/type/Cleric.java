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
public class Cleric extends Hero
{
	
	/**
	 * Constructs a cleric.
	 */
	public Cleric(String name, Point position, Dungeon d)
	{
		super(name, 20, 1, position, d);
	}
}
