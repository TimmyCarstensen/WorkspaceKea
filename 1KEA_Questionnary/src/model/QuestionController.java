package model;

import java.util.ArrayList;


public class QuestionController {
	QuestionDBWrapper db = new QuestionDBWrapper();
	
	public ArrayList<String> getQuestions(int choice)
	{
		ArrayList<String> questions = db.loadQuestionsFromFile(choice);
		return questions;
	}
}
