package Controller;

import java.awt.image.TileObserver;

public class NewsPaper {

	private String title;
	private String sidetal;
	private String udgiver;
	private String dato;
	
	
	public NewsPaper(String title, String sidetal, String udgiver, String dato)
	{
		this.title = title;
		this.sidetal = sidetal;
		this.udgiver = udgiver;
		this.dato = dato;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSidetal() {
		return sidetal;
	}


	public void setSidetal(String sidetal) {
		this.sidetal = sidetal;
	}


	public String getUdgiver() {
		return udgiver;
	}


	public void setUdgiver(String udgiver) {
		this.udgiver = udgiver;
	}


	public String getDato() {
		return dato;
	}


	public void setDato(String dato) {
		this.dato = dato;
	}
}
