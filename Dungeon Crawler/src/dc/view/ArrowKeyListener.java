//lpq693
package dc.view;

import java.awt.event.KeyEvent;
import dc.view.MainFrame;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import dc.model.Dungeon;

/**
 * 
 * @author Timmy
 * @version 1.0
 */
public class ArrowKeyListener implements KeyListener 
{	
	private MainFrame mainFrame;
	
	/**
	 * 
	 * @param mf - mainFrame.
	 */
	public ArrowKeyListener(MainFrame mf)
	{
		this.mainFrame = mf;
	}
	
	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		switch(keyEvent.getKeyCode())
		{
		case KeyEvent.VK_UP:
			Dungeon.getCurrent().getHero().tryMove(Direction.NORTH);
			mainFrame.refresh();
			break;
		case KeyEvent.VK_DOWN:
			Dungeon.getCurrent().getHero().tryMove(Direction.SOUTH);
			mainFrame.refresh();
			break;
		case KeyEvent.VK_RIGHT:
			Dungeon.getCurrent().getHero().tryMove(Direction.EAST);
			mainFrame.refresh();
			break;
		case KeyEvent.VK_LEFT:
			Dungeon.getCurrent().getHero().tryMove(Direction.WEST);
			mainFrame.refresh();
			break;
		case KeyEvent.VK_I:
		    JOptionPane.showMessageDialog(null, mainFrame.getDungeon().inventory());
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub	
	}
}
