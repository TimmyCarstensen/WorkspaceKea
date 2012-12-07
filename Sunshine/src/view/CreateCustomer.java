/**
 * @author Matias og Kenneth
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Resort;

public class CreateCustomer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtName,txtTelephoneNumber,txtAdress,txtEmail,txtCvr_Cpr;	
	private JRadioButton radioButtonFirm,radioButtonTourist;
	private JButton buttonCancel,buttonOk;
	private boolean from_CreateReservation;
	
	public CreateCustomer(final Resort resort, final Main main, final boolean from_CreateReservation)
	{
		this.from_CreateReservation = from_CreateReservation;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(400,300));
		setLayout(new BorderLayout());
		setTitle(" Create Customer ");

		this.txtName = new JTextField();
		this.txtTelephoneNumber = new JTextField();
		
		this.txtAdress = new JTextField();
		this.txtEmail = new JTextField();
		this.txtCvr_Cpr = new JTextField();

		JPanel Center = new JPanel(new GridLayout(6,1));
		Center.setBackground(Color.DARK_GRAY);

		
		JLabel name = new JLabel(" Name : ");
		name.setForeground(Color.WHITE);
		Center.add(name);
		Center.add(txtName);
		JLabel telephoneNumber = new JLabel(" Telephone Number :");
		telephoneNumber.setForeground(Color.WHITE);
		Center.add(telephoneNumber);
		Center.add(txtTelephoneNumber);
		JLabel adress = new JLabel(" Adress :");
		adress.setForeground(Color.WHITE);
		Center.add(adress);
		Center.add(txtAdress);
		JLabel email = new JLabel(" Email : ");
		email.setForeground(Color.WHITE);
		Center.add(email);
		Center.add(txtEmail);
		JLabel cvrorcpr = new JLabel("Cvr or Cpr");
		cvrorcpr.setForeground(Color.WHITE);
		Center.add(cvrorcpr);
		Center.add(txtCvr_Cpr);
		

		

		JPanel North = new JPanel(new GridLayout(1,2));
		North.setBackground(Color.DARK_GRAY);
		
		this.radioButtonFirm = new JRadioButton(" Firm ", true);
		this.radioButtonTourist = new JRadioButton(" Tourist ", false);
		radioButtonFirm.setBackground(Color.DARK_GRAY);
		radioButtonFirm.setForeground(Color.WHITE);
		radioButtonTourist.setBackground(Color.DARK_GRAY);
		radioButtonTourist.setForeground(Color.WHITE);
		
		JLabel customerInfo = new JLabel(" Customer Info ");
		customerInfo.setForeground(Color.WHITE);
		North.add(customerInfo);
		North.add(radioButtonFirm);
		North.add(radioButtonTourist);



		ButtonGroup Group = new ButtonGroup();
		Group.add(radioButtonFirm);
		Group.add(radioButtonTourist);
		
		JPanel South = new JPanel(new GridLayout(1,2));
		South.setBackground(Color.DARK_GRAY);
		this.buttonOk = new JButton(" Ok ");
		this.buttonCancel = new JButton(" Cancel ");



		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
		South.add(buttonOk);
		South.add(buttonCancel);



		add(North,BorderLayout.NORTH);
		add(Center,BorderLayout.CENTER);
		add(South,BorderLayout.SOUTH);
		setVisible(true);


		buttonCancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});

		buttonOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean FilledOutFields = true;
				char typeOfCustomer = 'f';
				
				if(radioButtonTourist.isSelected())
				{
					typeOfCustomer = 't';
				}
				
				String customerName = txtName.getText();
				String customerTelephone = txtTelephoneNumber.getText();
				String customerAddress = txtAdress.getText();
				String customerEmail = txtEmail.getText();
				String customerCvr_Cpr = txtCvr_Cpr.getText();
				
				try{
				if(customerName.isEmpty() || customerTelephone.isEmpty() || customerAddress.isEmpty() || customerEmail.isEmpty() || customerCvr_Cpr.isEmpty())
				{
					throw new Exception();
				}
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, "Fill out the fields");
					FilledOutFields = false;
				}
				if(FilledOutFields){
				resort.createCustomer(typeOfCustomer, customerName, customerTelephone, customerAddress, customerEmail, customerCvr_Cpr);

				JOptionPane.showMessageDialog(null, "Customer is created with following information:\n" + 
													"Name: " + customerName + "\n" + 
													"Telephonenumber: " + customerTelephone + "\n" +
													"Adress: " + customerAddress + "\n" + 
													"Email: " + customerEmail + "\n" + 
													"Cvr/Cpr number: " + customerCvr_Cpr + "\n");
				main.updateCustomerTable();
				if(from_CreateReservation)
				{
					dispose(); 
				// Hvorfor skal den bruge IO exceptions her?
					try {
						new CreateReservation(resort,main);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				else
					dispose();
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getFrom_CreateReservation()
	{
		return this.from_CreateReservation;
	}
}

