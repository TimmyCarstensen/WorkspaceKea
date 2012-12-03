// Matias og Kenneth

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Resort;

public class CreateCustomer extends JFrame implements ActionListener {

	/**
	 * 
	 */
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
	
	public CreateCustomer(final Resort resort, final Main main)
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600,300));
		setLayout(new BorderLayout());
		setTitle(" Create Customer ");

		this.txtName = new JTextField();
		this.txtTelephoneNumber = new JTextField();
		
		this.txtAdress = new JTextField();
		this.txtEmail = new JTextField();
		this.txtCvr_Cpr = new JTextField();

		JPanel Center = new JPanel(new GridLayout(8,1));
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

				JOptionPane.showMessageDialog(null, "Customer succesfully created");
				main.updateCustomerTable();
				dispose();
				}

			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

