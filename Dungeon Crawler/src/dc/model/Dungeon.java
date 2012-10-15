// lqp693
package dc.model;

import java.util.ArrayList;
import java.util.Iterator;
import dc.model.items.Item;
import dc.model.players.*;

/**
 * This class is the connection between all classes.
 * @author Timmy
 * @version 1.0
 * 
 */
public class Dungeon 
{
	private ArrayList<Room> rooms;
	private String description;
	private Hero hero;
	private int scalefactor;
	private ArrayList<Monster> monsters;
	private static Dungeon instance;

	/**
	 * Constructor
	 */
	private Dungeon()
	{
		rooms = new ArrayList<Room>();
		monsters = new ArrayList<Monster>();
	}

	/**
	 * Generate only one instance of dungeon.
	 * @return dungeon
	 */
	public static Dungeon initialize()
	{
		if (Dungeon.instance == null)
			Dungeon.instance = new Dungeon();
		return Dungeon.instance;
	}

	/**
	 * Get the dungeon.
	 * @return dungeon
	 */
	public static Dungeon getCurrent()
	{
		return Dungeon.instance;
	}

	/**
	 * Removes the returned item from the appropriate room.
	 * @param position
	 * @null if there is nothing to gather.
	 */
	public Item loot(Point position)
	{
		for(Room room : rooms)
		{
			for(Item item : room.getItems())
			{
				Item temp = null;
				if(item.getPosition().equals(position))
				{
					temp = item;
					room.getItems().remove(item);
					return temp;

				}
			}
		}
		return null;
	}

	/**
	 * Moves all the monsters.
	 * @param heroMoved true is hero moved, false otherwise.
	 */
	public void monsterMove(boolean heroMoved)
	{
		if(heroMoved)
			for(Monster monster : this.getMonsters())
			{
				monster.makeAutonomousMove();
				monster.regenerate(monster.getRegeneration());
			}
		hero.regenerate(hero.getRegeneration());
	}

	/**
	 * Removes the given player from the room, if present.
	 * @param player
	 */
	public void removeMonster(Player monster)
	{
		Iterator<Monster> it = monsters.iterator();
		while(it.hasNext())
		{
			if(it.next().getPosition().equals(monster.getPosition()))
				it.remove();	
		}
	}

	/**
	 *  Adds a monster to the dungeon.
	 * @param player
	 */
	public void addMonster(Monster monster)
	{
		monsters.add(monster);
	}

	/**
	 * Adds a room the the dungeon.
	 */
	public void addRoom(Room room)
	{
		rooms.add(room);
	}	

	/**
	 * Adds a hero to the dungeon.
	 * @param hero
	 */
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}

	/**
	 * Set the scalefactor.
	 * @param scale
	 */
	public void setScalefactor(int scale)
	{
		this.scalefactor = scale;
	}
	
	public String inventory()
	{
		String inventory = "";
		String heroWep = "";
		if(!(hero.getWeapon() == null))
			heroWep = "" + hero.getWeapon().getDamage();
		
		inventory = inventory + "Hero name: " + this.hero.getName() + "\n" +	
				"Hero health: " + hero.getHealth() + "\n" + 
				"Damage: " + hero.getDamageLevel() + "\n" +
				"Weapon damage: " + heroWep;
		return inventory;
	}
	
	// Get methods.
	public String getDescription(){return description;}
	public Hero getHero(){return this.hero;}
	public ArrayList<Room> getRoom(){return rooms;}
	public int getScalefactor(){return scalefactor;}
	public ArrayList<Monster> getMonsters(){return monsters;}
	
}
