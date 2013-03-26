package read_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader {

	
	//(moving the filename to parameter would make this method more general and useful)
	public String ReadFile() //throws FileNotFoundException 
	{
		File f = new File("ReadWholeFile");
		Scanner input;
		
		
		try {
			//Scanner input = new Scanner(f); //explain why this doesn't work.
			input = new Scanner(f); //Notice how this generates an error. You are forced to define how to handle an exception thrown here.		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. File not found");
			return "Error. File Not found";
		}
		// "\\z" to a delimiter gives the opputunity to read the whole file at once!
		// input.useDelimiter("\\z");
		
		System.out.println(input.next());
		
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			System.out.println(line);
		}
		
		input.close();
		return ""; //no error
	}
}
