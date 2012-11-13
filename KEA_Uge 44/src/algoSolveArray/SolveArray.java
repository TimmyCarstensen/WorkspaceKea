package algoSolveArray;

public class SolveArray {

	private int[] liste;
	
	public SolveArray(int[] liste){
		this.liste = liste;
	}
	
	public int[] solve()
	{
		int i = 0;
		int[] listeTemp = new int[liste.length];
		for(int itemA : liste)
		{
			int temp = itemA;
			if(temp < itemA)
			{
				listeTemp[i] = temp;
			}
			i++;
		}
		this.liste = listeTemp;
		
		
		i = 0;
		for(int item: liste)
		{
			System.out.println("Plads " + i + " står item: " + item);
			i++;
		}
		return liste;
	}
	
}
