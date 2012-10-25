package control;

import view.MainFrame;
import model.Class;
import model.School;
import model.Student;;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		DemoData dd = new DemoData();
		School s = dd.demoInitialise();
		new MainFrame(s);
		;
	}
	
	
}