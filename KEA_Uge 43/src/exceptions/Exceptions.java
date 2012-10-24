package exceptions;


public class Exceptions {
	
	public Exceptions() throws NullPointerException //By adding the "throws" we define all NullPointerExceptions to be handled in the calling method. 
	{
		Person p = new Person();
		
		if (p.Male)
			System.out.println("Male");
		else
			System.out.println("Female");
		
	}
}

