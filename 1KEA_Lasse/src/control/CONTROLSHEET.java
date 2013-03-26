package control;

//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;

public class CONTROLSHEET
{
	public int convertAge(String a)
	{
		int age = 0;
		try
		{
			age = Integer.parseInt(a);
		}
		catch (Exception e)
		{
			return -1;
		}

		return age;
	}

	public double convertHeight(String a)
	{

		double height = 0.0;
		try
		{
			height = Double.parseDouble(a);
		}
		catch (Exception e)
		{

			return -1.0D;
		}

		return height;
	}

	public double convertWeight(String a)
	{
		double weight;
		try
		{
			weight = Double.parseDouble(a);
		}
		catch (Exception e)
		{
			return -1.0D;
		}

		return weight;
	}

	public void writeCharFile(String name, int age, String gender, String house, double height, double weight, String eye, String hair, String mannerisms, String features, String story)
	{
		File file = new File("Character.txt");
		String content = name + age + gender + house + height + weight + eye + hair + mannerisms + features + story;
 
			try (FileOutputStream fop = new FileOutputStream(file)) 
			{
			// if file doesn't exists, then create it
			if (!file.exists()) 
			{
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			} 
			catch (IOException e) 
			{
			e.printStackTrace();
			}
	}
	
//	public void writeCharFile(String name, int age, String gender, String house, double height, double weight, String eye, String hair, String mannerisms, String features, String story) 
//	{
//		try {
//			File file = new File("Character.txt");
//			if(!file.exists())
//				file.createNewFile();
//			FileWriter fw = new FileWriter(file);
//			BufferedWriter out = new BufferedWriter(fw);
//			String content = name + age + gender + house + height + weight + eye + hair + mannerisms + features + story;
//			out.write(content);
//			out.close();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
}
