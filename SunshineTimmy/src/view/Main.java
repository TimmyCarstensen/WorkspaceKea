package view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import model.Resort;
import javax.swing.JLabel;
import java.awt.Font;

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
	private JLabel lblYear, lblWeek;

	public Main()
	{
		// Here our resort is initialised!
		this.resort = new Resort();

		setTitle("Sunshine System");
		setSize(1280, 800);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		setLocation(new Point(10,10));

		// Initialise component.
		this.tableCreator = new TableCreator(resort);
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(null);
		this.tabbedPane = new JTabbedPane();

		// Cottage table
		this.cottageTable = new JTable(tableCreator.getCottageModel());
		this.scrollPaneCottage = new JScrollPane(this.cottageTable);

		// Customer table
		this.customerTable = new JTable(tableCreator.getCustomerModel());
		this.scrollPaneCustomer = new JScrollPane(this.customerTable);

		// Reservation table
		this.reservationTable = new JTable(tableCreator.getReservationModel());
		this.scrollPaneReservation = new JScrollPane(this.reservationTable);

		createTabbedPane();

		// Create buttons in mainFrame.
		createButton();

		// Create JLabels with time
		this.lblWeek = new JLabel("Week: " + resort.getWeekNumber());
		this.lblWeek.setFont(new Font("Nightclub BTN", Font.PLAIN, 15));
		this.lblWeek.setBounds(1114, 312, 150, 23);
		this.lblYear = new JLabel("Year: " + resort.getYear());
		this.lblYear.setFont(new Font("Nightclub BTN", Font.PLAIN, 15));
		this.lblYear.setBounds(1114, 346, 150, 23);

		//Adding components
		mainPanel.add(tabbedPane);
		mainPanel.add(lblWeek);		
		mainPanel.add(lblYear);

		getContentPane().add(this.mainPanel);	

		//		pack();
		setResizable(false);
		setVisible(true);
	}

	public void createTabbedPane()
	{

		// Add functionality
		this.tabbedPane.addTab("Cottages", scrollPaneCottage);
		this.tabbedPane.addTab("Customer", scrollPaneCustomer);
		this.tabbedPane.addTab("Reservation", scrollPaneReservation);
		this.tabbedPane.setBounds(10, 61, 1094, 700);
		this.tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(0 == tabbedPane.getSelectedIndex())
				{
					createRenovationButton.setEnabled(true);
					deleteCottageButton.setEnabled(true);
					deleteCustomerButton.setEnabled(false);
					deleteRenovationButton.setEnabled(true);
					deleteReservationButton.setEnabled(false);
				}else if(1 == tabbedPane.getSelectedIndex())
				{
					createRenovationButton.setEnabled(false);
					deleteCottageButton.setEnabled(false);
					deleteCustomerButton.setEnabled(true);
					deleteRenovationButton.setEnabled(false);
					deleteReservationButton.setEnabled(false);
				}else if(2 == tabbedPane.getSelectedIndex())
				{
					createRenovationButton.setEnabled(false);
					deleteCottageButton.setEnabled(false);
					deleteCustomerButton.setEnabled(false);
					deleteRenovationButton.setEnabled(false);
					deleteReservationButton.setEnabled(true);
				}


			}

		});
	}

	public void createButton()
	{
		this.createReservationButton = new JButton("Create Reservation");
		this.createReservationButton.setBounds(1114, 80, 150, 23);
		this.createReservationButton.addActionListener(this);
		this.mainPanel.add(createReservationButton);

		this.createCustomerButton = new JButton("Create Customer");
		this.createCustomerButton.setBounds(1114, 114, 150, 23);
		this.createCustomerButton.addActionListener(this);
		this.mainPanel.add(createCustomerButton);

		this.createCottageButton = new JButton("Create Cottage");
		this.createCottageButton.setBounds(1114, 148, 150, 23);
		this.createCottageButton.addActionListener(this);
		this.mainPanel.add(createCottageButton);


		this.createRenovationButton = new JButton("Create Renovation");
		this.createRenovationButton.setBounds(1114, 182, 150, 23);
		this.createRenovationButton.addActionListener(this);
		this.mainPanel.add(createRenovationButton);

		JButton printArray = new JButton("Print CottageArray");
		printArray.setBounds(1114, 252, 150, 23);
		printArray.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				resort.printCottageArray();
			}
		});
		this.mainPanel.add(printArray);

		this.deleteReservationButton = new JButton("Delete Reservation");
		this.deleteReservationButton.setBounds(1114, 489, 150, 23);
		this.deleteReservationButton.setEnabled(false);
		this.deleteReservationButton.addActionListener(this);
		this.mainPanel.add(deleteReservationButton);

		this.deleteCustomerButton = new JButton("Delete Customer");
		this.deleteCustomerButton.setBounds(1114, 523, 150, 23);
		this.deleteCustomerButton.setEnabled(false);
		this.deleteCustomerButton.addActionListener(this);
		this.mainPanel.add(deleteCustomerButton);

		this.deleteCottageButton = new JButton("Delete Cottage");
		this.deleteCottageButton.setBounds(1114, 557, 150, 23);
		this.deleteCottageButton.addActionListener(this);
		this.mainPanel.add(deleteCottageButton);

		this.deleteRenovationButton = new JButton("Delete Renovation");
		this.deleteRenovationButton.setBounds(1114, 591, 150, 23);
		this.deleteRenovationButton.addActionListener(this);
		this.mainPanel.add(deleteRenovationButton);

		this.closeFrameButton = new JButton("Close");
		this.closeFrameButton.setBounds(1114, 738, 150, 23);
		this.closeFrameButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (JOptionPane.showConfirmDialog(null, "Do you want to save?") == JOptionPane.YES_OPTION)
				{
					resort.quit();
					dispose();
				}
				else			
					dispose();
			}
		});
		this.mainPanel.add(closeFrameButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(createRenovationButton))
		{
			int row = this.cottageTable.getSelectedRow();
			String cottageName = (String) this.cottageTable.getValueAt(row, 0);
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if(choice == JOptionPane.YES_OPTION)
			{
				this.resort.createRenovation(cottageName);
				updateCottageTable();
			}
		}
		if(e.getSource().equals(this.createReservationButton))
			new CreateReservation(resort, this);
		if(e.getSource().equals(this.createCottageButton))
			new CreateCottage(resort, this);
		if(e.getSource().equals(this.createCustomerButton))
			new CreateCustomer(resort, this);
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
					JOptionPane.showMessageDialog(null, "YOU GOT HACKED!! NOT POSSIBLE COMMAND IDIOT!!! COTTAGE IS RESERVED!");
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
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to delete Renovation!");
			}
		}
		//		if(e.getSource().equals(this.deleteReservationButton))
		//		{
		//			try{
		//				int row = this.reservationTable.getSelectedRow();		
		//				String cvr_cpr_nr = (String) this.reservationTable.getValueAt(row, 0);
		//				if(this.resort.fin)
		//					this.resort.deleteReservation(cvr_cpr_nr
		//				
		//			}catch(ArrayIndexOutOfBoundsException excep)
		//			{
		//				
		//			}
		//		}
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
}
