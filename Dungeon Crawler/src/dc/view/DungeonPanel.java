// lqp693
package dc.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import dc.model.Dungeon;
import dc.model.Point;
import dc.model.Room;
import dc.model.items.Item;
import dc.model.players.Player;

/**
 * Draw the dungeon with doors, monsters, the hero, and items.
 * @author Timmy
 * @version 1.0
 */
public class DungeonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Dungeon dungeon;
	private int scaleFactor;

	/**
	 * @param d Dungeon
	 */
	public DungeonPanel(Dungeon d)
	{
		this.dungeon = d;
		this.scaleFactor = d.getScalefactor();
	}

	/**
	 * @param g Graphics
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		drawRoomItem(g);
		drawDoors(g);
		drawMonster(g);
		drawHero(g);
	}

	/**
	 * Draw the doors.
	 * @param g Graphics
	 */
	public void drawDoors(Graphics g)
	{
		int x, y;		
		g.setColor(Color.GREEN);
		for(Room room : dungeon.getRoom())
		{
			Point[] doorPos = new Point[room.getDoors().size()];
			doorPos = (Point[]) room.getDoors().keySet().toArray(doorPos);
			for(Point p : doorPos)
			{
				x = p.getX();
				y = p.getY();
				g.drawOval(x*scaleFactor, y*scaleFactor, scaleFactor, scaleFactor);
			}
		}
	}

	/**
	 * Draw the rooms and the items in the rooms.
	 * @param g Graphics
	 */
	public void drawRoomItem(Graphics g)
	{
		int x, y, h, w;
		for(Room room : dungeon.getRoom())
		{
			g.setColor(Color.BLACK);
			x = room.gettopLeft().getX();
			y = room.gettopLeft().getY();
			h = (room.getbottomRight().getX() - x) * scaleFactor;
			w = (room.getbottomRight().getY() - y) * scaleFactor;
			g.drawRect(x * scaleFactor, y * scaleFactor, h, w);
			for(Item item : room.getItems())
			{
				g.setColor(Color.YELLOW);
				x = item.getPosition().getX();
				y = item.getPosition().getY();
				g.drawOval(x*scaleFactor, y*scaleFactor, scaleFactor, scaleFactor);

			}
		}
	}

	/**
	 * Draw the monsters.
	 * @param g Graphics
	 */
	public void drawMonster(Graphics g)
	{
		int x, y;
		for(Player monster : dungeon.getMonsters())
		{
			g.setColor(Color.BLUE);
			x = monster.getPosition().getX();
			y = monster.getPosition().getY();
			g.drawOval(x*scaleFactor, y*scaleFactor, scaleFactor, scaleFactor);
		}
	}

	/**
	 * Draw the hero. 
	 * @param g Graphics
	 */
	public void drawHero(Graphics g)
	{
		if(!dungeon.getHero().isDead())
		{
			int x, y;
			g.setColor(Color.RED);
			x = dungeon.getHero().getPosition().getX();
			y = dungeon.getHero().getPosition().getY();
			g.drawOval(x*scaleFactor, y*scaleFactor, scaleFactor, scaleFactor);
		}
	}
}
