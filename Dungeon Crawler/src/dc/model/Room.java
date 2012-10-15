// lqp693
package dc.model;

import dc.model.items.*;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * 
 * @author Timmy
 * @version 1.0
 *
 */
public class Room 
{
	private Point topLeft, bottomRight;
	private HashMap<Point, Room> doors;
	private ArrayList<Item> items;

	/**
	 * Constructs a room.
	 * @param topLeft the top left corner of the room.
	 * @param bottomRight the bottom right corner of the room.
	 */
	public Room(Point topLeft, Point bottomRight)
	{
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		doors = new HashMap<Point, Room>();
		items = new ArrayList<Item>();
	}
	
	/**
	 * 
	 * @param point
	 * @return true if a given position is inside the bounds of the room.
	 */
	public boolean isInside(Point point)
	{
		return point.getX() >= topLeft.getX() && 
			   point.getY() >= topLeft.getY() && 
			   point.getX() < bottomRight.getX() &&
			   point.getY() < bottomRight.getY();
	}

	/**
	 * Add a door to the room.
	 * @param point - Position of the door.
	 * @param room - The room where the door is placed.
	 */
	public void addDoor(Point point, Room room)
	{
		doors.put(point, this);
	}

	/**
	 * 
	 * @param p position of the door
	 * @return true if there is a door
	 */
	public boolean isDoor(Point p)
	{
		return null != (doors.get(p));
	}

	/**
	 * Removes a item from the room. 
	 * @param item
	 */
	public void removeItem(Item item)
	{
		for(int i = 0; i < items.size(); i++)
			if(items.get(i).equals(item))
				items.remove(i);
	}

	/**
	 * Adds a item to room.
	 * @param item
	 */
	public void addItem(Item item)
	{
		items.add(item);	
	}

	// Get methods.
	public HashMap<Point, Room> getDoors(){return doors;}
	public ArrayList<Item> getItems(){return items;}
	public Point gettopLeft(){return topLeft;}
	public Point getbottomRight(){return bottomRight;}
}
