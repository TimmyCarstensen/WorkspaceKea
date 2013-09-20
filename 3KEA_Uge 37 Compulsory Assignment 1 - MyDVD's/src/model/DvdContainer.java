package model;


import java.io.Serializable;
import java.util.ArrayList;

public class DvdContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Dvd> dvdList;
	
	/**
	 * Constructor
	 */
	public DvdContainer() {
		dvdList = new ArrayList<Dvd>();
	}
	
	public void load() {
		
	}
	
	public void addDvd(Dvd dvd) {
		
		dvdList.add(dvd);
	}

	public void removeDvd(Dvd dvd) {
		for (Dvd d : dvdList) {
			if (d.equals(dvd))
				dvdList.remove(d);
		}
	}

	public ArrayList<Dvd> getDvdList() {
		return this.dvdList;
	}

	public void setDvdList(ArrayList<Dvd> dvdList) {
		this.dvdList = dvdList;
	}

	/**
	 * toString method
	 * @return temp - return all dvd information in a String.
	 */
	public String toString(){
		String temp = "";
		for(Dvd dvd : dvdList){
			temp += "Title: "        + dvd.getTitle() + "\n";
			temp += "Genre: "        + dvd.getGenre() + "\n";
			temp += "Instructor: "   + dvd.getInstructor() + "\n";
			temp += "Lead Actors: "  + dvd.printAllLeadActors() + "\n\n";
		}
		return temp;
	}
	
	public void sortDvdsByTitle() {
		// TODO
	}
	
	public void sortDvdsByActor() {
		// TODO
	}
	
	public void sortDvdsByGenre() {
		// TODO
	}
	
	public void sortDvdsByInstructor() {
		// TODO
	}
}
