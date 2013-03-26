package metoder;

import java.util.ArrayList;


public class BookSolutionsDoNotLookBeforeYouHaveTried {

	private String name;
	private ArrayList<Book> books;
	private int ageOfOwner;
	
	//1.1 define a method, setName, that sets the name of the book store
	public void setName(String name)
	{
		this.name = name;
		books = new ArrayList<Book>();
	}
	
	public String getName(){return this.name;}
	
	//1.2 Define a method, hiThere, that returns "Hi there".
	public String hiThere()
	{
		return "Hi there";
	}
	
	//1.3 Define a method, numberOfBooks, that returns how many books there are in the arraylist of books.
	public int numberOfBooks()
	{
		return books.size();
	}
	
	
	//1.4 Define a method, multiplyAgeBy, that takes a number in and multiplies 
	public int multiplyAgeBy(int factor)
	{
		return factor * ageOfOwner;
	}
	
//	1.5 Define a method, multiplyOver20, that takes two numbers in, multiplies them and returns "Over 20" if they are over 20 multiplied and "Less than 20" if they are less than 20.
	public String multiplidOver20(int a, int b)
	{
		int c = a*b;
		if (c > 20)
			return "Over 20";
		else
			return "Less than 20";
	}
	
//	1.6 Define a method, multiplyOver30, that takes two numbers in, multiplies them and returns true if they are over 30 multiplied and false if they are less than 30.
	public Boolean multiplyOver30(int a, int b)
	{
		return a*b > 30;
	}
	
	
	
//	1.7 Add a method that adds a book to the list of books.
//	(The method takes a Book as a parameter.)
	public void addBook(Book b)
	{
		books.add(b);
	}

}
