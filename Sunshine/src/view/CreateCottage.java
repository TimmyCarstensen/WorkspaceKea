package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class CreateCottage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName,txtBeds,txtPrice;
	private JButton btnCancel,btnOk;
	private JRadioButton radioBtnS,radioBtnL;

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
		
		JLabel cottageName = new JLabel(" Cottage Name : ");
		cottageName.setForeground(Color.WHITE);
		JLabel beds = new JLabel(" Beds : ");
		beds.setForeground(Color.WHITE);
		JLabel price = new JLabel(" Price : ");
		price.setForeground(Color.WHITE);
		
		north.add(cottageName);
		north.add(txtName);
		north.add(beds);
		north.add(txtBeds);
		north.add(price);
		north.add(txtPrice);


		JPanel center = new JPanel(new GridLayout(1,2));
		
		this.radioBtnS = new JRadioButton("Standard", true);
		this.radioBtnL = new JRadioButton("Luxury", false);
		
		
		
		final ButtonGroup bg = new ButtonGroup();
		
		bg.add(this.radioBtnL);
		bg.add(this.radioBtnS);
		radioBtnL.setForeground(Color.WHITE);
		radioBtnS.setForeground(Color.WHITE);
		radioBtnL.setBackground(Color.DARK_GRAY);
		radioBtnS.setBackground(Color.DARK_GRAY);
		
		center.add(radioBtnS);
		center.add(radioBtnL);



		JPanel south = new JPanel(new GridLayout(1,2));
		this.btnCancel = new JButton("Cancel");
		this.btnOk = new JButton("OK");

		
		north.setBackground(Color.DARK_GRAY);
		south.setBackground(Color.DARK_GRAY);
		center.setBackground(Color.DARK_GRAY);

		
		
		btnCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnOk.addActionListener(new ActionListener(){
			// Her oprettes en hytte
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// FilledOutFields bruges til at stoppe kode, hvis ikke felterne er udfyldt.
				boolean FilledOutFields = true;
				
				// Her tjekker vi kun for på Radiobutten for luxury cottage, ellers er det s for standard.
				char typeOfCottage = 's';
				if(radioBtnL.isSelected())
					typeOfCottage = 'l';

				// Her hentes teksten fra tekstfelterne, henholdvis navn, pris og senge.
				String cottageName = txtName.getText();
				String cottagePrice = txtPrice.getText();
				String cottageBeds = txtBeds.getText();
				
				try{
					// Tjekker om ansat har indtaster information i tekstfelterne
					if(cottageName.isEmpty() || cottageBeds.isEmpty() || cottagePrice.isEmpty())
					{
						// Exception kastes, hvis tekstfelterne ikke er udfyldt
						throw new Exception();
					}
				}catch(Exception ee)
				{
					// Ansat får besked at tekstfelterne mangler udfyldelse
					JOptionPane.showMessageDialog(null, "Fill out the fields");
					// Sættes til false pga. exception kastet ved manglende udfyldning af tekstfelterne.
					FilledOutFields = false;
				}
				try{
					// Hvis denne er false, så er tekstfelterne ikke udfyldt, der sker således ikke mere!
					// ellers køres koden neden for og hytte oprettes.
					if(FilledOutFields){
						// Hvis ikke ansat benytter tal til pris og senge kastes exception.
						resort.createCottage(typeOfCottage, cottageName, Integer.parseInt(cottagePrice), Integer.parseInt(cottageBeds), false);
						JOptionPane.showMessageDialog(null, "Cottage is created with following information:\n" + 
															"Cottage Name: " + cottageName +"\n" + 
															"Number of Beds: " + cottageBeds + "\n" + 
															"Price for cottage: " + cottagePrice );
						main.updateCottageTable();
						dispose();
					}
				}catch(NumberFormatException ee)
				{
					// Exception kastes hvis ikke pris og senge er tal!
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
}
