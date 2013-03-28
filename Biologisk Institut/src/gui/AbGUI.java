package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alee.laf.button.WebButton;
import com.alee.laf.table.WebTable;

import control.Antibody;
import control.Control;


//---------------------------------------------------------------------------------------------------------------
// Class Inheritance from JFrame:
// (Coded by Michael)
//---------------------------------------------------------------------------------------------------------------

public class AbGUI extends JFrame implements ActionListener, MouseListener {
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//---------------------------------------------------------------------------------------------------------------
	// Control class instantiated:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------
	
	private Control control = new Control();
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	// Variables and components created:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------
	
	private JPanel north, center, south;
	private DefaultTableModel model;
	private WebTable table;
	private WebButton showAll;
	
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	// Construction of the GUI:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------
	
	public AbGUI()
	{
		
		setSize( 1200, 800 );
		setTitle("Antibodies");
		setDefaultCloseOperation(3);
		setLocation(300, 200);
		
		
		table = new WebTable();
		table.setAutoCreateRowSorter(true);
        table.setEditable ( false );
        table.setAutoResizeMode ( WebTable.AUTO_RESIZE_OFF );
        table.setRowSelectionAllowed ( true );
        table.setColumnSelectionAllowed ( false );
		
        
		updateTable();
		
		north = new JPanel(new GridLayout(1, 2));
		center = new JPanel(new GridLayout(1, 2));
		south = new JPanel(new GridLayout(1, 2));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(north, BorderLayout.NORTH); 
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(center, BorderLayout.CENTER);
			
		this.showAll = new WebButton("Show all Antibodies");
		
		
		//---------------------------------------------------------------------------------------------------------------
		// Components added to JPanels:
		// (Coded by Michael)
		//---------------------------------------------------------------------------------------------------------------		
		
		north.add(new JLabel(""));


		center.add(new JScrollPane(table));
		
		
		
		setVisible(true);

		
	}
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	// Method to update the table with data from "antibodies" table in the database:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------		
	
	public void updateTable()
	{
		
		model = new DefaultTableModel();
		
		model.setColumnIdentifiers(new String[] { "Key", "ID", "Name", "Freezer Type", "FreezerNumber", "Position", 
												  "Gene", "Epitope", "Clonality", "Primary/Secondary", "Specificity", 
												  "Modifications", "Host", "Batch No.", "Expiry Date", "Manufacturer", "Datasheet", 
												  "Applications"});
		
		model.setRowCount(control.getAntibodies().size());
		
		int row = 0;
		for (Antibody a : control.getAntibodies())
		{
		model.setValueAt(a.getPk_AntibodyId(), row, 0);
		model.setValueAt(a.getAbID(), row, 1);
		model.setValueAt(a.getAbName(), row, 2);
		model.setValueAt(a.getFreezerType(), row, 3);
		model.setValueAt(a.getFreezerNumber(), row, 4);
		model.setValueAt(a.getPosition(), row, 5);
		model.setValueAt(a.getGene(), row, 6);
		model.setValueAt(a.getEpitope(), row, 7);
		model.setValueAt(a.getClonality(), row, 8);
		model.setValueAt(a.getPrimarySecondary(), row, 9);
		model.setValueAt(a.getSpecificity(), row, 10);
		model.setValueAt(a.getModifications(), row, 11);
		model.setValueAt(a.getHost(), row, 12);
		model.setValueAt(a.getBatchNo(), row, 13);
		model.setValueAt(a.getExpiryDate(), row, 14);
		model.setValueAt(a.getManufacturer(), row, 15);
		model.setValueAt(a.getDatasheet(), row, 16);
		model.setValueAt(a.getApplications(), row, 17);
		
		row++;
		
		}
		
		table.setModel(model);
		
	}
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	// MouseListeners. These are used to update the finalPriceField when ever a new row is click in the UI:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	//---------------------------------------------------------------------------------------------------------------
	// ActionListeners for the components in the GUI:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
