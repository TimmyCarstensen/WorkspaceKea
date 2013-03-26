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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import Controller.Book;
import Controller.Material;
import Controller.NewsPaper;

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
	private Material material = new Material();
	private Tables table;
	private JTabbedPane tabbedPane;
	private JTable bookTable;
	private JTable newsPaperTable;

	/**
	 * 
	 */
	public MainFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500,500));
		setLayout(new BorderLayout());
		setLocation(new Point(300, 300));
		setTitle("Example use of JTable and JTabbedPane");

		this.table = new Tables(material);
		// Adding components

		GridLayout gL = new GridLayout();
		gL.setRows(12);
		gL.setColumns(1);
		gL.setVgap(15);
		
		JPanel east = new JPanel(gL);

		
		
		JButton newBook = new JButton("New");
		JButton editBook = new JButton("Edit");
		JButton deleteBook = new JButton("Delete");
		
		// Her oprettes tabeller og tabbedPane
		this.tabbedPane = new JTabbedPane();
		this.bookTable = new JTable(table.getBookModel());
		JScrollPane scrollpaneBook = new JScrollPane(bookTable);
		this.newsPaperTable = new JTable(table.getNewsPaper());
		JScrollPane scrollpaneNewsPaper = new JScrollPane(newsPaperTable);

		
		this.tabbedPane.addTab("tabel 1", scrollpaneBook);
		this.tabbedPane.addTab("tabel 2", scrollpaneNewsPaper);
		
		
		this.tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("tab" + tabbedPane.getSelectedIndex());
				
			}
			
		});
		
		//
		newBook.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(tabbedPane.getSelectedIndex() == 0){
					material.addBook(new Book("Test1", "test 2", "test 3"));
					table.updateBookModel(bookTable);
				}
				
				else if(tabbedPane.getSelectedIndex() == 1){
					material.addAvis(new NewsPaper("test1", "test2", "test3", "test4"));
					table.updateNewsPaperModel(newsPaperTable);
				}
					
//				
			}
		});
		
		deleteBook.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		

		//Component added
		east.add(newBook);
		east.add(editBook);	
		east.add(deleteBook);
		
		
		
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

	

	public JScrollPane getTable(){return this.scrollpane;}
}
