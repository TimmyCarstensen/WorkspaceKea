package model;

/**
 * @author Farhiya
 * 
 */
public abstract class Customer {

	protected char typeOfCustomer;
	protected String name;
	protected String telephoneNumber; 
	protected String adress;
	protected String email; 
	protected String cvrNr_cprNr;

		
	/**
	 * 
	 * @param typeOfCustomer
	 * @param name
	 * @param telephoneNumber
	 * @param adress
	 * @param email
	 * @param cvrNr
	 */
	public Customer(char typeOfCustomer, String name, String telephoneNumber, String adress, String email, String cvrNr_cprNr)
	{
		this.typeOfCustomer = typeOfCustomer;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.adress = adress;
		this.email = email;
		this.cvrNr_cprNr = cvrNr_cprNr;
	}
	
	

	
	public void setName(String navn) {
		this.name = navn;
	}

	public void setTelephoneNumber(String tlf) {
		this.telephoneNumber = tlf;
	}

	public void setAdress(String adresse) {
		this.adress = adresse;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTypeOfCustomer(char typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}
	
	public void setcvrNr_cprNr(String cvrNr_cprNr){this.cvrNr_cprNr = cvrNr_cprNr;}
	
	public String getName(){
		return this.name;
		}

	public String getTelephoneNumber(){
		return this.telephoneNumber;
	}

	public String getAdress(){
		return this.adress;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public char getTypeOfCustomer() {
		return typeOfCustomer;
	}
	
	public String getcvrNr_cprNr(){return this.cvrNr_cprNr;}
}



