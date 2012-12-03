package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CreateID {

	private String ID; 
	private Integer number;
	private Scanner input;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{ 
		CreateID id = new CreateID();
		System.out.println(id.getID());
	}


	public CreateID()
	{
		readInFile();
		createNumberID();
		writeToFile();
		
	}


	public void createNumberID()
	{
		this.number = this.number.intValue() + 1;
		int lenghtOfNumber = number.toString().length();
		StringBuilder zeros = new StringBuilder();
		int numberOfZeros = 6 - lenghtOfNumber;
		while(numberOfZeros > 0)
		{
			zeros.append('0');
			numberOfZeros--;
		}

		this.ID = "SUNRE" + 2012 + "100A" + zeros.toString() + number.intValue();
		
		this.number = this.number.intValue() + 1;
	}


	public void readInFile()
	{
		File f = new File("uniqueID");
		try 
		{
			this.input = new Scanner(f);

			String line = input.nextLine();
			this.number = Integer.parseInt(line.substring(13, 19));

		} catch (FileNotFoundException e)
		{
			System.out.println("Fil ikke fundet!!!!!");
		}
	}


	public void writeToFile() 
	{
		File f = new File ("uniqueID"); 

		try {
			FileOutputStream fos = new FileOutputStream (f, false);
			PrintStream output = new PrintStream(fos);
			
			output.println(this.ID);


			output.close();
		}

		catch (IOException e) 
		{
			System.out.println("error");
		}
	}

	public Integer getNumber()
	{
		return this.number;
	}
	
	public String getID()
	{
		return this.ID;
	}
}
