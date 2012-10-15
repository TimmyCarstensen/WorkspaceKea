package Controller;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Book {

	private String title, author, publisher;
	
	/**
	 * 
	 * @param t
	 * @param a
	 * @param p
	 */
	public Book(String t, String a, String p)
	{
		this.title = t;
		this.author = a;
		this.publisher = p;
	}
	
	// getmethods
	public String getTitle(){return this.title;}
	public String getAuthor(){return this.author;}
	public String getPublisher(){return this.publisher;}
}
