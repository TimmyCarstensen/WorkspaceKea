package model;


import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;

public class JTableTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTableTest()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//data
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("1ABC", "D", "1"));
		books.add(new Book("2ABC", "F", "2"));
		books.add(new Book("3ABC", "G", "3"));
		
		JTable table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(new String[] { "title", "author", "publisher" });
	    model.setRowCount(books.size());
	    int row = 0;
	    for (Book book : books) {
	    	model.setValueAt(book.title, row, 0);
	    	model.setValueAt(book.author, row, 1);
	        model.setValueAt(book.publisher, row, 2);
	        row++;
	    }
	    table.setModel(model);

		JScrollPane scrollpane = new JScrollPane(table);
		
		add(scrollpane);
		pack();
		setVisible(true);
		
	
	}
	
	public static void main(String args[])
	{
		new JTableTest();
	}
}