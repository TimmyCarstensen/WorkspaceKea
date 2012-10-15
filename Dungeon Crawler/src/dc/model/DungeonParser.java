// lqp693
package dc.model;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

import java.util.Scanner;

import dc.model.items.Armor;
import dc.model.items.Weapon;
import dc.model.players.type.Goblin;
import dc.model.players.type.Orc;

/**
 * 
 * @author Timmy
 * @version 1.0
 * 
 */
public class DungeonParser
{
	private final String DEFAULT_FILEPATH = System.getProperty("user.home")+"/dungeon.map";
	
	public DungeonParser() throws FileNotFoundException
	{
		
	}
	
	/**
	 * Parse a file and make a dungeon with rooms, doors, items and monsters.
	 * The file to be read has to of the form:
	 * <scale>
	 * room: <x1> <y1> <x2> <y2>
	 * door: <x1> <y1> <x2> <y2>
	 * monster: <x> <y> <type>
	 * item: <x> <y> <type> <argument>
	 * 
	 * @param hero
	 * @return a dungeon
	 * @throws FileNotFoundException
	 */
	public Dungeon readFromFile() throws FileNotFoundException
	{
		// create the new dungeon
		Dungeon dungeon = Dungeon.initialize();
		
		//buffered reader, reads from file.
		Reader reader = new BufferedReader(new FileReader(DEFAULT_FILEPATH));
		Scanner s = new Scanner(reader);
		
		// Scalefactor of the dungeon is set by reading from the file.
		dungeon.setScalefactor(s.nextInt());
		
		//Rooms are added to the dungeon.
		String tjek = "";
		tjek = s.next();
		
		// add rooms to the dungeon!
		while(tjek.toLowerCase().equals("room:"))
		{
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			dungeon.addRoom(new Room(new Point(x1, y1), new Point(x2,y2)));
			s.nextLine();
			tjek = s.next();
			
			
			// add doors to the dungeon!
		}
		while(tjek.toLowerCase().equals("door:"))
		{
			Point door1 = new Point(s.nextInt(), s.nextInt());
			Point door2 = new Point(s.nextInt(), s.nextInt());
			
			Room tempRoom1 = null;
			Room tempRoom2 = null;
			// get rooms, that doors exist in.
			for(Room room : dungeon.getRoom())
				if(room.isInside(door1))
				{
					tempRoom1 = room;
					break;
				}
			for(Room room : dungeon.getRoom())
				if(room.isInside(door2))
				{
					tempRoom2 = room;
					break;
			}
			// Doors are added here to the connected rooms.
			for(Room room : dungeon.getRoom())
			{
				if(room.gettopLeft().equals(tempRoom1.gettopLeft()))
					room.addDoor(door1, tempRoom2);
				if(room.gettopLeft().equals(tempRoom2.gettopLeft()))
					room.addDoor(door2, tempRoom1);
			}
			
			s.nextLine();
			tjek = s.next();
			
			// add monsters to the dungeon!
		}
		while(tjek.toLowerCase().equals("monster:"))
		{
			Point position = new Point(s.nextInt(), s.nextInt());
			String typeMonster = s.next();
			
			if(typeMonster.equals("G"))
				dungeon.addMonster(new Goblin(position, dungeon));
			if(typeMonster.equals("O"))
				dungeon.addMonster(new Orc(position, dungeon));
			
			s.nextLine();
			tjek = s.next();
			
			// add items to the dungeon!
		}
		while(s.hasNextLine())
		{
			Point position = new Point(s.nextInt(), s.nextInt());
			String typeItem = s.next();
			if(typeItem.equals("W")){
				for(Room room : dungeon.getRoom())
					if(room.isInside(position))
							room.addItem(new Weapon(position, s.nextInt()));
			}else if(typeItem.equals("A"))
			{
				for(Room room : dungeon.getRoom())
					if(room.isInside(position))
						room.addItem(new Armor(position, s.nextInt()));
				}
			if(s.hasNext())tjek = s.next();
		}
		
		s.close();
		return dungeon;
	
	}
}
