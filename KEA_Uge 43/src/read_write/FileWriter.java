package read_write;

import java.io.*;

public class FileWriter {

	public void writeFile(String input, String fileName)
	{
		try {
			File myFile = new File(fileName);
			FileOutputStream fos = new FileOutputStream(myFile, true);
			PrintStream output = new PrintStream(fos);

			output.print(input);
			output.println();
			output.close(); //remember to close

		} catch (IOException e) {
			//handle an exception by telling the user that something went wrong.
			System.out.println("Something went wrong!");
		}
	}

	public void deleteFile(String fName)
	{
		{
			String fileName = fName;
			// A File object to represent the filename
			File f = new File(fileName);
			// Make sure the file or directory exists and isn't write protected
			if (!f.exists())
				throw new IllegalArgumentException("Delete: no such file or directory: " + fileName);
			if (!f.canWrite())
				throw new IllegalArgumentException("Delete: write protected: " + fileName);
			// If it is a directory, make sure it is empty
			if (f.isDirectory()) {
				String[] files = f.list();
				if (files.length > 0)
					throw new IllegalArgumentException("Delete: directory not empty: " + fileName);
			}
			// Attempt to delete it
			boolean success = f.delete();
			if (!success)
				throw new IllegalArgumentException("Delete: deletion failed");
		}
	}

	public static String addPerson(String name, int age, int height)
	{
		String allAttributes = name + " " + age + " " + height;
		return allAttributes;
	}

	public static void main(String[] args) 
	{
		FileWriter f = new FileWriter();
		f.deleteFile("hej.txt");
		f.writeFile(addPerson("simon", 23, 183), "hej.txt");
		f.writeFile(addPerson("niels", 21, 174), "hej.txt");
		f.writeFile(addPerson("lars", 22, 179), "hej.txt");
	}
}