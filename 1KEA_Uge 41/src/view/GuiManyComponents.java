package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GuiManyComponents implements ItemListener {
	public static void main(String[] args) {
		new GuiManyComponents();
	}
	
	JTextField txtField1;
	JTextArea tarMultipleLines;
	JLabel lblAngryGuy;
	JButton btn;
	JTable table;
	@SuppressWarnings("rawtypes")
	JComboBox combo;
	
	public GuiManyComponents()
	{
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(500,800);
		frame.setTitle("Text area test");
		
		txtField1 = new JTextField(5);
		tarMultipleLines = new JTextArea(5,20);
		btn = new JButton("Click me", new ImageIcon("images\\nocheck.png"));
		btn.setPreferredSize(new Dimension(150, 100));
		
		lblAngryGuy = new JLabel("If you point at me, bad things will happen!");
		
		lblAngryGuy.addMouseMotionListener(new MouseMotionListener() {
			//inner class
			@Override
			public void mouseMoved(MouseEvent arg0) {
				JOptionPane.showMessageDialog(lblAngryGuy, "Bad things");
				
			}
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		
		
		String[] course = {"A","B","C","D"};
		combo = new JComboBox<String>(course);
        combo.addItemListener( this );

	
		
		
		//JTable.
		//not dynamic
		@SuppressWarnings("unused")
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
			        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } }; //2-dimensional object array
		
		
		//See there could be a loop instead of 2 (or x number of) code blocks?
		Object rowD[][] = new Object[2][3]; //row, column (2, 3)
		rowD[0][0] = 1;
		rowD[0][1] = 2;
		rowD[0][2] = 3;
		
		rowD[1][0] = 4;
		rowD[1][1] = 5;
		rowD[1][2] = 6;
		
		
		//dynamic - could be used to load data from a database or file, with a small modification, into array to show data in jtable.
		//however we need to know how many rows the file has before we start loading data.
		final int numberOfColumns = 5;
		final int numberOfRows = 10;
		
		Object rows[][] = new Object[numberOfRows][];
		for (int i=0; i < numberOfRows; i++)
		{
			rows[i] = new Object[numberOfColumns];
			
			//notice the parenthesis here.
			rows[i][0] = "Row" + (i + 1) + " Column" + 1; //load data from file instead of this value.
			rows[i][1] = "Row" + (i + 1) + " Column" + 2;
			rows[i][2] = "Row" + (i + 1) + " Column" + 3;
			rows[i][3] = "Row" + (i + 1) + " Column" + 4;
		}
		
		//Number of columns controls how many columns the grid has, no matter how many columns of data there are. 
		Object columnNames[] = { "Column One", "Column Two", "Column Three","Column Four" }; //1-dimensional object array
		table = new JTable(rows, columnNames); //jtable object, add columnNames and data in constructor.
		JScrollPane scrollPane = new JScrollPane(table); //add scrollpane to table
	    
 
		frame.add(lblAngryGuy);
		frame.add(txtField1);
		frame.add(tarMultipleLines);
		frame.add(combo);
		frame.add(btn);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	public void itemStateChanged( ItemEvent event )
	{
		if( event.getSource() == combo	&& event.getStateChange() == ItemEvent.SELECTED )
		{
			System.out.println( "I changed the dropdown to :" + combo.getSelectedItem() );
		}
	}
}
