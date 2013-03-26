import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Timmy Carstensen
 *
 */

public class Main 
{
	private Integer[] org = {1, 21, 2, 4, 32, 3, 2, 4, 5, 4, 2, 65, 343, 43, 33, 23, 1,
			32, 3,2 ,34, 2, 34 ,25 ,45 ,345 ,345, 345 ,43,3,23,25,2,5,25,43,
			54,35,345,3,24,6,34523,6,54,5,43,45,3,4345,345,354,43,23,45,3,45,
			245,53,345,435,43,34,53,543,543, 1, 21, 2, 4, 32, 3, 2, 4, 5, 4, 2,
			65, 343, 43, 33, 23, 1, 32, 3,2 ,34, 2, 34 ,25 ,45 ,345 ,345, 345,
			43,3,23,25,2,5,25,43, 54,35,345,3,24,6,34523,6,54,5,43,45,3,4345,
			345,354,43,23,45,3,45, 245,53,345,435,43,34,53,543,543, 1, 21, 2,
			4, 32, 3, 2, 4, 5, 4, 2, 65, 343, 43, 33, 23, 1, 32, 3,2 ,34, 2, 34
			,25 ,45 ,345 ,345, 345 ,43,3,23,25,2,5,25,43, 54,35,345,3,24,6,34523,
			6,54,5,43,45,3,4345,345,354,43,23,45,3,45, 245,53,345,435,43,34,53,
			543,543, 1, 21, 2, 4, 32, 3, 2, 4, 5, 4, 2, 65, 343, 43, 33, 23, 1,
			32, 3,2 ,34, 2, 34 ,25 ,45 ,345 ,345, 345 ,43,3,23,25,2,5,25,43,
			54,35,345,3,24,6,34523,6,54,5,43,45,3,4345,345,354,43,23,45,3,45,
			245,53,345,435,43,34,53,543,543};
	private HashSet<Integer> set1;
	private HashSet<String> set2;
	private HashSet<String> set3;
	private HashMap<Integer, Person> map1;
	
	public static void main(String[] args)
	{
		new Main();
	}

	public Main()
	{
		System.out.println("Amount of numbers: " + this.org.length);
		
		differentNumbers();
		
		resetSets();

		// Prints all elements of both sets
		totalElements(set2, set3);

		// Difference: 
		// Default removeElements(A, B) gives set of all elements that are in A but not in B.		
		removeElements(set2, set3);
		removeElements(set3, set2);
		
		demoHashMap();
	}

	public void differentNumbers()
	{
		set1 = new HashSet<Integer>(Arrays.asList(org));
		System.out.println("Different numbers: " + set1.size());
	}
	
	public void resetSets()
	{
		this.set2 = new HashSet<String>();
		set2.add("Berit");
		set2.add("Jens");
		set2.add("Per");
		set2.add("Anna");

		this.set3 = new HashSet<String>();
		set3.add("Berit");
		set3.add("Hans");
		set3.add("Per");
		set3.add("Helle");
	}


	public void totalElements(HashSet<String> set1, HashSet<String> set2)
	{
		set1.addAll(set2);
		System.out.println("Total Elements: " + set1.toString());
		resetSets();
	}

	public void removeElements(HashSet<String> set1, HashSet<String> set2)
	{
		set1.removeAll(set2);
		System.out.println("Remove Elements: " + set1.toString());
		resetSets();
	}

	public void demoHashMap()
	{
		Person p1 = new Person("Kasper", 25, 51425152);
		Person p2 = new Person("Jens", 41, 51232142);
		Person p3 = new Person("Helle", 53, 21599884);
		Person p4 = new Person("Katrine", 32, 41928388);
		
		this.map1 = new HashMap<Integer, Person>();
		map1.put(24123451, p1);
		map1.put(24251622, p2);
		map1.put(36662355, p3);
		map1.put(47277773, p4);
		
		System.out.println("Udprint af personer i et HashMap via deres telefonnummer: [" + map1.get(24123451).getName() + ", " + map1.get(24251622).getName() + 
				", " + map1.get(36662355).getName() + ", " + map1.get(47277773).getName() + "]");
	}
}