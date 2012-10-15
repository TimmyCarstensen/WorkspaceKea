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
public class Orc extends Monster
{
	
	/**
	 * 
	 * @param position
	 * @param d - The dungeon.
	 */
	public Orc(Point position, Dungeon d)
	{
		super(10,20, position, d);
	}
	
}
