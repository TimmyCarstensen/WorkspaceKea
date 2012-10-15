package databaseWrapper;


public class QuestionDBWrapper {

	//Since we have no database (or file system) to use yet, we simulate that we are using it.
	//This method will later on load data from a file when we learn about reading from- and writing to files.
	//For now, we hardcode some questions in this method.
	
	
	public String[] loadQuestionsFromFile(int choice)
	{
		
		String[] questions1 = new String[3];
		questions1[0] = "What age are you?";
		questions1[1] = "What colour is your favourt?";
		questions1[2] = "What is your mom's name?";
		
		
		
		String[] questions2 = new String [3];
		questions2[0] = "What is your name?";
		questions2[1] = "What are your hour payment?";
		questions2[2] = "What do you study?";
		
		if(choice == 1)
			return questions1;
		else if(choice == 2)
			return questions2;
		else 
			return new String[3];
	}
}
