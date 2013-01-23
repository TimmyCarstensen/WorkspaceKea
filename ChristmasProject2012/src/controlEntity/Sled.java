package controlEntity;
import java.util.ArrayList;

import controlEntity.Bag.BagType;


public class Sled 
{
	private Santa santa;
//	private ??? x;
//	private ??? y;
	private ArrayList<Bag> bags;
	
	public Sled(Santa santa)
	{
		this.santa = santa;
		this.bags = new ArrayList<Bag>();
	}
	
	
	public void addBag(Bag b)
	{
		bags.add(b);
	}
	
	public void addPresentAndNewBagIfNeeded(Present present)
	{
		Boolean isAdded = false;
		for(Bag b : bags)
		{
			if(b.canPresentBeAdded(present))
			{
				isAdded = b.addPresent(present);
				return;
			}
		}
		if(!isAdded)
		{
			Bag newBag = new Bag(20, BagType.CANVAS);
			newBag.addPresent(present);
			bags.add(newBag);
		}
	}
	
	
	public void print()
	{
		int i = 1;
		for(Bag b : bags)
		{
			System.out.println("Bag " + i + "\n" + b.toString());
			i++;
		}
	}
	
	
	public Santa getSante(){return this.santa;}
	public ArrayList<Bag> getBags(){return this.bags;}
	public void setSanta(Santa santa){this.santa = santa;}
}
