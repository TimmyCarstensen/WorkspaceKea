import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Timmy Carstensen
 * Here is example code to connect to mysql via java. It is from week 6, second semester at computer science at Københavns Erhvervs Akademi this has been developed.
 * It requires to have jdbc driver installed and mysql installed on local host, though it probably possible to connect via internet aswell.
 *
 */
public class DemoConnectionToMySQL {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	//Notice the redundant code here in the insertNotPreparedStatement, insert and selectAll. 
	//These two lines of code:
	//Class.forName("com.mysql.jdbc.Driver"); //If this line throws an exception you haven't set up the jdbc driver correctly on your pc
	//connect = DriverManager.getConnection("jdbc:mysql://localhost/Ex1Person?user=root&password=chr99jahn");
	//How could you improve this code?

	public DemoConnectionToMySQL()
	{
		try{
		// This will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver"); //If this line throws an exception you haven't set up the jdbc driver correctly on your pc
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://localhost/sunshine?user=root&password=timm0358"); //Change password and database name
		}
		catch(Exception e)
		{
			
		}
	}

	//shows how difficult it is to write sql in Java with variables. Use prepared statements instead.
	public void insertNotPreparedStatement(String firstname, String lastname, String adress, String cpr_number)
	{
		try {
			// This will load the MySQL driver, each DB has its own driver
//			Class.forName("com.mysql.jdbc.Driver"); //If this line throws an exception you haven't set up the jdbc driver correctly on your pc
			// Setup the connection with the DB
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/sunshine?user=root&password=timm0358"); //Change password and database name
			
			statement = connect.createStatement();
			statement.executeUpdate("INSERT INTO customers VALUES (default, '" + firstname + "','" + lastname + "','" + adress + "','" + cpr_number + "')"); //default used for auto incrementing primary key.
			
			System.out.println("Succes with insertNotPreparedStatement method");
		}
		catch(Exception e) //no exception handling here.
		{
		}
	}




	public void insert(String firstname, String lastname, String adress, String cpr_number)
	{
		try {
			// This will load the MySQL driver, each DB has its own driver
//			Class.forName("com.mysql.jdbc.Driver");//If this line throws an exception you haven't set up the jdbc driver correctly on your pc
			// Setup the connection with the DB
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/sunshine?user=root&password=timm0358"); //Change password and database name

			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement("INSERT INTO Customers VALUES (default, ?, ?, ?, ?)");

			// Parameters start with 1
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, adress);
			preparedStatement.setString(4, cpr_number);

			preparedStatement.executeUpdate();
			
			connect.close();
			System.out.println("Succes using insert-method!!");
		}
		catch(Exception e) //no exception handling here.
		{
		}
	}


	public void selectAll() throws ClassNotFoundException, SQLException
	{
		try {

			// This will load the MySQL driver, each DB has its own driver
//			Class.forName("com.mysql.jdbc.Driver");//If this line throws an exception you haven't set up the jdbc driver correctly on your pc
			// Setup the connection with the DB
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/sunshine?user=root&password=timm0358");  //change DBname (Ex1Person) to your DB name.

			preparedStatement = connect.prepareStatement("SELECT * FROM customers");
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet);
		}
		catch (Exception e) //no exception handling here.
		{

		}
	}

	public ArrayList<Hut> selectAllHuts()
	{
		ArrayList<Hut> huts = new ArrayList<Hut>();
		//giver fejl pga. ingen Hut klasse. Opret en Hut klasse.
		try {

			// This will load the MySQL driver, each DB has its own driver
//			Class.forName("com.mysql.jdbc.Driver");//If this line throws an exception you haven't set up the jdbc driver correctly on your pc
			// Setup the connection with the DB
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/sunshine?user=root&password=timm0358");  //change DBname (Ex1Person) to your DB name.

			preparedStatement = connect.prepareStatement("SELECT name, price, noofbeds, type FROM cottages");
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				int noofbeds = resultSet.getInt("noofbeds");
				int price = resultSet.getInt("price");
				String type = resultSet.getString("type");
				
				huts.add(new Hut(name, noofbeds, price, type));
			}
			for(Hut h : huts){
				System.out.println(h.toString());
			}
		}
		catch (Exception e) //no exception handling here.
		{

		}
		return huts;
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		
		int i = 1;
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String firstName = resultSet.getString("firstname");
			String lastName = resultSet.getString("lastname");
			String adress = resultSet.getString("adress");
			String telephone = resultSet.getString("telephonenumber");
			String cpr_cvr = resultSet.getString("cpr_cvr");
			System.out.println("Customer " + i++);
			System.out.println("First Name: " + firstName);
			System.out.println("Last Name: " + lastName);
			System.out.println("Adress: " + adress);
			System.out.println("Telephone Number: " + telephone);
			System.out.println("Cpr Number: " + cpr_cvr);
		}
	}
}
