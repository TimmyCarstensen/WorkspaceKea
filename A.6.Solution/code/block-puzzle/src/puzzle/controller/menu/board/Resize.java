package puzzle.controller.menu.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import puzzle.model.BoardModel;
import puzzle.view.MainFrame;


public class Resize implements ActionListener
{
	public Resize()
	{
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		BoardModel boardModel = BoardModel.getCurrent();
		MainFrame mainFrame = MainFrame.getInstance();
		
		int currentSize = boardModel.getNumberOfSlots() - 1;
		
		String newSizeString = this.showSizeDialog(mainFrame, currentSize);
		mainFrame.requestFocus();
		
		int validationResult = validateSize(newSizeString);
		if (validationResult > 0)
		{
			boardModel.resizeBoard(validationResult);
			return;
		}
		this.showErrorDialog(mainFrame);
		this.actionPerformed(actionEvent);
	}
	
	private String showSizeDialog(MainFrame mainFrame, int currentSize)
	{
		return (String)JOptionPane.showInputDialog(
        mainFrame,
        "Specify the number of blocks (not slots).",
        "Size",
        JOptionPane.PLAIN_MESSAGE,
        null,
        null,
        currentSize);
	}
	
	private int validateSize(String newSizeString)
	{	
		int value;
		try
		{
			value = Integer.parseInt(newSizeString);
		}
		catch (NumberFormatException exception)
		{
			return -1;
		}
		
		if (value < 3)
			return -1;
		return value;
	}

	private void showErrorDialog(MainFrame mainFrame)
	{
		JOptionPane.showMessageDialog(	
			mainFrame,
		  "The size has to be a natural number, and be at least 3.",
		  "Invalid size",
		  JOptionPane.WARNING_MESSAGE);
	}
}
