package model;

import java.util.ArrayList;

public class Br�t {

	private ArrayList<Brik> brikker;
//	private Terning terning;
//	private Bank bank;
	
	
	public Br�t()
	{
		brikker = new ArrayList<Brik>();
	}

	/**
	 * at minium 2 players
	 * @param name
	 */
	public void addPlayer(String name)
	{
		Brik brik = new Brik(name);
		brikker.add(brik);
	}
	
	
	
}
