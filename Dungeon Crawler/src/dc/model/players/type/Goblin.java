// lqp693
package dc.model.players.type;

import dc.model.Dungeon;
import dc.model.Point;
import dc.model.players.Monster;

/**
 * 
 * @author Timmy
 * @version 1.0
 */
public class Goblin extends Monster
{
	/**
	 * 
	 * @param position
	 * @param d - The dungeon.
	 */
	public Goblin(Point position, Dungeon d)
	{
		super(2, 5, position, d);
	}
}
