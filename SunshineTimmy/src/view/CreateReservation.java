package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Cottage;
import model.Customer;
import model.Parser;
import model.Resort;

/**
 * 
 * @author Peter og Farhiya
 *
 */
public class CreateReservation extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JRadioButton rbncottageTypeStandard, rbncottageTypeLuxury, rbnfourBeds, rbnsixBeds, rbneightBeds, rbntwelveBeds;
	private JButton ok, cancel;
	private JTextField weekStart, weekEnd;
	private JComboBox<String> jcbCustomer;
	private Resort resort;
	private Main main;
	
	public CreateReservation(Resort resort, Main main)
	{
		this.resort = resort;
		this.main = main;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Create Reservation");



		// JPanels and layout are initialised
		JPanel topNorth = new JPanel(new FlowLayout());
		
		JPanel mainCenter = new JPanel(new BorderLayout());
		JPanel centerNorth = new JPanel (new GridLayout(2,2));
		JPanel centerCenter = new JPanel (new GridLayout(1,3));
		JPanel centerSouth = new JPanel (new GridLayout(1,5));

		JPanel buttomSouth = new JPanel(new BorderLayout());
		JPanel buttomSouthSouth = new JPanel(new FlowLayout());
		JPanel buttomSouthNorth = new JPanel(new FlowLayout());
		
				
		//Radiobuttons for cottagetype initialised
		this.rbncottageTypeStandard = new JRadioButton("Standard");
		this.rbncottageTypeLuxury = new JRadioButton("Luxury");
		ButtonGroup cottageType = new ButtonGroup();
		cottageType.add(this.rbncottageTypeStandard);
		cottageType.add(this.rbncottageTypeLuxury);
		
		//Radiobuttons for beds initialised
		this.rbnfourBeds = new JRadioButton("4");
		this.rbnsixBeds = new JRadioButton("6");
		this.rbneightBeds = new JRadioButton("8");
		this.rbntwelveBeds = new JRadioButton("12");
		ButtonGroup bedNumber = new ButtonGroup(); 
		bedNumber.add(this.rbnfourBeds);
		bedNumber.add(this.rbnsixBeds);
		bedNumber.add(this.rbneightBeds);
		bedNumber.add(this.rbntwelveBeds);
		
		// Add Customer combobox
		this.jcbCustomer = new JComboBox<String>(this.resort.getCustomerArray());
		
		// Cancel, ok and textfields initialised
		this.weekStart = new JTextField();
		this.weekEnd = new JTextField();
		this.ok = new JButton("OK");
		this.cancel = new JButton("Cancel");
		
		// Actionslisteners are assigned
		this.ok.addActionListener(this);
		this.cancel.addActionListener(this);
		
		// North layout is add
		topNorth.add(new JLabel("Create Reservation"));
		
		add(topNorth,BorderLayout.NORTH);
		
		// centerLayout is added
		centerNorth.add(new JLabel("First week"));
		centerNorth.add(weekStart);
		centerNorth.add(new JLabel("Last week"));
		centerNorth.add(weekEnd);
		mainCenter.add(centerNorth,BorderLayout.NORTH);
		
		centerCenter.add(new JLabel("Type of cottage"));
		centerCenter.add(this.rbncottageTypeStandard);
		centerCenter.add(this.rbncottageTypeLuxury);
		mainCenter.add(centerCenter,BorderLayout.CENTER);
		
		centerSouth.add(new JLabel("Number of beds"));
		centerSouth.add(this.rbnfourBeds);
		centerSouth.add(this.rbnsixBeds);
		centerSouth.add(this.rbneightBeds);
		centerSouth.add(this.rbntwelveBeds);
		mainCenter.add(centerSouth, BorderLayout.SOUTH);

		add(mainCenter,BorderLayout.CENTER);
		
		// southlayout is added
		buttomSouthNorth.add(new JLabel(" Choose Customer: "));
		buttomSouthNorth.add(this.jcbCustomer);
		
		buttomSouthSouth.add(ok);
		buttomSouthSouth.add(cancel);
		
		buttomSouth.add(buttomSouthNorth, BorderLayout.NORTH);
		buttomSouth.add(buttomSouthSouth,BorderLayout.SOUTH);
		
		add(buttomSouth, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.cancel))
		{
			this.dispose();
		}
		if(e.getSource().equals(this.ok))
		{
			int startWeek = Integer.parseInt(this.weekStart.getText());
			int endWeek = Integer.parseInt(this.weekEnd.getText());
			int[] weeks = resort.createWeekArray(startWeek, endWeek);
			char typeOfCottage = 0;
			if(this.rbncottageTypeStandard.isSelected())
				typeOfCottage = 's';
			if(this.rbncottageTypeLuxury.isSelected())
			{
				typeOfCottage = 'l';
			}
			int beds = 0;
			if(this.rbnfourBeds.isSelected())
				beds = 4;
			if(this.rbnsixBeds.isSelected())
				beds = 6;
			if(this.rbneightBeds.isSelected())
				beds = 8;
			if(this.rbntwelveBeds.isSelected())
				beds = 12;
			Cottage cottage = null;
			if(resort.checkCottageVancancy(weeks, resort.getYear(), beds, typeOfCottage))
				cottage = resort.getVacantCottage(weeks, resort.getYear(), beds, typeOfCottage);
			else{
				JOptionPane.showMessageDialog(null, "No cottage of this type is vacant! Choose other parameters!");
				return;
			}
			
			String[] s = ((String) (this.jcbCustomer.getSelectedItem())).split(" ");
			Customer customer = resort.findCustomer(s[0]);
			
			
			resort.createReservation(weeks, resort.getYear(), cottage, customer);
			main.updateReservationTable();
			this.dispose();	
		}
	}
}