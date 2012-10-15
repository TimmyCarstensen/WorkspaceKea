package Converter;


import java.io.IOException;

public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Converter c = new Converter();
		c.convert(c.readFromFile("DatoerFra_sms-20110823223747.txt"));
	}

}
