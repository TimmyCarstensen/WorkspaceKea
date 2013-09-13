package part01_recap_oop;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class PersonFrame extends JFrame 
{	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textfCpr;
	private JTextField textfName;
	private JTextField textfAddress;
	private JTextField textfZip;
	private JTextField textfCity;
	private JTextField textfEmail;

	private JTextArea txtrAreaTest;

	private ArrayList<Person> persons;
	/**
	 * Create the frame.
	 */
	public PersonFrame() 
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		
		persons = new ArrayList<Person>();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create Labels
		createLabels();
		
		// Create TextFields
		createTextFields();
		
		txtrAreaTest = new JTextArea();
		txtrAreaTest.setBounds(354, 86, 198, 177);
		contentPane.add(txtrAreaTest);
		
		JButton btnMakeNew = new JButton("Make new");
		btnMakeNew.setBounds(80, 284, 100, 23);
		btnMakeNew.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				addNewPerson(textfCpr.getText(), textfName.getText(), 
						textfAddress.getText(), textfZip.getText(), 
						textfCity.getText(), textfEmail.getText());
				clearText();
			}
		});
		
		contentPane.add(btnMakeNew);
		
		JButton btnShowInTextarea = new JButton("Show in TextArea");
		btnShowInTextarea.setBounds(190, 284, 138, 23);
		btnShowInTextarea.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txtrAreaTest.setText(textToBeShownInTextArea());
			}
			
		});

		contentPane.add(btnShowInTextarea);
		
		
	}
	
	public void clearText()
	{
		textfCpr.setText("");
		textfName.setText("");
		textfAddress.setText("");
		textfZip.setText("");
		textfCity.setText("");
		textfEmail.setText("");
	}
	
	/**
	 * tilføjer ny person til arraylist
	 */
	public void addNewPerson(String cpr, String name, String address, String zip, String city, String email)
	{
		Person p = new Person(cpr, name, address, zip, city, email);
		persons.add(p);
	}
	
	/**
	 * Generere tekst til textarea ud fra teksten i textfields.
	 * @return
	 */
	public String textToBeShownInTextArea(){
		return textfCpr.getText() + "\n" + textfName.getText() + "\n" + textfAddress.getText() + 
			   "\n" + textfZip.getText() + "\n" + textfCity.getText() + "\n" + textfEmail.getText();
	}
	
	/**
	 * Create Labels
	 */
	public void createLabels()
	{
		JLabel lblCpr = new JLabel("CPR");
		lblCpr.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblCpr.setBounds(43, 91, 27, 14);
		contentPane.add(lblCpr);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblName.setBounds(43, 122, 27, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblAddress.setBounds(31, 153, 39, 14);
		contentPane.add(lblAddress);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblZip.setBounds(50, 184, 20, 14);
		contentPane.add(lblZip);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblCity.setBounds(50, 215, 20, 14);
		contentPane.add(lblCity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblEmail.setBounds(43, 246, 27, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("PersonClass");
		lblNewLabel.setFont(new Font("Nightclub BTN", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(108, 28, 181, 28);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * Create TextFields
	 */
	public void createTextFields()
	{
		textfCpr = new JTextField();
		textfCpr.setBounds(80, 91, 104, 20);
		contentPane.add(textfCpr);
		textfCpr.setColumns(10);
		
		textfName = new JTextField();
		textfName.setBounds(80, 122, 122, 20);
		contentPane.add(textfName);
		textfName.setColumns(10);
		
		textfAddress = new JTextField();
		textfAddress.setBounds(80, 153, 153, 20);
		contentPane.add(textfAddress);
		textfAddress.setColumns(10);
		
		textfZip = new JTextField();
		textfZip.setBounds(80, 184, 56, 20);
		contentPane.add(textfZip);
		textfZip.setColumns(10);
		
		textfCity = new JTextField();
		textfCity.setBounds(80, 215, 153, 20);
		contentPane.add(textfCity);
		textfCity.setColumns(10);
		
		textfEmail = new JTextField();
		textfEmail.setBounds(80, 246, 153, 20);
		contentPane.add(textfEmail);
		textfEmail.setColumns(10);
	}
	
}
