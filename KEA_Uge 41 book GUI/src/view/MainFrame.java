package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import Controller.Book;
import Controller.Books;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class MainFrame extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollpane;
	private Books books = new Books();
	private JTable table;

	/**
	 * 
	 */
	public MainFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500,500));
		setLayout(new BorderLayout());
		setLocation(new Point(300, 300));
		setTitle("Books");

		// Adding components

		JPanel east = new JPanel(new GridLayout(12,1));
//		JPanel extra = new JPanel(new BorderLayout());
		JPanel w1 = new JPanel(new FlowLayout());
		JPanel w2 = new JPanel(new FlowLayout());
		JPanel w3 = new JPanel(new FlowLayout());
		JTextField textField = new JTextField();
		
		JButton newBook = new JButton("New");
		JButton editBook = new JButton("Edit");
		JButton deleteBook = new JButton("Delete");
		JTabbedPane tabbedPane = new JTabbedPane();
		
		
		
		this.table = new JTable();
		table.setModel(getBookModel());
		this.scrollpane = new JScrollPane(table);
		tabbedPane.addTab("tabel 1", this.scrollpane);
		tabbedPane.addTab("tabel 2", textField);
		
		
		//Define components
		newBook.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				books.addBook(new Book("Test1", "test 2", "test 3"));
				updateBookmodel();
//				table.setModel(updateTable());
			}
		});
		
		deleteBook.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		
		//Wrapper for east
		w1.add(newBook);
		w2.add(editBook);
		w3.add(deleteBook);

		//Component added
		east.add(w1);
		east.add(w2);	
		east.add(w3);
		
		
		
		//This is how to get to your table!!!!
//		JViewport viewport = scrollpane.getViewport();
//		JTable table = (JTable)viewport.getView();
//		System.out.println(table.set);
		
		//Adding to frame
		add(tabbedPane, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);

		pack();
		setResizable(false);
		setVisible(true);
	}

	/**
	 * 
	 * @return
	 */
	public DefaultTableModel getBookModel()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Cottage Name", "Cottage Type", "Price", "Beds" });
		model.setRowCount(books.getBooks().size());
		int row = 0;
		for (Book book : books.getBooks()) {
			model.setValueAt(book.getTitle(), row, 0);
			model.setValueAt(book.getAuthor(), row, 1);
			model.setValueAt(book.getPublisher(), row, 2);
			
			row++;
		}
		
		return model;			
	}
	
	public DefaultTableModel getNewsPaper()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Titel", "SideTal", "Udgiver", "Dato" });
		model.setRowCount(books.getBooks().size());
		int row = 0;
		for (Book book : books.getBooks()) {
			model.setValueAt(book.getTitle(), row, 0);
			model.setValueAt(book.getAuthor(), row, 1);
			model.setValueAt(book.getPublisher(), row, 2);
			
			row++;
		}
		
		return model;			
	}	
	
	public void updateBookmodel()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Cottage Name", "Cottage Type", "Price", "Beds" });
		model.setRowCount(books.getBooks().size());
		int row = 0;
		for (Book book : books.getBooks()) {
			model.setValueAt(book.getTitle(), row, 0);
			model.setValueAt(book.getAuthor(), row, 1);
			model.setValueAt(book.getPublisher(), row, 2);
			
			row++;
		}
		this.table.setModel(model);
	}

	public JScrollPane getTable(){return this.scrollpane;}
}
