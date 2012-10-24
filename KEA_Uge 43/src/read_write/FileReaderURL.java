package read_write;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class FileReaderURL {

	URLConnection connection;

	//(moving the filename to parameter would make this method more general and useful)
	public void ReadFile() //throws FileNotFoundException 
	{
		try {
		connection = new URL("http://ing.dk/artikel/133368-nu-gaar-eu-efter-gamer-grafikkorts-heftige-stroemforbrug").openConnection();
		Scanner input;
		
		input = new Scanner(connection.getInputStream()); 
		
		input.useDelimiter("\\z");
		
		String text = input.next();
		System.out.println(text);
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// "\\z" to a delimiter gives the opputunity to read the whole file at once!
	}
}