package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class AddBook extends JFrame implements ActionListener{

	private static final long serialVersionUID = 8781864606563763782L;

	/**
	 * 
	 */
	public AddBook()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(new Point(900,300));
		setSize(new Dimension(230, 180));
		
		// a contentPane
		JPanel content = new JPanel(new GridLayout(6,1));
		setContentPane(content);
		
		// adding components
		JLabel l_author = new JLabel("Author");
		JTextField t_author = new JTextField();
		JLabel l_title = new JLabel("Title");
		JTextField t_title = new JTextField();
		JLabel l_publisher = new JLabel("Publisher");
		JComboBox<String> j_publisher = new JComboBox<String>();
		
		content.add(l_author);
		content.add(t_author);
		content.add(l_title);
		content.add(t_title);
		content.add(l_publisher);
		content.add(j_publisher);
		
		
		// Adding components to frame
		
		setResizable(false);
		// pack();
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
