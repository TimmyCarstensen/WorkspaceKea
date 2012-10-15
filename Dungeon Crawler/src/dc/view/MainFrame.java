// lqp693
package dc.view;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

import dc.model.Dungeon;
import dc.model.DungeonParser;
import dc.model.Point;
import dc.model.players.type.Cleric;
import dc.model.players.type.Mage;
import dc.model.players.type.Warrior;

public class MainFrame extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private Dungeon dungeon;
	
	
	/**
	 * @throws FileNotFoundException 
	 * @throws Throwable 
	 * 
	 */
	public MainFrame(String title) throws FileNotFoundException
	{
		super(title);
		
		DungeonParser dp = new DungeonParser();
		this.dungeon = dp.readFromFile();
		
		this.setContentPane(new WelcomePanel(this));
				
		this.pack();
		this.setSize(580, 580);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.bindKeyboard();
		this.setFocusable(true);
	}
	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		new MainFrame("DungeonCrawler");
	}
	
	/**
	 * Bind keyboard to this mainframe. 
	 */
	private void bindKeyboard()
	{
		this.addKeyListener(new ArrowKeyListener(this));
	}
	
	/**
	 * Repaint the dungeonPanel.
	 */
	public void refresh()
	{
		this.getContentPane().setVisible(false);
		this.getContentPane().repaint();
		this.getContentPane().setVisible(true);
	}
	
	/**
	 * Chose the hero.
	 * @param heroType - either cleric, warrior or mage.
	 * @param name - Name of hero.
	 */
	public void choseHero(String heroType, String name)
	{
		if(heroType.equals("warrior"))
			dungeon.setHero(new Warrior(name, new Point(1,1), dungeon));
		if(heroType.equals("mage"))
			dungeon.setHero(new Mage(name, new Point(1,1), dungeon));
		if(heroType.equals("cleric"))
			dungeon.setHero(new Cleric(name, new Point(1,1), dungeon));
	}
	
	public void startGamePanel() 
	{
		this.getContentPane().setVisible(false);
		this.setContentPane(new DungeonPanel(dungeon));
		this.pack();
		this.setSize(580, 580);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public Dungeon getDungeon(){return this.dungeon;}
}
