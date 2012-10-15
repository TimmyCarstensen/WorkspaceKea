// lqp693
package dc.model.players;

import dc.model.Dungeon;
import dc.model.Point;
import dc.model.items.*;

/**
 * 
 * @author Timmy
 * @version 1.0
 * 
 */
public abstract class Hero extends Player
{
	private String name;
	private Weapon weapon;
	private int regeneration;
	private int magnitude;
	private static final char TYPE = 'h';
	private int armorResistance;

	/**
	 * Constructs a hero. 
	 * @param name - Name of hero.
	 * @param regeneration - Regenerationlevel of hero.
	 * @param magnitude - Magnitudelevel of hero.
	 * @param position - Position of hero. 
	 * @param d - The dungeon.
	 */
	public Hero(String name, int regeneration, int magnitude, Point position, Dungeon d)
	{
		super(position, d);
		this.name = name;
		this.regeneration = regeneration;
		this.magnitude = magnitude;
		this.damageLevel = 5 * this.magnitude;
		this.armorResistance = 0;
	}

	/**
	 * Set the weapon of the hero.
	 * @param weapon - Weapon of the hero.
	 */
	public void setWeapon(Weapon weapon)
	{
		if(this.weapon != null && this.weapon.getDamage() >= weapon.getDamage()) 
			return;
		this.weapon = weapon;
		this.damageLevel = weapon.getDamage() * 3;
	}


	/**
	 * Set the armor of the hero.
	 * @param armor - Armor of the hero.
	 */
	public void setArmor(Armor armor)
	{
		this.armorResistance = armor.getResistance();
	}

	/**
	 * @param damageLevel - the amout of damage taken.
	 */
	public void takeDamage(int damageLevel)
	{
		if(armorResistance > 0)
			armorResistance -= damageLevel;
		else if(armorResistance - damageLevel < 0)
			this.health -= (Math.abs(armorResistance - damageLevel) + damageLevel);
	}

	// Get methods
	public Weapon getWeapon(){return weapon;}
	public int getDamageLevel(){return this.damageLevel;}
	public String getName(){return name;}
	public int getRegeneration(){return regeneration;}
	public char getType(){return TYPE;}
}
