package proxyList;

import java.awt.List;

public class ProxyList implements IProxyList 
{
	private List AList = new List();

	@Override
	public void add(String T) 
	{
		AList.add(T);
	}

	@SuppressWarnings("finally")
	@Override
	public String remove(String T) 
	{
		String msg = "";
		try {AList.remove(T);} 
		catch(Exception e) {msg = "You can't remove non-existing item";} 
		finally {return msg;}
	}

	public void remove(int index) {
		if (AList.getItemCount()>index && index>=0) AList.remove(index);
		}

	public String getItem(int index) 
	{
		return AList.getItem(index);    
	}

	public void clearList()
	{
		AList.removeAll();    
	}

	public String[] getAll() 
	{
		return AList.getItems();    
	}
}
