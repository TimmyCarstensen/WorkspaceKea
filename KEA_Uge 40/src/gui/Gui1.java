package gui;

import javax.swing.JOptionPane;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Gui1 {

	private static String name, mothersName, fathersName, petType, girlfriendName, yesGirlfriend;
	private static int age;
	private static int choice;
	private static boolean likeFootball;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		name = JOptionPane.showInputDialog(null, "What is your name?");
		mothersName = JOptionPane.showInputDialog(null, "What is your mothers name?");
		fathersName = JOptionPane.showInputDialog(null, "What is your fathers name?");
		String tempAge = JOptionPane.showInputDialog(null, "What is your age?");
		age = Integer.parseInt(tempAge);

		choice = JOptionPane.showConfirmDialog(null,  "Do you have a pet, " + name + "?");
		
		if (choice == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null,  "Of course! Who doesn't? What type of pet do you got?");
		}
		else
		{
			JOptionPane.showMessageDialog(null,  "I would recommend a snake, since it doesn't smell");
		}
		
		petType = JOptionPane.showInputDialog(null, "What type of pet do you got?");
		
		
		choice = JOptionPane.showConfirmDialog(null,  "Do you like football, " + name + "?");
		
		if (choice == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null,  "Of course! Who doesn't?");
			likeFootball = true;
		}
		else
		{
			JOptionPane.showMessageDialog(null,  "We'll have to agree to disagree.");
			likeFootball = false;
		}
		
		choice = JOptionPane.showConfirmDialog(null,  "Do you have a girlfriend, " + name + "?");
		
		if (choice == JOptionPane.YES_OPTION) {
			girlfriendName = JOptionPane.showInputDialog(null,  "What is her name?");
			yesGirlfriend = "Yes and she is very hot!";
		}
		else
		{
			JOptionPane.showMessageDialog(null,  "Too bad for you!");
			yesGirlfriend = "yeah, i know i suck! I'm working on it!";
		}
		
		JOptionPane.showMessageDialog(null, 
				"Your name is: " + name + 
				"\nYour mothers name is: " + mothersName +
				"\nYour fathers name is: " + fathersName + 
				"\nYour age is: " + age + 
				"\nYour pets type is: " + petType + 
				"\nYou like football: " + likeFootball + 
				"\nDo you have a girl friend? Your answer was: " + yesGirlfriend);
		
		
	}
	
	
}
