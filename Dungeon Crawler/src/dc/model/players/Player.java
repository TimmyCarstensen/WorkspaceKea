// lqp693
package dc.model.players;

import dc.model.*;
import dc.model.items.Armor;
import dc.model.items.Item;
import dc.model.items.Weapon;
import dc.view.Direction;

/**
 * Abstract class, for either a intance of hero or monster.
 * @author Timmy
 * @version 1.0
 */
public abstract class Player 
{
	private Point position;
	protected int health;
	protected int damageLevel;
	private Dungeon dungeon;

	/**
	 * constructs a player.
	 * @param position - Position of player
	 * @param dungeon - The dungeon.
	 */
	public Player(Point position, Dungeon dungeon)
	{
		this.health = 100;
		this.position = position;
		this.dungeon = dungeon;
	}

	/**
	 * 
	 * @return true if the player is dead, false otherwise.
	 */
	public boolean isDead()
	{
		return health <= 0;
	}

	/**
	 * Regenerates the players life.
	 * @param regenerationLevel
	 */
	public void regenerate(int regenerationLevel)
	{
		if(health + regenerationLevel >= 100)
			health = 100;
		else{health += regenerationLevel;}
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(Point position)
	{
		this.position = position;
	}

	/**
	 * Tjeks if a player is in the dungeon.
	 * @param p
	 * @return
	 */
	public Room getInside(Point p)
	{
		for(Room room : dungeon.getRoom())
		{
			if(room.isInside(p)) return room;
		}
		return null;
	}

	/**
	 * Tjek if a point is occupied of either monster or hero.
	 * @param p - Position.
	 * @return true if position is occupied, false otherwise.
	 */
	public boolean isOccupied(Point p)
	{
		for(Monster m : dungeon.getMonsters())
			if(m.getPosition().equals(p)) return true;
		return dungeon.getHero().getPosition().equals(p);
	}

	/**
	 * Get the player that is in the occupied position.
	 * @param p - Position.
	 * @return Player.
	 */
	public Player getOccupied(Point p)
	{
		for(Monster m : dungeon.getMonsters())
			if(m.getPosition().equals(p)) 
				return m;
		if(dungeon.getHero().getPosition().equals(p)) 
			return dungeon.getHero();
		return null;
	}

	/**
	 * Pick up an item in the dungeon.
	 * @param p - Position
	 */
	public void pickItem(Point p)
	{
		Hero hero = getDungeon().getHero();
		Item item = getDungeon().loot(p);
		if(item.getType() == 'A')
		{
			Armor armor = (Armor) item;
			hero.setArmor(armor);
		}
		else if(item.getType() == 'W')
		{
			Weapon weapon = (Weapon) item;
			if(hero.getWeapon() == null)
				hero.setWeapon(weapon);
			else 
			{
				hero.setWeapon(weapon);
			}
		}
	}

	/**
	 * 
	 * @param p - Position
	 * @return true if there is an item at the position, false otherwise.
	 */
	public boolean isItem(Point p)
	{
		for(Room r : getDungeon().getRoom())
			for(Item it : r.getItems())
				if(it.getPosition().equals(p))
				return true;
		return false;
	}

	/**
	 * Attemps to move the player one point in the desired direction.
	 * The move fails if there is a wall or another player in the target
	 * position. In the latter case, the player in the target position is 
	 * damaged. If the other player dies due to damage, the move succeeds
	 * anyways.
	 * @param direction
	 * @return true if move succeeded, false otherwise.
	 */
	public boolean tryMove(Direction direction)
	{
		Boolean isMoved = false;

		// can't move a dead hero.
		if(isDead())
			return isMoved;

		int x = this.position.getX();
		int y = this.position.getY();
		Room r = getInside(position);
		Point tjek = new Point(x,y);
		
		// move the player.
		switch(direction){
		case WEST:
			tjek.setX(x-1);
			if(r.gettopLeft().getX() <= tjek.getX() || r.isDoor(this.position))
			{
				if(!isOccupied(tjek))
					this.position = tjek;
				isMoved = true;
			}
			break;
		case SOUTH:
			tjek.setY(y+1);
			if(r.getbottomRight().getY() > tjek.getY() || r.isDoor(this.position))
			{
				if(!isOccupied(tjek))
					this.position = tjek;
				isMoved = true;
			}
			break;
		case EAST:
			tjek.setX(x+1);
			if(r.getbottomRight().getX() > tjek.getX() || r.isDoor(this.position))
			{
				if(!isOccupied(tjek))
					this.position = tjek;
				isMoved = true;
			}
			break;
		case NORTH:
			tjek.setY(y-1);
			if(r.gettopLeft().getY() <= tjek.getY() || r.isDoor(this.position))
			{
				if(!isOccupied(tjek))
					this.position = tjek;
				isMoved = true;
			}
			break;
		}

		if(isItem(this.getPosition()))
			pickItem(this.getPosition());

		Player monster = getOccupied(tjek);
		if(isOccupied(tjek))
		{
			if(monster.getType() == 'm')
				monster.takeDamage(dungeon.getHero().getDamageLevel());
			if(monster.isDead())
			{
				getDungeon().removeMonster(monster);
				getDungeon().getHero().setPosition(tjek);
			}
		}		
		getDungeon().monsterMove(isMoved);
		return isMoved;
	}

	// Get methods.
	public Point getPosition(){return this.position;}
	public Dungeon getDungeon(){return dungeon;}
	public int getHealth(){return health;}
	public abstract int getDamageLevel();
	public abstract void takeDamage(int amount);	
	public abstract char getType();
}