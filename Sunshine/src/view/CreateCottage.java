package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Resort;
/**
 * 
 * @author Hisayo
 *
 */
public class CreateCottage extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtBeds;
	private JTextField txtPrice;
	private JButton btnCancel;
	private JButton btnOk;
	private JRadioButton radioBtnS;
	private JRadioButton radioBtnL;

	public CreateCottage(final Resort resort, final Main main)
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(300,200));
		setLayout(new BorderLayout());
		setTitle(" Create Cottage ");

		this.txtName = new JTextField(8);
		this.txtBeds = new JTextField(8);
		this.txtPrice = new JTextField(8);

		JPanel north = new JPanel( new GridLayout(3,3));
		north.add(new JLabel(" Cottage Name : "));
		north.add(txtName);
		north.add(new JLabel(" Beds : "));
		north.add(txtBeds);
		north.add(new JLabel(" Price : "));
		north.add(txtPrice);


		JPanel center = new JPanel(new GridLayout(1,2));
		this.radioBtnS = new JRadioButton("Standard", true);
		this.radioBtnL = new JRadioButton("Luxury", false);

		final ButtonGroup bg = new ButtonGroup();
		bg.add(this.radioBtnL);
		bg.add(this.radioBtnS);




		center.add(radioBtnS);
		center.add(radioBtnL);



		JPanel south = new JPanel(new GridLayout(1,2));
		this.btnCancel = new JButton("Cancel");
		this.btnOk = new JButton("OK");

		btnCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnOk.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean FilledOutFields = true;
				char typeOfCottage = 's';
				if(radioBtnL.isSelected())
					typeOfCottage = 'l';

				String a = txtName.getText();
				String b = txtBeds.getText();
				String c = txtPrice.getText();

				try{
					if(a.isEmpty() || b.isEmpty() || c.isEmpty())
					{
						throw new Exception();
					}
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, "Fill out the fields");
					FilledOutFields = false;
				}
				try{
					if(FilledOutFields){
						resort.createCottage(typeOfCottage, txtName.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(txtBeds.getText()), false);
						JOptionPane.showMessageDialog(null, "Cottage is created with following information:\n" + 
															"Cottage Name: " + a +"\n" + 
															"Number of Beds: " + b + "\n" + 
															"Price for cottage: " + c );
						main.updateCottageTable();
						dispose();
					}
				}catch(NumberFormatException ee)
				{
					JOptionPane.showMessageDialog(null, "You must enter number with beds and price!");
				}
			}
		});
		
		south.add(btnOk);
		south.add(btnCancel);
		
		add(north,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
