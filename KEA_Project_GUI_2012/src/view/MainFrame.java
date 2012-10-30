package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.School;
import model.Class;
import javax.swing.JComboBox;
import javax.swing.JTextField;


/**
 * 
 * @author Timmy Carstensen
 *
 */
public class MainFrame extends JFrame // implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private School school;
	private JButton addStudent, addClass;
	private JPanel jpSouth;
	private JTextField textFieldForCombobox;
	private JComboBox<String[]> comboBox;

	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainFrame(School s)
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));

		JPanel contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);

		//Show an option pane when program starts
		//String name = JOptionPane.showInputDialog(null, "Enter School name?");
		String name = "Københavns Erhvervs Akademi";
		this.school = s;

		//Initialise components
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();

		//This is made because debugger wouldn't work, tjek that demoData is add to MainFrame in Run-class!
		//for(Class c : s.getClasses())
		//{
		//    JOptionPane.showMessageDialog(null, c.getName());
		//}

		//Add components

		JLabel schoolNameLabel = new JLabel(name);
		jpNorth.add(schoolNameLabel);

		//Give components functionality		
		schoolNameLabel.setFont(new Font("Monospaced", Font.BOLD, 27));

		jpCenter.setLayout(null);
		
		comboBox = new JComboBox(school.getClassNames());

		comboBox.setBounds(298, 337, 133, 20);
		jpCenter.add(comboBox);

		//Textfield used to test my combobox
		textFieldForCombobox = new JTextField();
		textFieldForCombobox.setBounds(298, 306, 86, 20);
		jpCenter.add(textFieldForCombobox);
		textFieldForCombobox.setColumns(14);

		// Create buttons
		buttons();
		// Frame becomes visible

		contentPane.add(jpNorth, BorderLayout.NORTH);
		contentPane.add(jpCenter, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * 
	 */
	public void buttons()
	{
		this.jpSouth = new JPanel(new FlowLayout());
		getContentPane().add(this.jpSouth, BorderLayout.SOUTH);

		this.addStudent = new JButton("Add Student");
		this.jpSouth.add(addStudent);
		addStudent.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		this.addClass = new JButton("Add Class");
		jpSouth.add(addClass);
		this.addClass.addActionListener(new ActionListener()
		{
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void actionPerformed(ActionEvent e)
			{

				String text = "Class " + textFieldForCombobox.getText();
				System.out.println(text);
				school.addClass(new Class(text));
				
				DefaultComboBoxModel model = new DefaultComboBoxModel(school.getClassNames());  
				comboBox.removeAllItems();  
				comboBox.setModel(model);
			      
			}
		});
	}

	public void setSchoole(School s){this.school = s;}
}