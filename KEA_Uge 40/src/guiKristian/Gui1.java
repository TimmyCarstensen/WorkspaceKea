package guiKristian;
import javax.swing.JOptionPane;


public class Gui1 {


	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog(null, "What is your name?");
		
		int choice = JOptionPane.showConfirmDialog(null,  "Do you like cake, " + name + "?");
		
		if (choice == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null,  "Of course! Who doesn't?");
		}
		else
		{
			JOptionPane.showMessageDialog(null,  "We'll have to agree to disagree.");
		}

	}

}
