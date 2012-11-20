package model;
/**
 * 
 * @author Farhiya
 *
 */
public class FirmCustomer extends Customer {

	/**
	 * 
	 * @param name
	 * @param telephoneNumber
	 * @param adress
	 * @param email
	 * @param cvrNr
	 * @param typeOfCustomer
	 */
	public FirmCustomer(char typeOfCustomer, String name, String telephoneNumber, String adress, String email, String cvrNr)
	{
		super(typeOfCustomer, name, telephoneNumber, adress, email, cvrNr);
	
	}
	

}
