
public class Database 
{	
	private static Database db = null;
	
	private Database()
	{
		
	}
	
	public static Database getInstance()
	{
		if(db == null)
			db = new Database();		
		return db;
	}
}
