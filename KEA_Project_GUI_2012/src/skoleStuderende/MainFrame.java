package skoleStuderende;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class MainFrame extends JFrame // implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private Skole s;
	private JButton addStudent, addClass;
	private JPanel jpSouth;
	
	/**
	 * 
	 */
	public MainFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		
		
		// Show an option pane when program starts
		String name = JOptionPane.showInputDialog(null, "Enter School name?");
		this.s = new Skole(name);
		
		//Initialise components
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JLabel schoolNameLabel = new JLabel(name);

		//Give components functionality		
		schoolNameLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		ArrayList<String> namesOfClasses = new ArrayList<String>();
		for(Class c : s.getClasses())
		{
			namesOfClasses.add(c.getName());
		}
	    JList list = new JList(namesOfClasses.toArray());
	    	
	    
	    //Add components
	    this.add(jpNorth, BorderLayout.NORTH);
	    jpNorth.add(schoolNameLabel);
	    jpCenter.add(list);
	    this.add(jpCenter, BorderLayout.CENTER);
	    
	    	
	    
	    
		// Create buttons
		buttons();
		// Frame becomes visible
		setVisible(true);
	}
	
	/**
	 * 
	 */
	public void buttons()
	{
		this.jpSouth = new JPanel(new FlowLayout());
		this.add(this.jpSouth, BorderLayout.SOUTH);
		
		this.addStudent = new JButton("Add Student");
		this.jpSouth.add(addStudent);
		addStudent.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.addClass = new JButton("Add Class");
		this.addClass.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});

		jpSouth.add(addClass);
	}
	
	
	public JButton getAddStudentButton(){return addStudent;}
	public JButton getAddClassButton(){return addClass;}
	public void setSchoole(Skole s){this.s = s;}
}