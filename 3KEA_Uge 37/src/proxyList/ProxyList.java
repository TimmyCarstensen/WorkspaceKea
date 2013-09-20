package proxyList;

public class ProxyList extends java.awt.List implements IProxyList 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProxyList (){
		
	}

	@Override
	public void add(String T) 
	{
		add(T);
	}

	@SuppressWarnings("finally")
	@Override
	public void remove(String T) 
	{
		String msg = "";
		try {remove(T);} 
		catch(Exception e) {msg = "You can't remove non-existing item";} 
		finally {return;}
	}

	public void remove(int index) {
		if (getItemCount()>index && index>=0) remove(index);
		}

	public String getItem(int index) 
	{
		return getItem(index);    
	}

	public void clearList()
	{
		removeAll();    
	}

	public String[] getAll() 
	{
		return getItems();    
	}
}
