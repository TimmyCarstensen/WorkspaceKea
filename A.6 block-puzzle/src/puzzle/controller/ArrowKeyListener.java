package puzzle.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import puzzle.model.BoardModel;
import puzzle.model.direction.Down;
import puzzle.model.direction.Left;
import puzzle.model.direction.Right;
import puzzle.model.direction.Up;


public class ArrowKeyListener implements KeyListener
{
	@Override
	/**
	 * MÅSKE FÆRDIG, IKKE KOMMENTERET!!!
	 */
	public void keyReleased(KeyEvent keyEvent)
	{
		BoardModel boardModel = BoardModel.getCurrent();
		
		switch(keyEvent.getKeyCode()){
		case KeyEvent.VK_UP: 
			boardModel.move(Up.getInstance());	
			break;
		case KeyEvent.VK_DOWN: 
			boardModel.move(Down.getInstance());
			break;
		case KeyEvent.VK_LEFT: 
			boardModel.move(Left.getInstance());
			break;
		case KeyEvent.VK_RIGHT: 
			boardModel.move(Right.getInstance());
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		// nothing to do.
	}

	@Override
	public void keyTyped(KeyEvent keyEvent)
	{
		// nothing to do.
	}
}
