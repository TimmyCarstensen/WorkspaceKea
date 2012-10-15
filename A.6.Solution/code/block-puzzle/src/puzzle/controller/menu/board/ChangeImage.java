package puzzle.controller.menu.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import puzzle.model.BoardModel;
import puzzle.view.MainFrame;


public class ChangeImage implements ActionListener
{
	public ChangeImage()
	{
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		MainFrame mainFrame = MainFrame.getInstance();
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
		int result = fileChooser.showOpenDialog(mainFrame);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fileChooser.getSelectedFile();
			BoardModel.getCurrent().changeBackgroundImage(selectedFile.getAbsolutePath());
		}
		mainFrame.requestFocus();
		
	}
}
