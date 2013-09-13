import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * steganography - william wilson
 * link: http://www.dreamincode.net/forums/topic/27950-steganography/
 */

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class HideMsgInPicture 
{
	final static long HEADSIZE = 120;

	public static void main(String[] args) 
	{
		// encode picture
		try 
		{
			// encode(Input picture, input text, output filename)
			encode("Timmy.jpg", "Timmytekst.txt", "TimmyX.jpg");
		} 
		catch (IOException e) 
		{
			System.out.println("Failed somewhere while trying to encode!");
		}
		
		// Decode picture
		try 
		{
			// decode (input picture, output filename for text)
			decode("TimmyX.jpg", "TimmytekstX.txt");
		} 
		catch (IOException e) 
		{
			System.out.println("Failed somewhere while trying to decode");
		}
	}

	private static void encode(String inputPicture, String messageText, String outputPicture) throws IOException
	{
		FileInputStream input = null;
		FileInputStream message = null;
		FileOutputStream output = null;

		try
		{
			
			input = new FileInputStream(inputPicture);
			message = new FileInputStream(messageText);
			output = new FileOutputStream(outputPicture);
			int c, mb;
			byte clearBit1 = (byte) 0xFE; //254; // 11111110

			for(int i = 1; i < HEADSIZE; i++) output.write(input.read()); // copy header

			while((mb = message.read()) != -1) // for all bytes in a message
			{
				for (int bit = 7; bit >= 0; bit--) // 1 bit a time from message
				{
					c = input.read() & clearBit1;     // get picturebyte, clear last bit
					c = (c | ((mb >> bit) & 1));   // put msg-bit in end of pic-byte
					output.write(c);                  // add pic-byte in new file
				}
			}

			for(int bit = 7; bit >= 0; bit--) // add 8 zeroes as stop-byte of msg
			{
				c = input.read() & clearBit1; // get picturebyte, clear last bit
				output.write(c); // add pic-byte in new file
			}

			while ((c = input.read()) != -1) output.write(c); // copy rest of file
		} 
		finally
		{
			if(input  != null)  input.close();
			if(message != null) message.close();
			if(output != null) output.close();
		}
	}

	/**
	 * 
	 * @param inText
	 * @param outText
	 * @throws IOException
	 * 
	 * @author Timmy Carstensen
	 */
	private static void decode(String inText, String outText) throws IOException
	{
		FileInputStream inputPicture = null;
		FileOutputStream outputText = null;

		try
		{
			inputPicture = new FileInputStream(inText); // encoded picture
			outputText = new FileOutputStream(outText); // decoded output text
			
			int letter, tempByte;
			letter = 0;			
			for(int i = 1; i < HEADSIZE; i++) inputPicture.read(); // copy header

			while(true) // for all bytes in a message
			{
				for(int bit = 7; bit >= 0; bit--) // 1 bit a time from message
				{
					tempByte = inputPicture.read(); // read in byte
					letter = letter | ((tempByte & 1) << bit); // get the bit, shift it and put it together in the variable letter.
				}
				if(letter == 0)
					break;
	
				outputText.write(letter); // one byte at a time is written to the file.
				
				letter = 0;
			}			
		}
		finally
		{
			if(inputPicture  != null)  inputPicture.close(); // file is closed
			if(outputText != null) outputText.close(); // file is closed
		}
	}
}