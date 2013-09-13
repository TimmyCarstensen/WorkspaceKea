
public class Run {
	
	public static void main(String[] args)
	{
		Locomotive loc = new Locomotive("locomotive");
		Cart c1 = new Cart("A");
		Cart c2 = new Cart("B");
		Cart c3 = new Cart("C");
		Cart c4 = new Cart("D");
		Cart c5 = new Cart("E");
		Cart c6 = new Cart("F");
		
		
		
		loc.setFirstCart(c1);
		c1.setNextCart(c2);
		c2.setNextCart(c3);
		c3.setNextCart(c4);
		c4.setNextCart(c5);
		c5.setNextCart(c6);
		
		System.out.println("Train with no deletes");
		loc.printTrain();
		System.out.println("Number of Carts: " + loc.size());
		
		loc.deleteNode(5);
		System.out.println("Delete Cart in middle");
		System.out.println("First train version:");
		loc.printTrain();
		System.out.println("Number of Carts: " + loc.size());
		
		loc.deleteNode(5);
		System.out.println("Delete last Cart.");
		System.out.println("Second train version:");
		loc.printTrain();
		System.out.println("Number of Carts: " + loc.size());
	}
}
