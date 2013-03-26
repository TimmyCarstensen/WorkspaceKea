package model;

import java.io.*;
import java.util.Scanner;


public class MyFileReader {
	Scanner input;

	public Boolean openFile(String filename)
	{
		Boolean success = false;
		File f = new File(filename);
		
		try {
			input = new Scanner(f); //Notice how this generates an error. You are forced to define how to handle an exception thrown here.
			success = true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error. File not found");
		}
		
		return success;
	}
	
	public void closeFileAfterUse()
	{
		input.close();
	}
	
	public String readAndReturnOneLine()
	{
		String line = "";
		if (input != null && input.hasNextLine())
		{
			line = input.nextLine();
		}
		
		return line;
	}
	
	
	//bad coding in here to avoid you have to use try - catch in other classes.
	public int numberOfLines(String path)
	{
		int numberOfLines = -1;
		BufferedReader bf = null;
		
		try {
			FileReader file = new FileReader(path);
			bf = new BufferedReader(file);
			@SuppressWarnings("unused")
			String aLine;
			
			while (( aLine = bf.readLine()) != null){
				numberOfLines++;
			}
		}
		catch(IOException e)//ignoring this possible error, not handled.
		{
		}
		finally {
			try { 
				bf.close();
			}
			catch(Exception e)//ignoring this possible error, not handled.
			{}
		}
		
		return numberOfLines;
	}
}
