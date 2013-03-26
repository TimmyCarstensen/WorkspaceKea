package constructorEncapsulation;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		User user1 = new User("PJ", "1234", "Peter", "Jensen", "P@j.dk");
		user1.print();
	}
}
