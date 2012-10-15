package controllers;

import databaseWrapper.QuestionDBWrapper;

public class QuestionController {
	QuestionDBWrapper db = new QuestionDBWrapper();
	
	public String[] getQuestions(int choice)
	{
		String[] questions = db.loadQuestionsFromFile(choice);
		return questions;
	}
}
