package model;
/*
 * lavet af Hisayo
 */
public abstract class Hytte {
	
	protected int pris;
	protected int senge;
	protected boolean renovation;
	
	public Hytte (int p, int s)
	{
		this.pris = p;
		this.senge = s;
		this.renovation = false;
	}
	
	
	public int getPris()
	{
		return pris;
	}
	
	public int getSenge()
	{
		return senge;
	}
	
	public boolean getRenovation()
	{
		return renovation;
	}
	
	public void setRenovation(boolean renovation)
	{
		this.renovation = renovation;
	}

}
