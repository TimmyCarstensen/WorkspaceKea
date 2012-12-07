package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
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
import model.Reservation;
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
	private JButton ok, cancel,CreateCustomer;
	private JTextField weekStart, weekEnd;
	private JComboBox<String> jcbCustomer;
	private Resort resort;
	private Main main;
	


	public CreateReservation(Resort resort, Main main) throws IOException
	{
		this.resort = resort;
		this.main = main;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Create Reservation");

		// JPanels and layout are initialised
		JPanel topNorth = new JPanel(new GridLayout(2,1));
		JPanel topNorthNorth = new JPanel(new FlowLayout());
		JPanel TopNorthSouth = new JPanel(new GridLayout(2,2));

		JPanel mainCenter = new JPanel(new BorderLayout());
		JPanel centerNorth = new JPanel (new GridLayout(2,2));
		JPanel centerCenter = new JPanel (new GridLayout(1,3));
		JPanel centerSouth = new JPanel (new GridLayout(1,5));

		JPanel buttomSouth = new JPanel(new BorderLayout());
		JPanel buttomSouthSouth = new JPanel(new FlowLayout());
		JPanel buttomSouthNorth = new JPanel(new FlowLayout());


		// Add Customer combobox
		this.jcbCustomer = new JComboBox<String>(this.resort.getCustomerArray());

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

		// Cancel, ok and textfields initialised
		this.weekStart = new JTextField();
		this.weekEnd = new JTextField();
		this.ok = new JButton("OK");
		this.cancel = new JButton("Cancel");
		this.CreateCustomer = new JButton("Create Customer");
		

		// Actionslisteners are assigned
		this.ok.addActionListener(this);
		this.cancel.addActionListener(this);
		this.CreateCustomer.addActionListener(this);

		// North layout is added
		JLabel createReservation = new JLabel("Create Reservation");
		createReservation.setForeground(Color.WHITE);
		topNorthNorth.add(createReservation);
		
		JLabel chooseCustomer = new JLabel(" Choose Customer ");
		chooseCustomer.setForeground(Color.WHITE);
		TopNorthSouth.add(chooseCustomer);
		
		TopNorthSouth.add(buttomSouthNorth.add(this.jcbCustomer));
		
		
		JLabel createCustomer = new JLabel(" Or Create Customer ");
		createCustomer.setForeground(Color.WHITE);
		TopNorthSouth.add(createCustomer);
		TopNorthSouth.add(this.CreateCustomer);
		topNorth.add(topNorthNorth, new FlowLayout());
		topNorth.add(TopNorthSouth, new FlowLayout());

		add(topNorth,BorderLayout.NORTH);

		// First week og end week!
		JLabel firstWeek = new JLabel("First Week");
		firstWeek.setForeground(Color.WHITE);
		centerNorth.add(firstWeek);
		
		centerNorth.add(weekStart);
		
		
		
		JLabel endWeek = new JLabel("Last Week");
		endWeek.setForeground(Color.WHITE);
		centerNorth.add(endWeek);
		
		centerNorth.add(weekEnd);
		
		mainCenter.add(centerNorth,BorderLayout.NORTH);

		
		// Beds og TypeofCottage!!
		JLabel choosetype = new JLabel("Type of Cottage");
		choosetype.setForeground(Color.WHITE);
		centerCenter.add(choosetype);
		centerCenter.add(this.rbncottageTypeStandard);
		centerCenter.add(this.rbncottageTypeLuxury);
		

		JLabel choosebeds = new JLabel("Beds");
		choosebeds.setForeground(Color.WHITE);
		centerSouth.add(choosebeds);
		centerSouth.add(this.rbnfourBeds);
		centerSouth.add(this.rbnsixBeds);
		centerSouth.add(this.rbneightBeds);
		centerSouth.add(this.rbntwelveBeds);
		
		mainCenter.add(centerCenter,BorderLayout.CENTER);
		mainCenter.add(centerSouth, BorderLayout.SOUTH);
		
		
		add(mainCenter,BorderLayout.CENTER);



		buttomSouthSouth.add(ok);
		buttomSouthSouth.add(cancel);

		buttomSouth.add(buttomSouthSouth,BorderLayout.SOUTH);


//colors 

		rbnfourBeds.setForeground(Color.WHITE);
		rbnfourBeds.setBackground(Color.DARK_GRAY);
		rbnsixBeds.setBackground(Color.DARK_GRAY);
		rbnsixBeds.setForeground(Color.WHITE);
		rbneightBeds.setBackground(Color.DARK_GRAY);
		rbneightBeds.setForeground(Color.WHITE);
		rbntwelveBeds.setBackground(Color.DARK_GRAY);
		rbntwelveBeds.setForeground(Color.WHITE);

		rbncottageTypeLuxury.setBackground(Color.DARK_GRAY);
		rbncottageTypeLuxury.setForeground(Color.WHITE);
		rbncottageTypeStandard.setBackground(Color.DARK_GRAY);
		rbncottageTypeStandard.setForeground(Color.WHITE);


		topNorth.setBackground(Color.DARK_GRAY);
		TopNorthSouth.setBackground(Color.DARK_GRAY);
		topNorthNorth.setBackground(Color.DARK_GRAY);
		mainCenter.setBackground(Color.DARK_GRAY);
		centerNorth.setBackground(Color.DARK_GRAY);
		centerCenter.setBackground(Color.DARK_GRAY);
		centerSouth.setBackground(Color.DARK_GRAY);
		buttomSouth.setBackground(Color.DARK_GRAY);
		buttomSouthSouth.setBackground(Color.DARK_GRAY);
		buttomSouthNorth.setBackground(Color.DARK_GRAY);	

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
			// Reservation bliver initialiseret.
			int startWeek = Integer.parseInt(this.weekStart.getText());
			int endWeek = Integer.parseInt(this.weekEnd.getText());
			int[] weeks = resort.createWeekArray(startWeek, endWeek);
			StringBuilder weekprint = new StringBuilder();
			for(int week : weeks)
			{
				weekprint.append(week + ", ");
			}

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

			Reservation r = new Reservation(weeks, cottage, customer); 
			int choice = JOptionPane.showConfirmDialog(null, "Total price: " + r.getTotalPrice());

			if(choice == JOptionPane.NO_OPTION)
				return;

			else if (choice == JOptionPane.YES_OPTION)
			{
				resort.createReservation(weeks, resort.getYear(), cottage, customer);
				JOptionPane.showMessageDialog(null, "Reservation is created with following information:\n" +
						"Customer name: " + customer.getName() + "\n" +
						"Cottage name: " + cottage.getCottageName() + "\n" +
						"Weeks: " + weekprint.toString() + "\n" + 
						"Year: " + resort.getYear() + "\n" +
						"Total price: " + r.getTotalPrice());

				main.updateReservationTable();
				this.dispose();	
			}


		}
		if(e.getSource().equals(CreateCustomer))
		{
			new CreateCustomer(resort, main, true);
			dispose();

		}
	}
}