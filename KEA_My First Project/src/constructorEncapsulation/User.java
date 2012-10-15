package constructorEncapsulation;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class User {
	private String username;
	private String password;
	public String firstName;
	public String lastName;
	public String email;
	
	/**
	 * First constructor setting only password and username.
	 * @param username
	 * @param password
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Second constructor setting all parameters.
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public User(String username, String password, String firstName, String lastName, String email){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public void print(){
		System.out.println("Username: " + username);
		System.out.println("Password: ****");
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("----------------------------------------");
	}
	
	public void setNewAttributes(String username, String password, String firstName, String lastName, String email){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public void setUsername(String us){this.username = us;}
	public void setPassword(String pw){this.password = pw;}
	public void setFirstName(String fn){this.firstName = fn;}
	public void setLastName(String ln){this.lastName = ln;}
	public void setEmail(String em){this.email = em;}
	
	public String getUsername(){return username;}
	public String getPassword(){return password;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getEmail(){return email;}
}
