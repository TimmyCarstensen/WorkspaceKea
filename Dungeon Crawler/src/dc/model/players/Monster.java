// lqp693
package dc.model.players;

import dc.model.Dungeon;
import dc.model.Point;
import dc.model.Room;

/**
 * 
 * @author Timmy
 * @version 1.0
 *
 */
public abstract class Monster extends Player
{
	private int regeneration;
	private int damageLevel;
	private static final char TYPE = 'm';

	/**
	 * 
	 * @param regeneration
	 * @param magnitude
	 */
	public Monster(int regeneration, int damageLevel, Point position, Dungeon d)
	{
		super(position, d);
		this.regeneration = regeneration;
		this.damageLevel = damageLevel;
	}

	/**
	 * Gives a manhattenDistance.
	 * @param p1 - Position of first player.
	 * @param p2 - Position of second player.
	 * @return manhattenDistance between to characters.
	 * 
	 */
	public int manhattenDistance(Point p1, Point p2)
	{
		return Math.abs(p1.getX()-p2.getX())+ Math.abs(p1.getY() - p2.getY());
	}

	/**
	 * Make a autonomous move for a monster.
	 */
	public void makeAutonomousMove()
	{
		Player hero = getDungeon().getHero();
		Point heroPos = getDungeon().getHero().getPosition();
		Point monsterPos = this.getPosition();

		int x = this.getPosition().getX();
		int y = this.getPosition().getY();

		Room r = getInside(this.getPosition());

		Point tjekWest = new Point(x, y);
		Point tjekEast = new Point(x, y);
		Point tjekNorth = new Point(x, y);
		Point tjekSouth = new Point(x, y);

		tjekWest.setX(x-1);
		tjekSouth.setY(y+1);
		tjekEast.setX(x+1);
		tjekNorth.setY(y-1);

		if(manhattenDistance(heroPos, monsterPos) >= manhattenDistance(heroPos, tjekWest))
		{
			if(r.gettopLeft().getX() <= tjekWest.getX() || r.isDoor(this.getPosition()))
				if(!isOccupied(tjekWest))
					this.setPosition(tjekWest);
				else
					if(heroPos.equals(tjekWest))
						hero.takeDamage(this.damageLevel);
		}
		else if(manhattenDistance(heroPos, monsterPos) >= manhattenDistance(heroPos, tjekSouth))
		{
			if(r.getbottomRight().getY() > tjekSouth.getY() || r.isDoor(this.getPosition()))
			{
				if(!isOccupied(tjekSouth))
					this.setPosition(tjekSouth);
				else
					if(heroPos.equals(tjekSouth))
						hero.takeDamage(this.damageLevel);

			}
		}else if(manhattenDistance(heroPos, monsterPos) >= manhattenDistance(heroPos, tjekEast))
		{
			if(r.getbottomRight().getX() > tjekEast.getX() || r.isDoor(this.getPosition()))
			{
				if(!isOccupied(tjekEast))
					this.setPosition(tjekEast);
				else
					if(heroPos.equals(tjekEast))
						hero.takeDamage(this.damageLevel);
			}
		}else if(manhattenDistance(heroPos, monsterPos) >= manhattenDistance(heroPos, tjekNorth))
		{ 
			if(r.gettopLeft().getY() <= tjekNorth.getY() || r.isDoor(this.getPosition()))
			{
				if(!isOccupied(tjekNorth))
					this.setPosition(tjekNorth);
				else
					if(heroPos.equals(tjekNorth))
					{
						hero.takeDamage(this.damageLevel);
					}
			}
		}
	}

	/**
	 * Amount of damage taken.
	 * @param damageLevel - amount of damage. 
	 */
	public void takeDamage(int damageLevel)
	{
		this.health -= damageLevel;
	}

	// Get methods.
	public int getRegeneration(){return regeneration;}
	public int getDamageLevel(){return damageLevel;}
	public char getType(){return TYPE;}
}
