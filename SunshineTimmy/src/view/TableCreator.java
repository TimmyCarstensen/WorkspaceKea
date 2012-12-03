package view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.Cottage;
import model.Customer;
import model.Reservation;
import model.Resort;

public class TableCreator {

	private Resort resort;

	public TableCreator(Resort resort)
	{
		this.resort = resort;
	}

	public DefaultTableModel getCottageModel()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cottage Name","Price","Beds","Type","Renovation"});
		model.setRowCount(resort.getCottages().size());
		int row = 0;
		for (Cottage cottage : resort.getCottages()) 
		{
			model.setValueAt(cottage.getCottageName(), row, 0);
			model.setValueAt(cottage.getPrice(), row, 1);
			model.setValueAt(cottage.getBeds(), row, 2);
			model.setValueAt(cottage.getTypeOfCottage(), row, 3);
			if(cottage.getRenovation())
				model.setValueAt("Under Renovation", row, 4);
			else
				model.setValueAt("No Renovation at this time", row, 4);
			row++;
		}


		return model;			
	}

	public void updateCottageModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cottage Name","Price","Beds","Type","Renovation"});
		model.setRowCount(resort.getCottages().size());
		int row = 0;
		for (Cottage cottage : resort.getCottages()) 
		{
			model.setValueAt(cottage.getCottageName(), row, 0);
			model.setValueAt(cottage.getPrice(), row, 1);
			model.setValueAt(cottage.getBeds(), row, 2);
			model.setValueAt(cottage.getTypeOfCottage(), row, 3);
			if(cottage.getRenovation())
				model.setValueAt("Under Renovation", row, 4);
			else
				model.setValueAt("No Renovation at this time", row, 4);
			row++;
		}
		table.setModel(model);
	}

	public DefaultTableModel getCustomerModel()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cvr / Cpr", "Name","Adress","Telephone","Email","Customer Type" });
		model.setRowCount(resort.getCustomer().size());
		int row = 0;
		for (Customer customer : resort.getCustomer()) {
			model.setValueAt(customer.getcvrNr_cprNr(), row, 0);
			model.setValueAt(customer.getName(), row, 1);
			model.setValueAt(customer.getAdress(), row, 2);
			model.setValueAt(customer.getTelephoneNumber(), row, 3);
			model.setValueAt(customer.getEmail(), row, 4);
			model.setValueAt(customer.getTypeOfCustomer(), row, 5);
			
			row++;
		}

		return model;			
	}	

	public void updateCustomerModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cvr / Cpr", "Name","Adress","Telephone","Email", "Customer Type"});
		model.setRowCount(resort.getCustomer().size());
		int row = 0;
		for (Customer customer : resort.getCustomer()) {
			model.setValueAt(customer.getcvrNr_cprNr(), row, 0);
			model.setValueAt(customer.getName(), row, 1);
			model.setValueAt(customer.getAdress(), row, 2);
			model.setValueAt(customer.getTelephoneNumber(), row, 3);
			model.setValueAt(customer.getEmail(), row, 4);
			model.setValueAt(customer.getTypeOfCustomer(), row, 5);
			row++;
		}
		table.setModel(model);
	}


	public DefaultTableModel getReservationModel()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cottage","Customer","Total Price","Week","Year"});
		model.setRowCount(resort.getReservation().size());
		int row = 0;
		for (Reservation reservation : resort.getReservation()) {
			String weeks = "";
			for(int week : reservation.getWeeks())
			{
				weeks += week + ", "; 
			}
			model.setValueAt(reservation.getCottage().getCottageName(), row, 0);
			model.setValueAt(reservation.getCustomer().getcvrNr_cprNr(), row, 1);
			model.setValueAt(reservation.getTotalPrice(), row, 2);
			model.setValueAt(weeks, row, 3);
			model.setValueAt(reservation.getYear(), row, 4);
			row++;
		}
		return model;			
	}	

	public void updateReservationModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cottage","Customer","Total Price","Week","Year"});
		model.setRowCount(resort.getReservation().size());
		int row = 0;
		for (Reservation reservation : resort.getReservation()) {
			String weeks = "";
			for(int week : reservation.getWeeks())
			{
				weeks += week + ", "; 
			}
			model.setValueAt(reservation.getCottage().getCottageName(), row, 0);
			model.setValueAt(reservation.getCustomer().getcvrNr_cprNr(), row, 1);
			model.setValueAt(reservation.getTotalPrice(), row, 2);
			model.setValueAt(weeks, row, 3);
			model.setValueAt(reservation.getYear(), row, 4);
			row++;
		}
		table.setModel(model);
	}
}
