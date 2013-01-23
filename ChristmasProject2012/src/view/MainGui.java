package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Control;
import controlEntity.Sled;
import db.FakeDbConnector;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class MainGui extends JFrame implements ActionListener
{
	private JButton button1;
	private Control control;
	
	public MainGui() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(226, 78);
		Container contentPane = getContentPane();
		
		
		JPanel content = new JPanel(null);
//		content.setSize(210, 40);
		
		button1 = new JButton("Get one sled");
		button1.addActionListener(this);
		button1.setBounds(5, 5, 200, 30);
		
		control = new Control(new FakeDbConnector());
		
		
		contentPane.add(content);
		content.add(button1);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(button1))
		{
			Sled sled = control.loadSledFromDatabase();
			sled.print();
		}
		
	}
}
