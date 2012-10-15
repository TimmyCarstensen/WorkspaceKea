import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnTest {
	public static void main(String args[]){

		String dbuser = "db_027";
		String passwd = "jens2002";
		
		Connection conn;
		int port = 1521;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:"+port+":dbwc", dbuser, passwd);
			conn.setAutoCommit(false);
			
		PreparedStatement s = conn.prepareStatement("Select * from Ships");
		
		PreparedStatement sr = conn.prepareStatement("INSERT into Ships values('HAHAHAHA','HUHUHUHU', 51512)");
		
		sr.executeUpdate();
		
		ResultSet rs = s.executeQuery();
		
		conn.commit();
		
		while (rs.next()){
			String sname = rs.getString(1);
			String sclass = rs.getString(2);
			String slaunched = rs.getString(3);
			
			System.out.println(sname + ":" + sclass + ":" + slaunched);
		}
		
		} catch(SQLException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
		
	}
}
