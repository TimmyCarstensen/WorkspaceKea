package metoder;

import java.util.ArrayList;


public class BookStore {

	private ArrayList<Book> books = new ArrayList<Book>();
	private String name;
	private int streetNumber;
	private int ageOfOwner; //yes, it makes no logical sense ;-)
	
	public BookStore()
	{
		
	}
	
	public BookStore(String name, int streetNumber)
	{
		this.name = name;
		this.streetNumber = streetNumber;
	}

	//1.1 define a method, setName, that sets the name of the book store
	public void setName(String name){this.name = name;}
	//1.2 Define a method, hiThere, that returns "Hi there".
	public String hiThere(){return "Hi there";}
	
	//1.3 Define a method, numberOfBooks, that returns how many books there are in the arraylist of books.
	public int numberOfBooks()
	{
		return books.size();
	}
	
	//1.4 Define a method, multiplyAgeBy, that takes a number in and multiplies 
	public int multiplyAgeBy(int factor)
	{
		return (factor * this.ageOfOwner);
	}
	
	//1.5 Define a method, multiplyOver20, that takes two numbers in, multiplies them and returns "Over 20" if they are over 20 multiplied and "Less than 20" if they are less than 20.
	public String multiplyOver20(int a, int b)
	{
		String over_Less = "";
		int multiplied = a * b;
		if(multiplied > 20)
			over_Less = "Over 20";
		else if(multiplied < 20)
			over_Less = "Less than 20";
		else
			over_Less = "It is 20 exactly";
		return over_Less;
	}
	
	//1.6 Define a method, multiplyOver30, that takes two numbers in, multiplies them and returns true if they are over 30 multiplied and false if they are less than 30.
	public boolean multiplayOver30(int a, int b)
	{
		int multiplied = a * b;
		return multiplied > 30 || multiplied < 30;
		
			
	}
	
	//1.7 Add a method that adds a book to the list of books.
	//(The method takes a Book as a parameter.)
	public void addBook (Book book)
	{
		books.add(book);
	}
	
	public String getName(){return this.name;}
	public int getStreetNumber(){return this.streetNumber;}
	
}
