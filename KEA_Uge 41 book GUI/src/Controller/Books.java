package Controller;

import java.util.ArrayList;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Books {

	private ArrayList<Book> books;

	/**
	 * 
	 * @param t
	 * @param a
	 * @param p
	 */
	public Books()
	{
		this.books = new ArrayList<Book>();
		testBooks();
	}

	public void testBooks()
	{
		addBook(new Book("1ABC", "D", "1"));
		addBook(new Book("2ABC", "F", "2"));
		addBook(new Book("3ABC", "G", "3"));
	}
	
	/**
	 * 
	 * @param newBook
	 */
	public void addBook(Book newBook)
	{
		this.books.add(newBook);
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
}
