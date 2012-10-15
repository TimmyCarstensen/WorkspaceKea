package parsertester;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;


public class Parser {
	private File file;

	public Parser() throws FileNotFoundException
	{
		readFromFile();
	}
	
	public void readFromFile() throws FileNotFoundException
	{
		Reader reader = new BufferedReader(new FileReader("./testparser.txt"));
        Scanner s = new Scanner(reader);
        
        while(s.hasNextLine()){
        	System.out.println(s.nextLine());
        }
        
        
        
        s.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		new Parser();
	}
}
