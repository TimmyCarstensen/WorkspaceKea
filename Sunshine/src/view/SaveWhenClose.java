/**
 *  @author Kenneth Buntzen
 *
 */

package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import model.Resort;

public class SaveWhenClose implements WindowListener
{

	private Main main;
	private Resort resort;
	public SaveWhenClose(Main main, Resort resort)
	{
		this.main = main;
		this.resort = resort;
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to save?");
		if (choice == JOptionPane.YES_OPTION)
		{
			resort.quit();
			main.dispose();
		}else if(choice == JOptionPane.NO_OPTION)			
			main.dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}

