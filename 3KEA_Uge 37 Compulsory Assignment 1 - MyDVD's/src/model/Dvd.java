package model;

import java.io.Serializable;


public class Dvd implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String instructor;
	private String genre;
	private String[] leadActors;

	public Dvd(String title, String instructor, String genre,
			String[] leadActors) {
		this.title = title;
		this.instructor = instructor;
		this.genre = genre;
		this.leadActors = leadActors;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String printAllLeadActors() {
		String temp = "";
		
		for(String actor : leadActors)
			temp += actor + ", ";
		return temp;
	}

	public String[] getLeadActors() {
		return leadActors;
	}

	public void setLeadActors(String[] leadActors) {
		this.leadActors = leadActors;
	}

}
