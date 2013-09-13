package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DvdContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Dvd> dvdcontainer;

	public DvdContainer() {

	}

	public void addDvd(Dvd dvd) {
		dvdcontainer.add(dvd);
	}

	public void removeDvd(Dvd dvd) {
		for (Dvd d : dvdcontainer) {
			if (d.equals(dvd))
				dvdcontainer.remove(d);
		}
	}

	public ArrayList<Dvd> getDvdContainer() {
		return this.dvdcontainer;
	}

	public void setDvds(ArrayList<Dvd> dvdContainer) {
		this.dvdcontainer = dvdContainer;
	}

	public void sortDvds() {

	}
}
