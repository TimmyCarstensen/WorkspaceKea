package proxyList;

public interface IProxyList {
	public void add(String T);
	public String remove(String T);
	public void remove (int index);
	public String getItem(int index);  
	public void clearList();
	public String[] getAll();
}
