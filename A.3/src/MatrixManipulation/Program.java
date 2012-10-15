package MatrixManipulation;

import java.util.Scanner;

import java.util.HashMap;

/**
 * 
 */
public class Program{
	private HashMap<String, Matrix> matricer;
	/**
	 * MAIN FÆRDIG, MANGLER KOMMENTARER!!!
	 * @param args
	 */
	public static void main(String[] args)
    {
    	new Program();
    }
	
    private Scanner reader;
	
    /**
     * PROGRAM IKKE FÆRDIG, MANGLER KOMMENTARER
     */
	public Program()
    {
		matricer = new HashMap<String, Matrix>();
		reader = new Scanner(System.in);
		// Matrix mat = new Matrix(5);
		// mat.create(5);
		// mat.printMatrix();
		start();
    }
	
	/**
	 * START IKKE FÆRDIG, MANGLER KOMMENTARER
	 */
	public void start()
	{
		System.out.println("Welcome to Matrix program!");
		System.out.println("Enter 'quit' to exit!");
		System.out.println("What would you like to do?");
		System.out.print("> ");
		boolean quit = true;
		
		while(quit){
			String inputLine = reader.nextLine().trim().toLowerCase();
			String[] define_NAME = inputLine.split(" ");
			if(define_NAME[0].equals("define")) // navnet efter define giver problem!!!
			{
				
				System.out.println("How do you want to define the matrix?");
				System.out.print("> ");	
				
				String defineMatrix = reader.nextLine().trim().toLowerCase();
				
				if(defineMatrix.equals("diagonal")){
					System.out.println("What size do you want it?");
					System.out.print("> ");
					
					int intSize = reader.nextInt();
					matricer.put(define_NAME[1], new Matrix(intSize));
					
					System.out.println("What value do you want?");
					System.out.print("> ");
					
					int intValue = reader.nextInt();
					matricer.get(define_NAME[1]).diagonalCreate(intValue);
					printDone();
					
				}else if(defineMatrix.equals("manual")){
					
				}
				
			}else if(define_NAME[0].equals("transpose")){
				matricer.get(define_NAME[1]).transpose();
			}else if(define_NAME[0].equals("print")){
				matricer.get(define_NAME[1]).printMatrix();
				printDone();
			}else if(define_NAME[0].equals("multiply")){
				
			}else if(define_NAME[0].equals("quit")){
				break;
				
			}
			
		}
		System.out.print("Thank you for now! Hope it was useful!");
	}
	
	public void printDone()
	{
		System.out.println("Done.");
		System.out.println();
		System.out.print("> ");
	}
	/**
	 * MANUAL IKKE FÆRDIG, MANGLER KOMMENTARER!!!
	 * Skal lave en manual matrix
	 */
	public void manual()
	{
		
	}
	
	/**
	 * GETROW IKKE FÆRDIG, IKKE SIKKER PÅ OM JEG SKAL BRUGE DENNE!!!
	 * @return
	 */
	public int[] getRow() 
    {
        System.out.print("> ");                // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase();

        String[] stringArray = inputLine.split(" "); // split at spaces!
        int value = 0;
        int[] intArray = new int[stringArray.length];
        while(value < stringArray.length){
        	intArray[value] = Integer.parseInt(stringArray[value]);
        	value++;
        }
        return intArray;
        
    }  
}