package db;

import controlEntity.Sled;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public interface IDbConnector {

	public boolean getConnection();
	public Sled loadOneSledFromDb();
	
}
