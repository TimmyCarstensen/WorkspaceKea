/**
 * @author Matias og Kenneth
 */

package view;

import java.awt.BorderLayout;
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
	private JTextField txtName;
	private JTextField txtTelephoneNumber;
	private JTextField txtAdress;
	private JTextField txtEmail;
	private JTextField txtCvr_Cpr;	
	private JRadioButton radioButtonFirm;
	private JRadioButton radioButtonTourist;
	private JButton buttonCancel;
	private JButton buttonOk;
	private boolean from_CreateReservation;
	
	public CreateCustomer(final Resort resort, final Main main, final boolean from_CreateReservation)
	{
		this.from_CreateReservation = from_CreateReservation;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(600,300));
		setLayout(new BorderLayout());
		setTitle(" Create Customer ");

		this.txtName = new JTextField();
		this.txtTelephoneNumber = new JTextField();
		
		this.txtAdress = new JTextField();
		this.txtEmail = new JTextField();
		this.txtCvr_Cpr = new JTextField();

		JPanel Center = new JPanel(new GridLayout(8,1));
//		
//		this.txtName.setOpaque(true);
//		this.txtTelephoneNumber.setOpaque(true);
//		this.txtAdress.setOpaque(true);
//		this.txtEmail.setOpaque(true);
//		this.txtCvr_Cpr.setOpaque(true);
//		this.txtName.setBackground(Color.WHITE);
		
		Center.add(new JLabel(" Name "));
		Center.add(txtName);
		Center.add(new JLabel(" Telephone Number "));
		Center.add(txtTelephoneNumber);
		Center.add(new JLabel(" Adress "));
		Center.add(txtAdress);
		Center.add(new JLabel(" Email "));
		Center.add(txtEmail);
		Center.add(new JLabel(" Cvr or Cpr "));
		Center.add(txtCvr_Cpr);
		
//		Center.setBackground(Color.DARK_GRAY);
		

		JPanel North = new JPanel(new GridLayout(1,2));
		this.radioButtonFirm = new JRadioButton(" Firm ", true);
		this.radioButtonTourist = new JRadioButton(" Tourist ", false);
		North.add(new JLabel("Customer Information"));
		North.add(radioButtonFirm);
		North.add(radioButtonTourist);



		ButtonGroup Group = new ButtonGroup();
		Group.add(radioButtonFirm);
		Group.add(radioButtonTourist);

		JPanel South = new JPanel(new GridLayout(1,2));
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
				
				String a = txtName.getText();
				String b = txtTelephoneNumber.getText();
				String c = txtAdress.getText();
				String d = txtEmail.getText();
				String f = txtCvr_Cpr.getText();
				
				try{
				if(a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || f.isEmpty())
				{
					throw new Exception();
				}
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, "Fill out the fields");
					FilledOutFields = false;
				}
				if(FilledOutFields){
				resort.createCustomer(typeOfCustomer, txtName.getText(), txtTelephoneNumber.getText(), txtAdress.getText(), txtEmail.getText(), txtCvr_Cpr.getText());

				JOptionPane.showMessageDialog(null, "Customer is created with following information:\n" + 
													"Name: " + a + "\n" + 
													"Telephonenumber: " + b + "\n" +
													"Adress: " + c + "\n" + 
													"Email: " + d + "\n" + 
													"Cvr/Cpr number: " + f + "\n");
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

