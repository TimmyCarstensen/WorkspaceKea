package read_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FromBook {

	public static void main(String[] args) throws FileNotFoundException { 
		Scanner console = new Scanner(System.in);
		Scanner input = getInput(console);
		
		int count = 0;
		while (input.hasNext())
		{
			String word = input.next();
			count++;
		}
		System.out.println("Total words = " + count);
	}
	
	
	
	public static Scanner getInput(Scanner console) throws FileNotFoundException
	{
		System.out.print("input file name? ");
		File f = new File(console.nextLine());
		
		while (!f.canRead())
		{
			System.out.println("File not found. Try again.");
			System.out.println("input file name? ");
			f = new File(console.nextLine());
		}
		
		return new Scanner(f);
	}
	

}
