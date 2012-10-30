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
import javax.swing.JTable;
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

		JButton newBook = new JButton("New");
		JButton editBook = new JButton("Edit");
		JButton deleteBook = new JButton("Delete");

		//Define components
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
		addTable();

		
		//This is how to get to your table!!!!
//		JViewport viewport = scrollpane.getViewport();
//		JTable table = (JTable)viewport.getView();
//		System.out.println(table.set);
		
		//Adding to frame
		add(this.scrollpane, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);

		pack();
		setResizable(false);
		setVisible(true);
	}

	/**
	 * 
	 * @return
	 */
	public void addTable()
	{

		JTable table = new JTable();

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Title", "Author", "Publisher" });
		model.setRowCount(books.getBooks().size());
		int row = 0;
		for (Book book : books.getBooks()) {
			model.setValueAt(book.getTitle(), row, 0);
			model.setValueAt(book.getAuthor(), row, 1);
			model.setValueAt(book.getPublisher(), row, 2);
			row++;
		}
		table.setModel(model);

		this.scrollpane = new JScrollPane(table);	
	}

	public JScrollPane getTable(){return this.scrollpane;}
}
