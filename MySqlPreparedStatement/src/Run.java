import java.sql.SQLException;


public class Run {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DemoConnectionToMySQL prepared = new DemoConnectionToMySQL();
		//prepared.insertNotPreparedStatement("Christian", "Kirschberg", "ckirschberg@gmail.com");
		
		prepared.selectAll();
		
//		prepared.selectAllHuts();
		
//		prepared.insertNotPreparedStatement("Thomas", "Carstensen", "Grantoften 6", "0306610231"); // This works aswell!!!!! :D
		
//		prepared.insert("Mathias", "Rothmann", "helgenvej 88", "0203991241"); // Works!!! :D
		
		
	}
}
