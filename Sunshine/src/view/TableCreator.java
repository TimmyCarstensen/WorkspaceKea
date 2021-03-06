package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import model.Cottage;
import model.Customer;
import model.Reservation;
import model.Resort;

/**
 * 
 * @author Timmy Carstensen
 *
 */

public class TableCreator {

	private Resort resort;

	public TableCreator(Resort resort)
	{
		this.resort = resort;
	}

	public void setCottageModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cottage Name","Price","Beds","Type"});
		model.setRowCount(resort.getCottages().size());
		int row = 0;
		for (Cottage cottage : resort.getCottages()) 
		{
			model.setValueAt(cottage.getCottageName(), row, 0);
			model.setValueAt(cottage.getPrice(), row, 1);
			model.setValueAt(cottage.getBeds(), row, 2);
			String typeOfCottage = "";
			if(cottage.getTypeOfCottage() == 's')
				typeOfCottage = "Standard";
			else if(cottage.getTypeOfCottage() == 'l')
				typeOfCottage = "Luxury";
			model.setValueAt(typeOfCottage, row, 3);
			row++;
		}
		table.setModel(model);
	}

	public void updateCottageModelSpecific(JTable table, int week, int year)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cottage Name","Price","Beds","Type","Status"});
		model.setRowCount(resort.getCottages().size());
		int row = 0;
		for (Cottage cottage : resort.getCottages()) 
		{	
			model.setValueAt(cottage.getCottageName(), row, 0);
			model.setValueAt(cottage.getPrice(), row, 1);
			model.setValueAt(cottage.getBeds(), row, 2);
			String typeOfCottage = "";
			if(cottage.getTypeOfCottage() == 's')
				typeOfCottage = "Standard";
			else if(cottage.getTypeOfCottage() == 'l')
				typeOfCottage = "Luxury";
			model.setValueAt(typeOfCottage, row, 3);
			String status = "";
			if(!cottage.checkVacancy(week, year))
				status = "Booked";
			else if(cottage.getRenovation())
				status = "Under Renovation";
			else 
				status = "Available";
			model.setValueAt(status, row, 4);
			row++;
		}
		table.setModel(model);
	}


	public void setCustomerModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Cvr / Cpr", "Name","Address","Telephone","Email", "Customer Type"});
		model.setRowCount(resort.getCustomer().size());
		int row = 0;
		for (Customer customer : resort.getCustomer()) {
			model.setValueAt(customer.getcvrNr_cprNr(), row, 0);
			model.setValueAt(customer.getName(), row, 1);
			model.setValueAt(customer.getAdress(), row, 2);
			model.setValueAt(customer.getTelephoneNumber(), row, 3);
			model.setValueAt(customer.getEmail(), row, 4);
			String typeOfCustomer = "";
			if(customer.getTypeOfCustomer() == 'f')
				typeOfCustomer = "Firm";
			else if(customer.getTypeOfCustomer() == 't')
				typeOfCustomer = "Tourist";
			model.setValueAt(typeOfCustomer, row, 5);
			row++;
		}
		table.setModel(model);
	}

	public void setReservationModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"ID","Cottage","Customer","Amount Due","Week","Year"});
		model.setRowCount(resort.getReservation().size());
		int row = 0;
		for (Reservation reservation : resort.getReservation()) 
		{
			String weeks = "";
			for(int week : reservation.getWeeks())
			{
				weeks += week + ", "; 
			}
			model.setValueAt(reservation.getID(), row, 0);
			model.setValueAt(reservation.getCottage().getCottageName(), row, 1);
			model.setValueAt(reservation.getCustomer().getcvrNr_cprNr() + " - " + reservation.getCustomer().getName(), row, 2);
			model.setValueAt(reservation.getTotalPrice(), row, 3);
			model.setValueAt(weeks, row, 4);
			model.setValueAt(reservation.getYear(), row, 5);
			row++;
		}
		table.setModel(model);
	}
}
