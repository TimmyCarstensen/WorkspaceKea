package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * 
 * @author Timmy Carstensen
 *
 */
public class RecursionExamples 
{
	static Scanner input;

	/**
	 * 
	 */
	public RecursionExamples()
	{
		try {
			input = new Scanner(new File("this is fun"));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found!");
		}
	}

	public static void main(String args[])
	{
		writeStars(27);

		System.out.println(FactorialDummy(10, 5));

		RecursionExamples re = new RecursionExamples();
		re.reverse(input);

		System.out.println(gcd(20, 132));

		// DirectoryCrawler uses print(f, level)
		Scanner console = new Scanner(System.in);
		System.out.println("Directory or file name?");
		String name = console.nextLine();
		File f = new File(name);
		if(!f.exists())
			System.out.println("No such file/directory");
		else
		{ 
			printDirectory_File(f,0);

		}
	}

	public static void printDirectory_File (File f, int level)
	{
		try{
			for(int i = 0; i < level; i++)
				System.out.print("    ");
			System.out.println(f.getName());
			if(f.isDirectory())
			{
				for(File subF : f.listFiles())
				{
					printDirectory_File(subF, level + 1);
				}
			}
		}catch (NullPointerException e)
		{
			return;
		}
	}

	// Make use of sum(list, index) which is a helper method.
	public int sum(int[] list){ return sum(list, 0);}
	
	// helper method to sum(list) - sum with one parameter
	private int sum(int[] list, int index)
	{
		if (index == list.length)
			return 0;
		else 
			return list[index] + sum (list, index + 1);
	}
	
	// Tricky but smaaaart!!!
	public void reverse(Scanner input)
	{
		if(input.hasNextLine())
		{
			// Recursive case (nonempty file)
			String line = input.nextLine();
			reverse(input);
			System.out.println(line);
		}
	}


	/**
	 * eksempel fra bogen, cap. 12 p. 747
	 * @param n
	 */
	public static void writeStars(int n)
	{
		if(n == 0)
			System.out.println();
		else if(n % 11 == 0){
			System.out.println();
			writeStars(n-1);
		}else{
			System.out.print("*");
			writeStars(n - 1);
		}
	}

	/**
	 * Pre : y >= 0
	 * Post : returns x^y
	 * @param x
	 * @param y
	 * @return
	 */
	public static int FactorialDummy(int x, int y)
	{	
		if(y < 0)
			throw new IllegalArgumentException("Negative exponent: " + y);
		else if(y == 0)
			return 1;
		else if (y % 2 == 0)
		{
			// recursive case with y > 0 and y even
			return FactorialDummy(x * x, y / 2);
		} else
			return x * FactorialDummy(x, y - 1);
	}

	/**
	 * pre: x >= 0, y >= 0, x >= y
	 * Post: returns the greatest common divisor of x and y
	 * @return
	 */
	public static int gcd(int x, int y)
	{
		if(x < 0 || y < 0)
			// recursive case with negative values(s)
			return gcd(Math.abs(x), Math.abs(y));
		if(y == 0)
			// base case with y == 0
			return x;
		else 
			// recursive case with y > 0
			return gcd(y, x % y);
	}
}
