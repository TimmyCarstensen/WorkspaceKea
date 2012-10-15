package MainFuction;

//Song.java
public class Song {
	private String title;
	// global variable
	public static int count;

	public Song (String title) {
		this.title = title;
		// Increment class variable count every time song is created.
		Song.count++;
	}

	public String toString () {
		return title;
	}
}