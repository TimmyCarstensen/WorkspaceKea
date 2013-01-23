package control;

import controlEntity.Sled;
import db.FakeDbConnector;
import db.IDbConnector;

public class Control 
{
	private IDbConnector idbCon;

	public Control(FakeDbConnector fc)
	{
		idbCon = fc;
	}

	public Sled loadSledFromDatabase()
	{
		if(idbCon.getConnection())
			return idbCon.loadOneSledFromDb();
		else
			return null;
	}
}
