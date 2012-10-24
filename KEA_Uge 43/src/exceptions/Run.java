package exceptions;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Exceptions e = new Exceptions();
		}
		catch(NullPointerException e)
		{
			System.out.println("Not initialized");
		}
		catch(Exception e)
		{
			System.out.println("General Exception other than NullPointer");
		}
	}
}
