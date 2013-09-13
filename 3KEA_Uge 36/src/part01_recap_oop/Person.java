package part01_recap_oop;

public class Person {

	private String cpr;
	private String name;
	private String address;
	private String zip;
	private String city;
	private String email;
	
	public Person(String cpr, String name, String address, String zip, String city, String email) 
	{	
		this.cpr = cpr;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.email = email;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
