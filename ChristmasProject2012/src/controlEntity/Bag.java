package controlEntity;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlEntity.Present.PresentType;


public class Bag 
{
	private int maxWeight;
	private BagType bagType;
	private ArrayList<Present> presents;
	
	public Bag(int maxWeight, BagType bagType)
	{
		this.maxWeight = maxWeight;
		this.bagType = bagType;
		this.presents = new ArrayList<Present>();
	}
	
	
	public boolean addPresent(Present present)
	{
		int weightOfBag = 0;
		boolean can = false;
		for(Present p : presents)
		{
			weightOfBag += p.getWeight();
		}
		
		weightOfBag += present.getWeight();
		
		if(bagType == BagType.PAPIR && present.getPresentType() == PresentType.SOFT)
		{
			System.out.println("Can't put this present in this bag");
		}
		else if(weightOfBag < maxWeight)
		{
			presents.add(present);	
			can = true;
		} else
		{
			// Maybe something else is to happen????
			JOptionPane.showMessageDialog(null, "Bag can't have this present, present is to heavy!");
		}
		return can;
	}
	
	public int totaltWeight()
	{
		int weight = 0;
		for(Present p : presents)
		{
			weight += p.getWeight();
		}
		return weight;
	}
	
	public boolean canPresentBeAdded(Present present)
	{
		boolean can = false;
		int weightOfBag = 0; 
		for(Present p : presents)
		{
			weightOfBag += p.getWeight();
		}
		
		weightOfBag += present.getWeight();
		
		
		if(weightOfBag < maxWeight)
		{
			can = true;
		}
		
		return can;
	}
	
	public void printAllPresents()
	{
		int i = 1;
		
		for(Present p : presents)
		{
			System.out.println("Present " + i + ": " + p.toString());
			i++;
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Bag size: " + maxWeight + "; Bag Type: " + bagType + "\n");
		int i = 1;
		for(Present p : presents)
		{
			sb.append("Present " + i + ": " + p.toString());
			i++;
		}
		return sb.toString();
	}
	
	
	public int getMaxWeight(){return this.maxWeight;}
	public BagType getBagType(){return this.bagType;}
	public ArrayList<Present> getPresents(){return this.presents;}
	public void setMaxWeight(int maxWeight){this.maxWeight = maxWeight;}
	public void setBagType(BagType bagType){this.bagType = bagType;}
	public void setPresent(ArrayList<Present> presents){this.presents = presents;}
	
	/**
	 * Different types of bags
	 * @author Timmy Carstensen
	 *
	 */
	public enum BagType{
		CANVAS, PLASTIC, PAPIR
	}
}
