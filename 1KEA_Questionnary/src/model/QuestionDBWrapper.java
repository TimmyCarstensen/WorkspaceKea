package model;

//import java.io.BufferedReader;
//import java.io.DataInputStream;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class QuestionDBWrapper {

	//Since we have no database (or file system) to use yet, we simulate that we are using it.
	//This method will later on load data from a file when we learn about reading from- and writing to files.
	//For now, we hardcode some questions in this method.

	private Scanner input;
	private ArrayList<String> questionnary;

	public QuestionDBWrapper()
	{
		this.questionnary = new ArrayList<String>();
	}

	public ArrayList<String> loadQuestionsFromFile(int choice)
	{	
		try{
			File f = null;
			if(choice == 1){
				f = new File("C:\\Users\\Timmy\\WorkspaceKea\\KEA_Questionnary\\questions_1");
			} else if(choice == 2)
			{
				f = new File("C:\\Users\\Timmy\\WorkspaceKea\\KEA_Questionnary\\questions_2");
			}
			input = new Scanner(f); 
			if(choice == 1)
			{
				while(input.hasNextLine()){
					String line = input.nextLine();
					this.questionnary.add(line);
				}
			}		
			input.close();
		}
		catch(NullPointerException e)
		{
			System.out.println("No such questionnary exists - questionnaries only exits in the amount {1, 2} of the choice value");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File with questions are not availeble");
		}

		//		String[] questions1 = new String[3];
		//		questions1[0] = "What age are you?";
		//		questions1[1] = "What colour is your favourt?";
		//		questions1[2] = "What is your mom's name?";
		//		
		//		String[] questions2 = new String[3];
		//		questions2[0] = "What is your name?";
		//		questions2[1] = "What are your hour payment?";
		//		questions2[2] = "What do you study?";

		return this.questionnary;
	}
}