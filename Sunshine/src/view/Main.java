package view;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Reservation;
import model.Resort;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;

public class Main extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private TableCreator tableCreator;
	private Resort resort;
	private JTabbedPane tabbedPane;
	private JTable cottageTable, customerTable, reservationTable;
	private JScrollPane scrollPaneCottage, scrollPaneCustomer, scrollPaneReservation;
	private JButton createReservationButton, deleteReservationButton, createCustomerButton, 
	deleteCustomerButton, createCottageButton, deleteCottageButton, createRenovationButton,
	deleteRenovationButton, closeFrameButton;
	private JLabel lblYear, lblWeek,toptext,madeby, comboWeekLabel, comboYearLabel;
	private JComboBox<String> jcbYear, jcbWeek;


	public Main()
	{
		// Here our resort is initialised!
		this.resort = new Resort();

		setTitle("Sunshine System");
		setSize(1280, 800);



		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		setLocation(new Point(10,10));

		this.addWindowListener(new SaveWhenClose(this, resort));

		// Initialise component.
		this.tableCreator = new TableCreator(resort);
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(null);
		this.tabbedPane = new JTabbedPane();

		// Create JLabels with time
		this.toptext = new JLabel("Sunshine Project");
		this.toptext.setBounds(1, 1, 400, 30);
		this.toptext.setForeground(Color.YELLOW);
		this.toptext.setFont(new Font("Nightclub BTN", Font.PLAIN, 25));

		this.madeby = new JLabel("Made by Timmy, Farhiya, Hisayo, Kenneth, Peter og Matias");
		this.madeby.setBounds(1, 25, 400, 30);
		this.madeby.setForeground(Color.WHITE);
		this.madeby.setFont(new Font("Nightclub BTN", Font.PLAIN, 12));


		this.lblWeek = new JLabel("Current Week: " + resort.getWeekNumber());
		this.lblWeek.setFont(new Font("Nightclub BTN", Font.PLAIN, 13));
		this.lblWeek.setBounds(1114, 382, 150, 23);
		this.lblWeek.setForeground(Color.WHITE);

		this.lblYear = new JLabel("Current Year: " + resort.getYear());
		this.lblYear.setFont(new Font("Nightclub BTN", Font.PLAIN, 13));
		this.lblYear.setBounds(1114, 416, 150, 23);
		this.lblYear.setForeground(Color.WHITE);


		// Cottage table
		this.cottageTable = new JTable(tableCreator.getCottageModel());
		this.scrollPaneCottage = new JScrollPane(this.cottageTable);
		this.cottageTable.setBackground(Color.WHITE);

		// Customer table
		this.customerTable = new JTable(tableCreator.getCustomerModel());
		this.scrollPaneCustomer = new JScrollPane(this.customerTable);
		this.customerTable.setBackground(Color.WHITE);
		// Reservation table
		this.reservationTable = new JTable(tableCreator.getReservationModel());
		this.scrollPaneReservation = new JScrollPane(this.reservationTable);
		this.reservationTable.setBackground(Color.WHITE);



		// Create buttons in mainFrame.
		createButton();

		// Create week and year JComboBox
		this.comboWeekLabel = new JLabel("Choose Week: ");
		this.comboWeekLabel.setBounds(840, 16, 90, 23);
		this.comboWeekLabel.setForeground(Color.WHITE);
		this.comboWeekLabel.setVisible(false);
		this.jcbWeek = new JComboBox<String>(this.resort.getWeeksAll());
		this.jcbWeek.setBounds(950, 16, 150, 23);
		this.jcbWeek.setVisible(false);
		this.jcbWeek.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String selectedItemWeek = (String) jcbWeek.getSelectedItem();
				String selectedItemYear = (String) jcbYear.getSelectedItem();
				updateCottageSpecificTable(Integer.parseInt(selectedItemWeek), Integer.parseInt(selectedItemYear));
			}
		});

		this.comboYearLabel = new JLabel("Choose Year: ");
		this.comboYearLabel.setBounds(840, 38, 90, 23);
		this.comboYearLabel.setForeground(Color.WHITE);
		this.comboYearLabel.setVisible(false);
		this.jcbYear = new JComboBox<String>(this.resort.getYear20Forward());
		this.jcbYear.setBounds(950, 38, 150, 23);
		this.jcbYear.setVisible(false);
		this.jcbYear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String selectedItemWeek = (String) jcbWeek.getSelectedItem();
				String selectedItemYear = (String) jcbYear.getSelectedItem();
				updateCottageSpecificTable(Integer.parseInt(selectedItemWeek), Integer.parseInt(selectedItemYear));

			}
		});


		// Create TabbedPane
		createTabbedPane();


		//		this.lblWeek.setOpaque(true);
		//		this.lblYear.setOpaque(true);
		//		this.lblYear.setBackground(Color.WHITE);
		//	this.lblWeek.setBackground(Color.WHITE);

		//Adding components
		this.mainPanel.setBackground(Color.DARK_GRAY);
		this.mainPanel.add(this.tabbedPane);
		this.mainPanel.add(this.lblWeek);		
		this.mainPanel.add(this.lblYear);
		this.mainPanel.add(this.toptext);
		this.mainPanel.add(this.madeby);
		this.mainPanel.add(comboWeekLabel);
		this.mainPanel.add(this.jcbWeek);
		this.mainPanel.add(comboYearLabel);
		this.mainPanel.add(this.jcbYear);

		// Adding to contentpne
		getContentPane().add(this.mainPanel);


		//		pack();
		setResizable(false);
		setVisible(true);
	}

	public void createTabbedPane()
	{

		// Add functionality
		this.tabbedPane.addTab("Reservation", this.scrollPaneReservation);
		this.tabbedPane.addTab("Customer", this.scrollPaneCustomer);
		this.tabbedPane.addTab("Cottages", this.scrollPaneCottage);

		this.tabbedPane.setBackground(Color.WHITE);
		this.tabbedPane.setBounds(10, 61, 1094, 700);
		this.tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(0 == tabbedPane.getSelectedIndex()) //ReservationTable
				{
					jcbWeek.setVisible(false);
					jcbYear.setVisible(false);
					comboWeekLabel.setVisible(false);
					comboYearLabel.setVisible(false);
					deleteReservationButton.setEnabled(true);
					createRenovationButton.setEnabled(false);
					deleteCottageButton.setEnabled(false);
					deleteCustomerButton.setEnabled(false);
					deleteRenovationButton.setEnabled(false);
				}else if(1 == tabbedPane.getSelectedIndex()) //CustomerTable
				{
					jcbWeek.setVisible(false);
					jcbYear.setVisible(false);
					comboWeekLabel.setVisible(false);
					comboYearLabel.setVisible(false);
					deleteCustomerButton.setEnabled(true);
					createRenovationButton.setEnabled(false);
					deleteCottageButton.setEnabled(false);
					deleteRenovationButton.setEnabled(false);
					deleteReservationButton.setEnabled(false);
				}else if(2 == tabbedPane.getSelectedIndex()) //CottageTable
				{
					jcbWeek.setVisible(true);
					jcbYear.setVisible(true);
					comboWeekLabel.setVisible(true);
					comboYearLabel.setVisible(true);
					createRenovationButton.setEnabled(true);
					deleteCottageButton.setEnabled(true);
					deleteRenovationButton.setEnabled(true);
					deleteCustomerButton.setEnabled(false);
					deleteReservationButton.setEnabled(false);
					updateCottageTable();
				}

			}

		});
	}

	public void createButton()
	{
		this.createReservationButton = new JButton("Create Reservation");
		this.createReservationButton.setBounds(1114, 82, 150, 23);
		this.createReservationButton.addActionListener(this);
		this.createReservationButton.setBackground(Color.WHITE);
		this.mainPanel.add(createReservationButton);

		this.createCustomerButton = new JButton("Create Customer");
		this.createCustomerButton.setBounds(1114, 116, 150, 23);
		this.createCustomerButton.addActionListener(this);
		this.createCustomerButton.setBackground(Color.WHITE);
		this.mainPanel.add(createCustomerButton);

		this.createCottageButton = new JButton("Create Cottage");
		this.createCottageButton.setBounds(1114, 150, 150, 23);
		this.createCottageButton.addActionListener(this);
		this.createCottageButton.setBackground(Color.WHITE);
		this.mainPanel.add(createCottageButton);

		this.createRenovationButton = new JButton("Create Renovation");
		this.createRenovationButton.setBounds(1114, 184, 150, 23);
		this.createRenovationButton.addActionListener(this);
		this.createRenovationButton.setBackground(Color.WHITE);
		this.createRenovationButton.setEnabled(false);
		this.mainPanel.add(createRenovationButton);

		this.deleteReservationButton = new JButton("Delete Reservation");
		this.deleteReservationButton.setBounds(1114, 489, 150, 23);
		this.deleteReservationButton.setEnabled(true);
		this.deleteReservationButton.addActionListener(this);
		this.deleteReservationButton.setBackground(Color.WHITE);
		this.mainPanel.add(deleteReservationButton);

		this.deleteCustomerButton = new JButton("Delete Customer");
		this.deleteCustomerButton.setBounds(1114, 523, 150, 23);
		this.deleteCustomerButton.setEnabled(false);
		this.deleteCustomerButton.addActionListener(this);
		this.deleteCustomerButton.setBackground(Color.WHITE);
		this.mainPanel.add(deleteCustomerButton);

		this.deleteCottageButton = new JButton("Delete Cottage");
		this.deleteCottageButton.setBounds(1114, 557, 150, 23);
		this.deleteCottageButton.addActionListener(this);
		this.deleteCottageButton.setBackground(Color.WHITE);
		this.deleteCottageButton.setEnabled(false);
		this.mainPanel.add(deleteCottageButton);


		this.deleteRenovationButton = new JButton("Delete Renovation");
		this.deleteRenovationButton.setBounds(1114, 591, 150, 23);
		this.deleteRenovationButton.addActionListener(this);
		this.deleteRenovationButton.setBackground(Color.WHITE);
		this.deleteRenovationButton.setEnabled(false);
		this.mainPanel.add(deleteRenovationButton);

		this.closeFrameButton = new JButton("Close");
		this.closeFrameButton.setBounds(1114, 738, 150, 23);
		this.closeFrameButton.setBackground(Color.WHITE);
		this.closeFrameButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to save?"); 
				if (choice == JOptionPane.YES_OPTION)
				{
					resort.quit();
					dispose();
				}else if(choice == JOptionPane.NO_OPTION)
				{
					dispose();
				}
			}
		});
		this.mainPanel.add(closeFrameButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(createRenovationButton))
		{
			try{
				int row = this.cottageTable.getSelectedRow();
				String cottageName = (String) this.cottageTable.getValueAt(row, 0);

				int choice = JOptionPane.showConfirmDialog(null, "Are you sure?");
				if(choice == JOptionPane.YES_OPTION)
				{
					this.resort.createRenovation(cottageName);
					updateCottageTable();
				}
			}catch(ArrayIndexOutOfBoundsException excep){
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to create a renovation!");
			}
		}
		if(e.getSource().equals(this.createReservationButton))
			try {
				new CreateReservation(resort, this);
			} catch (IOException e1) {
				System.out.println("fejl");
			}
		if(e.getSource().equals(this.createCottageButton))
			new CreateCottage(resort, this);
		if(e.getSource().equals(this.createCustomerButton))
			new CreateCustomer(resort, this, false);
		if(e.getSource().equals(this.deleteCottageButton))
		{
			try{
				int row = this.cottageTable.getSelectedRow();
				String cottageName = (String) this.cottageTable.getValueAt(row, 0);
				if(resort.findCottageName(cottageName).isReserved())
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure?");
					if(choice == JOptionPane.YES_OPTION)
					{
						this.resort.deleteCottage(cottageName);
						updateCottageTable();
					}
				}else
					JOptionPane.showMessageDialog(null, "Cottage is already reserved and can't be deleted!");
			}catch(ArrayIndexOutOfBoundsException excep)
			{
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to delete a cottage!");
			}

		}
		if(e.getSource().equals(this.deleteCustomerButton))
		{
			try{
				int row = this.customerTable.getSelectedRow();
				String cvr_cpr_nr = (String) this.customerTable.getValueAt(row, 0);
				if(resort.doesCustomerHaveReservation(cvr_cpr_nr))
					JOptionPane.showMessageDialog(null, "You cannot delete this customer, because the customer have reservations!");
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure?"); 
					if(choice == JOptionPane.YES_OPTION)
					{
						resort.deleteCustomer(cvr_cpr_nr);
						updateCustomerTable();
					}

				}
			}catch(ArrayIndexOutOfBoundsException excep)
			{
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to delete a customer!");
			}

		}

		if(e.getSource().equals(this.deleteRenovationButton))
		{
			try{
				int row = this.cottageTable.getSelectedRow();		
				String cottageName = (String) this.cottageTable.getValueAt(row, 0);
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure?"); 
				if(choice == JOptionPane.YES_OPTION)
				{
					this.resort.deleteRenovation(cottageName);
					updateCottageTable();
				}	
			}catch(ArrayIndexOutOfBoundsException excep)
			{
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to delete a renovation!");
			}
		}
		if(e.getSource().equals(this.deleteReservationButton))
		{
			try{
				int row = this.reservationTable.getSelectedRow();		
				String ID = (String) this.reservationTable.getValueAt(row, 0);
				
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this reservation: \n" + ID);
				
				if(choice == JOptionPane.YES_OPTION)
				{
					Reservation r = this.resort.findReservation(ID);
					r.getCottage().assignVancancy(r.getWeeks(), r.getYear());
					
					this.resort.deleteReservation(ID);
					
					updateReservationTable();
				}else
					return;
				

			}catch(ArrayIndexOutOfBoundsException excep)
			{
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to delete a reservation");
			}
		}
	}



	public void updateCottageTable()
	{
		this.tableCreator.updateCottageModel(cottageTable);
	}

	public void updateCustomerTable()
	{
		this.tableCreator.updateCustomerModel(customerTable);
	}

	public void updateReservationTable()
	{
		this.tableCreator.updateReservationModel(reservationTable);
	}

	public void updateCottageSpecificTable(int week, int year)
	{
		this.tableCreator.updateCottageModelSpecific(this.cottageTable, week, year);
	}
}
