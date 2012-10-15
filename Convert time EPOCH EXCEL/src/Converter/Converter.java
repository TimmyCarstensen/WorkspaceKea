package Converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Converter {
	private String filename;
	public Converter(){
	
	}
	public BufferedReader readFromFile(String filename) throws FileNotFoundException{
		// fstream = filestream
		this.filename = filename;
		FileInputStream fstream = new FileInputStream(filename);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br; 
	}
	// convert the file with epoch numbers to a file with dates
	public void convert(BufferedReader br) throws IOException{
		BufferedWriter out = new BufferedWriter(new FileWriter("Converted - " + filename));
		Scanner s = new Scanner (br);
		long epoch = 0;
		String date = "";
		while (s.hasNextLong()){
			epoch = s.nextLong();
			date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch)); 
			date = date + "\n";
			out.write(date);
		}
		out.close();
	}	
	
	public void writeToFile(){
		
	}
}
