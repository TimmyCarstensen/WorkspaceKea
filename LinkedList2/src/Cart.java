/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Cart 
{
	private Cart nextCart;
	private String name;
	
	public Cart(String name)
	{
		this.name = name;
	}

	public void print()
	{
		System.out.println(name);
		
		if (nextCart != null)
			nextCart.print();
	}
	
	public void removeCart(int count)
	{
		if(count == 1)
			this.nextCart = nextCart.getNextCart();
		else if(nextCart.getNextCart() == null)
		{
			this.nextCart = null;
		} else
			nextCart.removeCart(count - 1);
	}
	
	public int size(int counter)
	{
		if(nextCart != null)
			return nextCart.size(counter + 1);
		else
			return counter;
	}
	
	
	public void setNextCart(Cart nextCart)
	{
		this.nextCart = nextCart;
	}
	
	public Cart getNextCart()
	{
		return this.nextCart;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}
