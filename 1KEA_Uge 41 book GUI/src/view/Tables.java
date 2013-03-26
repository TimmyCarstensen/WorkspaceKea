package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Book;
import Controller.Material;
import Controller.NewsPaper;

public class Tables {

	private Material material;
	
	
	public Tables(Material material)
	{
		this.material = material;
	}
	
	
	public DefaultTableModel getBookModel()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Title", "Author", "Publisher"});
		model.setRowCount(material.getBooks().size());
		int row = 0;
		for (Book book : material.getBooks()) {
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
		model.setRowCount(material.getNewsPaper().size());
		int row = 0;
		for (NewsPaper newsPaper : material.getNewsPaper()) {
			model.setValueAt(newsPaper.getTitle(), row, 0);
			model.setValueAt(newsPaper.getSidetal(), row, 1);
			model.setValueAt(newsPaper.getUdgiver(), row, 2);
			model.setValueAt(newsPaper.getDato(), row, 3);
			
			row++;
		}
		
		return model;			
	}	
	
	public void updateBookModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Title", "Author", "Publisher"});
		model.setRowCount(material.getBooks().size());
		int row = 0;
		for (Book book : material.getBooks()) {
			model.setValueAt(book.getTitle(), row, 0);
			model.setValueAt(book.getAuthor(), row, 1);
			model.setValueAt(book.getPublisher(), row, 2);
			
			row++;
		}
		table.setModel(model);
	}
	
	public void updateNewsPaperModel(JTable table)
	{
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Titel", "SideTal", "Udgiver", "Dato"  });
		model.setRowCount(material.getNewsPaper().size());
		int row = 0;
		for (NewsPaper newsPaper : material.getNewsPaper()) {
			model.setValueAt(newsPaper.getTitle(), row, 0);
			model.setValueAt(newsPaper.getSidetal(), row, 1);
			model.setValueAt(newsPaper.getUdgiver(), row, 2);
			model.setValueAt(newsPaper.getDato(), row, 3);
			
			row++;
		}
		table.setModel(model);
	}
	
}
