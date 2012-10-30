package model;

//import java.lang.Math;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Advokat {

	private String name;
	
	/**
	 * This is extra. Made it because a lawyer always has a name.
	 * @param name
	 */
	public Advokat (String name)
	{
		this.name = name;
	}
	
	// Get and set methods for the attribut name of advokat
	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	
	
}