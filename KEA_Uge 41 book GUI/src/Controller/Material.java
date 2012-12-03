package Controller;

import java.util.ArrayList;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Material {

	private ArrayList<Book> books;
	private ArrayList<NewsPaper> newsPapers;

	/**
	 * 
	 * @param t
	 * @param a
	 * @param p
	 */
	public Material()
	{
		this.books = new ArrayList<Book>();
		testBooks();
		this.newsPapers = new ArrayList<NewsPaper>();
		testNewsPapers();
	}

	public void testBooks()
	{
		addBook(new Book("1ABC", "D", "1"));
		addBook(new Book("2ABC", "F", "2"));
		addBook(new Book("3ABC", "G", "3"));
	}
	
	//String title, String sidetal, String udgiver, String dato
	public void testNewsPapers()
	{
		addAvis(new NewsPaper("1GHF", "32", "E", "101012"));
		addAvis(new NewsPaper("2GHF", "51", "I", "090812"));
		addAvis(new NewsPaper("3GHF", "41", "J", "010312"));
	}
	
	/**
	 * 
	 * @param newBook
	 */
	public void addBook(Book newBook)
	{
		this.books.add(newBook);
	}

	public void addAvis(NewsPaper np)
	{
		this.newsPapers.add(np);
	}
	
	/**
	 * 
	 * @param book
	 */
	public void removeBook(Book book)
	{
		for(Book b : books){
			if(b == book)
			{
				books.remove(b);
			}
		}
	}
	
	/**
	 * 
	 * @param book
	 * @return
	 */
	public Book findBook(Book book)
	{
		for(Book b : books)
		{
			if(b == book)
			{
				return b;
			}
		}
		return null;
	}
	
	public ArrayList<Book> getBooks(){return this.books;}
	public ArrayList<NewsPaper> getNewsPaper(){return this.newsPapers;}
}
