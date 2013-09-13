
/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Locomotive 
{
	private Cart firstCart;
	private String name;
	
	public Locomotive(String name)
	{
		this.name = name;
	}
	
	public void deleteNode(int number)
	{
		// find cart objektet "før" den vi vil slette
		// sat dens "nextcart" til "nextcart.nextcart"
		if(number == 1)
			this.firstCart = firstCart.getNextCart();
		else if(number > 1  && number <= size())
			this.firstCart.removeCart(number - 1);
		else
			System.out.println("Cart doesn't exists!");
	}
	
	// returnere antallet af vogne
	public int size()
	{
		if(firstCart != null)
			return firstCart.size(1);
		else
			return 0;
	}
	
	public void printTrain()
	{
		System.out.println(getName());
		firstCart.print();
	}
	
	public void setFirstCart(Cart newFirstCart)
	{
		this.firstCart = newFirstCart;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
