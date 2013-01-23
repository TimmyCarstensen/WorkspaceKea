package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Timmy, Matias, Kenneth
 *
 */
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
	deleteRenovationButton, closeFrameButton, resetCottageTableButton, payReservationButton;
	private JLabel lblYear, lblWeek,toptext,madeby, comboWeekLabel, comboYearLabel;
	private JComboBox<String> jcbYear, jcbWeek;


	public Main() throws IOException
	{

		// Here our resort is initialised!
		this.resort = new Resort();

		setTitle("Sunshine System");
		setSize(1280, 800);

		JMenuBar mb;
		JMenu file;
		JMenuItem itemmoney;
		Container c = getContentPane();

		c.setLayout(new BorderLayout());
		mb = new JMenuBar();
		c.add("North",mb);
		file = new JMenu("Billing");

		mb.add(file);

		itemmoney = new JMenuItem("Resort Account");

		file.add(itemmoney);

		itemmoney.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Account Balance \n" + resort.getResortAmount());
			}
		});




		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		setLocation(new Point(10,10));

		this.addWindowListener(new SaveWhenClose(this, resort));

		// Initialise component.
		this.tableCreator = new TableCreator(resort);
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(null);
		this.tabbedPane = new JTabbedPane();


		// Create time and made by + title
		createTimeLabels();

		// Create tables in mainFrame.
		createTables();

		// Create buttons in mainFrame.
		createButton();

		// Create week and year JComboBox with JLabels
		createJComboBoxWeekAndYear();

		// Create TabbedPane
		createTabbedPane();

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
		this.mainPanel.add(this.resetCottageTableButton);

		// Adding to contentpne
		getContentPane().add(this.mainPanel);


		// pack();
		setResizable(false);
		setVisible(true);
	}

	public void createTimeLabels()
	{
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
	}


	/**
	 * Tabeller initialisere og oprettes
	 */
	public void createTables()
	{
		// Cottage table
		this.cottageTable = new JTable()
		{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex, int colIndex)
			{
				return false;
			}
		};
		tableCreator.setCottageModel(this.cottageTable);
		this.scrollPaneCottage = new JScrollPane(this.cottageTable);
		this.cottageTable.setBackground(Color.WHITE);

		// Customer table
		this.customerTable = new JTable()
		{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex, int colIndex)
			{
				return false;
			}
		};
		this.tableCreator.setCustomerModel(this.customerTable);
		this.scrollPaneCustomer = new JScrollPane(this.customerTable);
		this.customerTable.setBackground(Color.WHITE);

		// Reservation table
		this.reservationTable = new JTable()
		{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex, int colIndex)
			{
				return false;
			}
		};
		this.tableCreator.setReservationModel(this.reservationTable);
		this.scrollPaneReservation = new JScrollPane(this.reservationTable);
		this.reservationTable.setBackground(Color.WHITE);
	}



	/**
	 * Knapper initialisere og oprettes.
	 * @throws IOException
	 */
	public void createButton() throws IOException
	{

		BufferedImage iconReservation1 = ImageIO.read(new File("knapper/createreservation1.png"));
		BufferedImage iconReservation2 = ImageIO.read(new File("knapper/createreservation2.png"));
		BufferedImage iconReservation3 = ImageIO.read(new File("knapper/createreservation3.png"));
		this.createReservationButton = new JButton(new ImageIcon(iconReservation1));
		this.createReservationButton.setPressedIcon(new ImageIcon(iconReservation2));
		this.createReservationButton.setRolloverIcon(new ImageIcon(iconReservation3));
		this.createReservationButton.setBorder(BorderFactory.createEmptyBorder());
		this.createReservationButton.setContentAreaFilled(false);
		this.createReservationButton.setBounds(1114, 82, 150, 23);
		this.createReservationButton.addActionListener(this);
		this.mainPanel.add(createReservationButton);

		BufferedImage iconCustomer1 = ImageIO.read(new File("knapper/createcustomer1.png"));
		BufferedImage iconCustomer2 = ImageIO.read(new File("knapper/createcustomer2.png"));
		BufferedImage iconCustomer3 = ImageIO.read(new File("knapper/createcustomer3.png"));
		this.createCustomerButton = new JButton(new ImageIcon(iconCustomer1));
		this.createCustomerButton.setPressedIcon(new ImageIcon(iconCustomer2));
		this.createCustomerButton.setRolloverIcon(new ImageIcon(iconCustomer3));
		this.createCustomerButton.setBorder(BorderFactory.createEmptyBorder());
		this.createCustomerButton.setContentAreaFilled(false);
		this.createCustomerButton.setBounds(1114, 116, 150, 23);
		this.createCustomerButton.addActionListener(this);
		this.mainPanel.add(createCustomerButton);

		BufferedImage iconCottage1 = ImageIO.read(new File("knapper/createcottage1.png"));
		BufferedImage iconCottage2 = ImageIO.read(new File("knapper/createcottage2.png"));
		BufferedImage iconCottage3 = ImageIO.read(new File("knapper/createcottage3.png"));
		this.createCottageButton = new JButton(new ImageIcon(iconCottage1));
		this.createCottageButton.setPressedIcon(new ImageIcon(iconCottage2));
		this.createCottageButton.setRolloverIcon(new ImageIcon(iconCottage3));
		this.createCottageButton.setBorder(BorderFactory.createEmptyBorder());
		this.createCottageButton.setContentAreaFilled(false);
		this.createCottageButton.setBounds(1114, 150, 150, 23);
		this.createCottageButton.addActionListener(this);
		this.mainPanel.add(createCottageButton);

		BufferedImage iconRenovation1 = ImageIO.read(new File("knapper/createrenovation1.png"));
		BufferedImage iconRenovation2 = ImageIO.read(new File("knapper/createrenovation2.png"));
		BufferedImage iconRenovation3 = ImageIO.read(new File("knapper/createrenovation3.png"));
		BufferedImage iconRenovation4 = ImageIO.read(new File("knapper/createrenovation4.png"));
		this.createRenovationButton = new JButton(new ImageIcon(iconRenovation1));
		this.createRenovationButton.setPressedIcon(new ImageIcon(iconRenovation2));
		this.createRenovationButton.setRolloverIcon(new ImageIcon(iconRenovation3));
		this.createRenovationButton.setDisabledIcon(new ImageIcon(iconRenovation4));
		this.createRenovationButton.setBorder(BorderFactory.createEmptyBorder());
		this.createRenovationButton.setContentAreaFilled(false);
		this.createRenovationButton.setBounds(1114, 184, 150, 23);
		this.createRenovationButton.addActionListener(this);
		this.createRenovationButton.setEnabled(false);
		this.mainPanel.add(createRenovationButton);

		BufferedImage iconPay1 = ImageIO.read(new File("knapper/payreservation1.png"));
		BufferedImage iconPay2 = ImageIO.read(new File("knapper/payreservation2.png"));
		BufferedImage iconPay3 = ImageIO.read(new File("knapper/payreservation3.png"));
		this.payReservationButton = new JButton(new ImageIcon(iconPay1));
		this.payReservationButton.setPressedIcon(new ImageIcon(iconPay2));
		this.payReservationButton.setRolloverIcon(new ImageIcon(iconPay3));
		this.payReservationButton.setBorder(BorderFactory.createEmptyBorder());
		this.payReservationButton.setContentAreaFilled(false);
		this.payReservationButton.setBounds(1114, 268, 150, 23);
		this.payReservationButton.addActionListener(this);
		this.payReservationButton.setEnabled(true);
		this.mainPanel.add(this.payReservationButton);

		BufferedImage iconDelReservation1 = ImageIO.read(new File("knapper/deletereservation1.png"));
		BufferedImage iconDelReservation2 = ImageIO.read(new File("knapper/deletereservation2.png"));
		BufferedImage iconDelReservation3 = ImageIO.read(new File("knapper/deletereservation3.png"));
		BufferedImage iconDelReservation4 = ImageIO.read(new File("knapper/deletereservation4.png"));
		this.deleteReservationButton = new JButton(new ImageIcon(iconDelReservation1));
		this.deleteReservationButton.setPressedIcon(new ImageIcon(iconDelReservation2));
		this.deleteReservationButton.setRolloverIcon(new ImageIcon(iconDelReservation3));
		this.deleteReservationButton.setDisabledIcon(new ImageIcon(iconDelReservation4));
		this.deleteReservationButton.setBorder(BorderFactory.createEmptyBorder());
		this.deleteReservationButton.setContentAreaFilled(false);
		this.deleteReservationButton.setBounds(1114, 489, 150, 23);
		this.deleteReservationButton.setEnabled(true);
		this.deleteReservationButton.addActionListener(this);
		this.mainPanel.add(deleteReservationButton);

		BufferedImage iconDelCustomer1 = ImageIO.read(new File("knapper/deletecustomer1.png"));
		BufferedImage iconDelCustomer2 = ImageIO.read(new File("knapper/deletecustomer2.png"));
		BufferedImage iconDelCustomer3 = ImageIO.read(new File("knapper/deletecustomer3.png"));
		BufferedImage iconDelCustomer4 = ImageIO.read(new File("knapper/deletecustomer4.png"));
		this.deleteCustomerButton = new JButton(new ImageIcon(iconDelCustomer1));
		this.deleteCustomerButton.setPressedIcon(new ImageIcon(iconDelCustomer2));
		this.deleteCustomerButton.setRolloverIcon(new ImageIcon(iconDelCustomer3));
		this.deleteCustomerButton.setDisabledIcon(new ImageIcon(iconDelCustomer4));
		this.deleteCustomerButton.setBorder(BorderFactory.createEmptyBorder());
		this.deleteCustomerButton.setContentAreaFilled(false);
		this.deleteCustomerButton.setBounds(1114, 523, 150, 23);
		this.deleteCustomerButton.setEnabled(false);
		this.deleteCustomerButton.addActionListener(this);
		this.deleteCustomerButton.setBackground(Color.WHITE);
		this.mainPanel.add(deleteCustomerButton);


		BufferedImage iconDelCottage1 = ImageIO.read(new File("knapper/deletecottage1.png"));
		BufferedImage iconDelCottage2 = ImageIO.read(new File("knapper/deletecottage2.png"));
		BufferedImage iconDelCottage3 = ImageIO.read(new File("knapper/deletecottage3.png"));
		BufferedImage iconDelCottage4 = ImageIO.read(new File("knapper/deletecottage4.png"));
		this.deleteCottageButton = new JButton(new ImageIcon(iconDelCottage1));
		this.deleteCottageButton.setPressedIcon(new ImageIcon(iconDelCottage2));
		this.deleteCottageButton.setRolloverIcon(new ImageIcon(iconDelCottage3));
		this.deleteCottageButton.setDisabledIcon(new ImageIcon(iconDelCottage4));
		this.deleteCottageButton.setBorder(BorderFactory.createEmptyBorder());
		this.deleteCottageButton.setContentAreaFilled(false);
		this.deleteCottageButton.setBounds(1114, 557, 150, 23);
		this.deleteCottageButton.addActionListener(this);
		this.deleteCottageButton.setBackground(Color.WHITE);
		this.deleteCottageButton.setEnabled(false);
		this.mainPanel.add(deleteCottageButton);

		BufferedImage iconDelRenovation1 = ImageIO.read(new File("knapper/deleterenovation1.png"));
		BufferedImage iconDelRenovation2 = ImageIO.read(new File("knapper/deleterenovation2.png"));
		BufferedImage iconDelRenovation3 = ImageIO.read(new File("knapper/deleterenovation3.png"));
		BufferedImage iconDelRenovation4 = ImageIO.read(new File("knapper/deleterenovation4.png"));
		this.deleteRenovationButton = new JButton(new ImageIcon(iconDelRenovation1));
		this.deleteRenovationButton.setPressedIcon(new ImageIcon(iconDelRenovation2));
		this.deleteRenovationButton.setRolloverIcon(new ImageIcon(iconDelRenovation3));
		this.deleteRenovationButton.setDisabledIcon(new ImageIcon(iconDelRenovation4));
		this.deleteRenovationButton.setBorder(BorderFactory.createEmptyBorder());
		this.deleteRenovationButton.setContentAreaFilled(false);
		this.deleteRenovationButton.setBounds(1114, 591, 150, 23);
		this.deleteRenovationButton.addActionListener(this);
		this.deleteRenovationButton.setBackground(Color.WHITE);
		this.deleteRenovationButton.setEnabled(false);
		this.mainPanel.add(deleteRenovationButton);

		BufferedImage iconClose1 = ImageIO.read(new File("knapper/close1.png"));
		BufferedImage iconClose2 = ImageIO.read(new File("knapper/close2.png"));
		BufferedImage iconClose3 = ImageIO.read(new File("knapper/close3.png"));
		this.closeFrameButton = new JButton(new ImageIcon(iconClose1));
		this.closeFrameButton.setPressedIcon(new ImageIcon(iconClose2));
		this.closeFrameButton.setRolloverIcon(new ImageIcon(iconClose3));
		this.closeFrameButton.setBorder(BorderFactory.createEmptyBorder());
		this.closeFrameButton.setContentAreaFilled(false);
		this.closeFrameButton.setBounds(1114, 718, 150, 23);
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

	/**
	 * Her oprettes combobox week og year
	 */
	public void createJComboBoxWeekAndYear()
	{
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
		this.resetCottageTableButton = new JButton("Reset Table");
		this.resetCottageTableButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				updateCottageTable();
			}
		});
		this.resetCottageTableButton.setBounds(1100, 30, 150, 23);
		this.resetCottageTableButton.setVisible(false);
	}

	/**
	 * 
	 */
	public void createTabbedPane()
	{

		// Add functionality
		this.tabbedPane.addTab("Reservation", this.scrollPaneReservation);
		this.tabbedPane.addTab("Customer", this.scrollPaneCustomer);
		this.tabbedPane.addTab("Cottages", this.scrollPaneCottage);

		this.tabbedPane.setBackground(Color.WHITE);
		this.tabbedPane.setBounds(10, 61, 1094, 680);
		this.tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(0 == tabbedPane.getSelectedIndex()) //ReservationTable
				{
					jcbWeek.setVisible(false);
					jcbYear.setVisible(false);
					comboWeekLabel.setVisible(false);
					comboYearLabel.setVisible(false);
					resetCottageTableButton.setVisible(false);
					deleteReservationButton.setEnabled(true);
					createRenovationButton.setEnabled(false);
					payReservationButton.setVisible(true);
					deleteCottageButton.setEnabled(false);
					deleteCustomerButton.setEnabled(false);
					deleteRenovationButton.setEnabled(false);
				}else if(1 == tabbedPane.getSelectedIndex()) //CustomerTable
				{
					jcbWeek.setVisible(false);
					jcbYear.setVisible(false);
					comboWeekLabel.setVisible(false);
					comboYearLabel.setVisible(false);
					resetCottageTableButton.setVisible(false);
					deleteCustomerButton.setEnabled(true);
					createRenovationButton.setEnabled(false);
					payReservationButton.setVisible(false);
					deleteCottageButton.setEnabled(false);
					deleteRenovationButton.setEnabled(false);
					deleteReservationButton.setEnabled(false);
				}else if(2 == tabbedPane.getSelectedIndex()) //CottageTable
				{
					jcbWeek.setVisible(true);
					jcbYear.setVisible(true);
					comboWeekLabel.setVisible(true);
					comboYearLabel.setVisible(true);
					resetCottageTableButton.setVisible(true);
					createRenovationButton.setEnabled(true);
					payReservationButton.setVisible(false);
					deleteCottageButton.setEnabled(true);
					deleteRenovationButton.setEnabled(true);
					deleteCustomerButton.setEnabled(false);
					deleteReservationButton.setEnabled(false);
					updateCottageTable();
				}

			}

		});
	}


	/**
	 * Her behandles alle aktioner fra knapper.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.createReservationButton))
		{
			try {
				new CreateReservation(resort, this);
			} catch (IOException e1) {
				System.out.println("fejl");
			}
		}
		if(e.getSource().equals(this.createCottageButton))
		{
			new CreateCottage(resort, this);
		}
		if(e.getSource().equals(this.createCustomerButton))
		{
			new CreateCustomer(resort, this, false);
		}
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
		if(e.getSource().equals(this.payReservationButton))
		{
			try{
				int row = this.reservationTable.getSelectedRow();		
				String ID = (String) this.reservationTable.getValueAt(row, 0);

				int choice = JOptionPane.showConfirmDialog(null, "Do you want to register this \nreservation with ID " + ID +" as paid?");
				if(choice == JOptionPane.YES_OPTION)
				{
					resort.payReservation(ID);
					updateReservationTable();
				}
				else
					return;
			}catch(ArrayIndexOutOfBoundsException excep)
			{
				JOptionPane.showMessageDialog(null, "You need to select a row in the table to registre payment!");
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


	}


	/**
	 * Bruges til at updaterer hyttetabel
	 */
	public void updateCottageTable()
	{
		this.tableCreator.setCottageModel(cottageTable);
	}

	/**
	 * Bruges til at opdatere kundetabel
	 */
	public void updateCustomerTable()
	{
		this.tableCreator.setCustomerModel(customerTable);
	}

	/**
	 * Bruges til at updaterer reservationstabel
	 */
	public void updateReservationTable()
	{
		this.tableCreator.setReservationModel(reservationTable);
	}

	/**
	 * Bruges til at opdaterer hyttetabel ud fra uge og år, så man se ledigheden af hytterne i valgte
	 * uge og år.
	 * @param week
	 * @param year
	 */
	public void updateCottageSpecificTable(int week, int year)
	{
		this.tableCreator.updateCottageModelSpecific(this.cottageTable, week, year);
	}
}
