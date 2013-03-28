package control;

import java.util.ArrayList;

import DBWrapper.Connections;

public class Control {
	
	Connections connect = new Connections();
	
	
	public ArrayList<Antibody> getAntibodies()
	{
		return connect.selectAllAntibodies();
	}
	
	
	


}
