package DBWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
	
	private Connection con = null;
	private Statement st = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
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
			System.out.println("Connected to the databse");

		} catch (SQLException e) {
			System.out.println(e);

		}
		
	}
	
	public void insert(String testName){
		
		try {
			
			st = con.createStatement();
			st.executeQuery("call newTest('" + testName + "')");

			
		} catch (SQLException e) {
			
			System.out.println(e);
		}
	}

}
