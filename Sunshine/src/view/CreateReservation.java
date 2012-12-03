package view;

import java.awt.BorderLayout;
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

		// North layout is add
		topNorthNorth.add(new JLabel("Create Reservation"));
		TopNorthSouth.add(new JLabel(" Choose Customer: "));
		TopNorthSouth.add(buttomSouthNorth.add(this.jcbCustomer));
		TopNorthSouth.add(new JLabel(" Or Create Customer: "));
		
		TopNorthSouth.add(this.CreateCustomer);
		topNorth.add(topNorthNorth, new FlowLayout());
		topNorth.add(TopNorthSouth, new FlowLayout());
		
		
		
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

		
		
		buttomSouthSouth.add(ok);
		buttomSouthSouth.add(cancel);
		
		buttomSouth.add(buttomSouthSouth,BorderLayout.SOUTH);

		// colors
		//		rbnfourBeds.setBackground(Color.PINK);
		//		rbnsixBeds.setBackground(Color.PINK);
		//		rbneightBeds.setBackground(Color.PINK);
		//		rbntwelveBeds.setBackground(Color.PINK);
		//		rbncottageTypeLuxury.setBackground(Color.PINK);
		//		rbncottageTypeStandard.setBackground(Color.PINK);
		//		topNorth.setBackground(Color.PINK);
		//		mainCenter.setBackground(Color.PINK);
		//		centerNorth.setBackground(Color.PINK);
		//		centerCenter.setBackground(Color.PINK);
		//		centerSouth.setBackground(Color.PINK);
		//		buttomSouth.setBackground(Color.PINK);
		//		buttomSouthSouth.setBackground(Color.PINK);
		//		buttomSouthNorth.setBackground(Color.PINK);	

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
//		BufferedImage buttonIcon = ImageIO.read(new File("canceltest.jpg"));
//		cancel = new JButton(new ImageIcon(buttonIcon));
//		cancel.setBorder(BorderFactory.createEmptyBorder());
//		cancel.setContentAreaFilled(false);
//		
//		BufferedImage Okicon = ImageIO.read(new File("oktest.png"));
//		ok = new JButton(new ImageIcon(Okicon));
//		ok.setBorder(BorderFactory.createEmptyBorder());
//		ok.setContentAreaFilled(false);