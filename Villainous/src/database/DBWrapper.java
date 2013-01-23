package database;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import control.Character;

public class DBWrapper {
	
	private Scanner input;
	private PrintStream output;
	private File save1 = new File("save/1.txt");
	
	
	public void loadSave(String s)
	{
		try{
		input = new Scanner(s);
		
		input.useDelimiter(";");
		
		int hp = Integer.parseInt(input.next());
		int money = Integer.parseInt(input.next());
		String weapon = input.next();
		
		Character character = new Character(hp, money, weapon);
		
		}catch(Exception e)
		{
			
		}
		
	}

}
