package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTableDemo()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		AbstractTableModel dataModel = new AbstractTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public int getColumnCount() { return 10; }
			public int getRowCount() { return 10;}
			public Object getValueAt(int row, int col) { return new Integer(row*col); }
		};
		JTable table = new JTable(dataModel);
		JScrollPane scrollpane = new JScrollPane(table);
		
		add(scrollpane);
		pack();
		setVisible(true);


	}

	public static void main(String args[])
	{
		new JTableDemo();
	}
}
