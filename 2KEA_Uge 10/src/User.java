
public class User implements Runnable{

//	public int number;
	
	public User(int talley)
	{
//		number = talley;
		Thread t = new Thread(this);
		t.start();
	}

	
	public void run() 
	{
		for(int i = 0; i < 50; i++)
		{
		TestRessource.talley = TestRessource.talley + 1;
		
		System.out.println("Number: " + TestRessource.talley);
		}
	}
	
}
