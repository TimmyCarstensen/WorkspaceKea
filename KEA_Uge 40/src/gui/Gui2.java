package gui;
import javax.swing.JOptionPane;


public class Gui2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String ageText = JOptionPane.showInputDialog(null, "How old are you?");
		int age = 0;
		age = Integer.parseInt(ageText);
				
		String moneyText = JOptionPane.showInputDialog(null, "How much money do you have?");
		
		double money = Double.parseDouble(moneyText);
		
		JOptionPane.showMessageDialog(null,  "If you can double your money each year,\n"+"You'll have " + (money * 32) + "kr at age " + (age + 5) + "!");
	}
}