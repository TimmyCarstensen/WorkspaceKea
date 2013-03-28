package DBWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.Antibody;
import control.Storage;

public class Connections {
	
	private Connection con = null;
	private Statement st = null;
	private PreparedStatement preparedStatement = null;
	private PreparedStatement preparedStatement2 = null;
	private ResultSet resultSet = null;
	private ResultSet resultSet2 = null;
	
	
	//---------------------------------------------------------------------------------------------------------------
	// ArrayLists created:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------

	public ArrayList<Antibody> antibodies = new ArrayList<Antibody>();
	
	public ArrayList<Storage> storages = new ArrayList<Storage>();
	
	//---------------------------------------------------------------------------------------------------------------
	// Connection established:
	// (Coded by Michael and Timmy)
	//---------------------------------------------------------------------------------------------------------------

	
	public Connections()
	
	{
		
		try 
		{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				
				System.out.println(e);
			}
			con = DriverManager.getConnection("jdbc:mysql://213.5.177.178/cleverfo_bioku", "cleverfo_admin", "Bioku1234b");

		} catch (SQLException e) {
			System.out.println(e);

		}
		
	}
	
	//Method to call the stored procedure called "newAntibody" on the SQL server:
	//(Coded by Michael and Timmy)
	
	public void insertNewAntibody(int abid, String abname, int storage, 
				String gene, String epitope, String clonality, String primarysecondary, 
				String modifications, String specificity, String host, String batchno, String expirydate,
				String manufacturer, String datasheet, String applications,
				String protocolmodification, String notes)
	{
		
		try {
			
			st = con.createStatement();
			st.executeQuery("CALL newAntibody('" + abid + "','" +  abname + "','" +  storage + "','" +  
			gene + "','" +  epitope +  "','" + clonality + "','" +  primarysecondary + "','" +  modifications + "','" + specificity + "','" + 
			host + "','" +  batchno + "','" +  expirydate + "','" +  manufacturer + "','" +  datasheet + "','" +  applications + 
			"','" +  protocolmodification + "','" +  notes +"')");
		} catch (SQLException e) {
			
			System.out.println(e);
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------
	// Method to select and return all antibodies in the databse:
	// (Coded by Michael)
	//---------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Antibody> selectAllAntibodies()
	{
		antibodies.clear();
		
		try {
			preparedStatement = con.prepareStatement("SELECT * FROM antibodies");
			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			while (resultSet.next()) {
				// It is possible to get the columns via name
				// also possible to get the columns via the column number
				// which starts at 1
				// e.g. resultSet.getSTring(2);
				int pk_AntibodyId = resultSet.getInt(1);
				int abID = resultSet.getInt(2);
				String abName = resultSet.getString(3);
				String gene = resultSet.getString(5);
				String epitope = resultSet.getString(6);
				String clonality = resultSet.getString(7);
				String primarySecondary = resultSet.getString(8);
				String specificity = resultSet.getString(9);
				String modifications = resultSet.getString(10);
				String host = resultSet.getString(11);
				String batchNo = resultSet.getString(12);
				String expiryDate = resultSet.getString(13);
				String manufacturer = resultSet.getString(14);
				String datasheet = resultSet.getString(15);
				String applications = resultSet.getString(16);
				String protocolModifications = resultSet.getString(17);
				String notes = resultSet.getString(18);
				
				preparedStatement2 = con.prepareStatement("CALL findPosition (" + resultSet.getString(4) +");");
				resultSet2 = preparedStatement2.executeQuery();
				
				while (resultSet2.next())
				{
					

					String freezerType = resultSet2.getString(1);
					String freezerNumber = resultSet2.getString(2);
					String position = resultSet2.getString(3);
					
					Antibody a = new Antibody(pk_AntibodyId, abID, abName, freezerType, freezerNumber, position, gene, 
							epitope, clonality, primarySecondary, specificity, modifications, host, 
							batchNo, expiryDate, manufacturer, datasheet, applications, protocolModifications, notes);
					
					antibodies.add(a);
				}
				
				
			
			
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return antibodies;
	}
	
	
	
	
}
