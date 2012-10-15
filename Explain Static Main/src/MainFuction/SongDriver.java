package MainFuction;
// SongDriver.java
public class SongDriver {
	public static void main (String args[]) {
		Song hello = new Song ("Hello");
		System.out.print ("Song " + Song.count + ": ");
		System.out.println (hello);
		Song elMundo = new Song ("El Mundo");
		System.out.print ("Song " + Song.count + ": ");
		System.out.println (elMundo);
	}
}