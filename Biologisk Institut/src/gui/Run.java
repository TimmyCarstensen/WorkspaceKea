package gui;

import DBWrapper.Connections;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connections connect = new Connections();
		
		connect.insert("Testesen2");

	}

}