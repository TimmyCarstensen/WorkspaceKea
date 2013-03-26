import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Timmy Carstensen
 *
 */


public class Main extends JFrame{

	public static void main(String args[])
	{
		new Main();
	}
	
	public Main() 
	{
		setSize(300, 300);
		System.out.println(addition(4, 5));
		
		JButton newButton = new JButton("click me for addition");
		newButton.setBounds(10, 10, 180, 30);
		newButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		JTextField a = new JTextField();
		a.setBounds(10, 80, 180, 30);

		JTextField b = new JTextField();
		b.setBounds(10, 130, 180, 30);
		
		JLabel label = new JLabel("hej Dede");
		label.setBounds(10, 180, 180, 30);
		
		JPanel contentPane = new JPanel(null);
		setContentPane(contentPane);
		
		contentPane.add(newButton);
		contentPane.add(a);
		contentPane.add(b);
		setVisible(true);
	}
	
	public int addition(int a, int b)
	{
		return a + b;
	}
	
}
