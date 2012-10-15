// lqp693
package dc.model.players.type;

import dc.model.Dungeon;
import dc.model.Point;
import dc.model.players.Hero;

/**
 * 
 * @author Timmy
 * @version 
 */
public class Warrior extends Hero
{
	/**
	 * 
	 * @param name - name of hero.
	 * @param position
	 * @param d - The dungeon.
	 */
	public Warrior(String name, Point position, Dungeon d)
	{
		super(name, 5,3, position, d);
	}
}
