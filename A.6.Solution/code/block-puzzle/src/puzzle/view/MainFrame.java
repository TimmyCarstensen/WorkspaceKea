package puzzle.view;

import javax.swing.JFrame;

import puzzle.controller.ArrowKeyListener;
import puzzle.view.menu.MenuBar;


public class MainFrame extends JFrame
{
	private static final long serialVersionUID = -8808883923263763897L;

	private static MainFrame instance;
	
	private MainFrame()
	{
		super(Language.MAIN_FRAME_TITLE);
		
		this.setSize(300,300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setJMenuBar(new MenuBar());
		
		puzzle.view.Board board = puzzle.view.Board.getCurrent();
		
		if (board != null) {  this.add(board);	}
		
		this.bindKeyboard();
	}
	
	public static MainFrame getInstance()
	{
		if (MainFrame.instance == null)
			MainFrame.instance = new MainFrame();
		return MainFrame.instance;
	}
	
	private void bindKeyboard()
	{
		this.addKeyListener(new ArrowKeyListener());
	}
}
