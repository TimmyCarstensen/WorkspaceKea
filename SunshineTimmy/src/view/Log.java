package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame {

//	public static void main(String[] args) {
//		Log frameTabel = new Log();
//	}

	private JButton loginbutton = new JButton("Login");
	private JPanel panel = new JPanel();
	private JTextField username = new JTextField(15);
	private JPasswordField password = new JPasswordField(15);

	public Log(){
		super("Login Autentification");
		setSize(300,200);
		setLocation(500,280);
		panel.setLayout (null); 

		this.username.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						username.setText("");
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		username.setBounds(70,30,150,20);
		password.setBounds(70,65,150,20);
		loginbutton.setBounds(110,100,80,20);

		username.setText("Username");
		password.setText("");

		panel.add(loginbutton);
		panel.add(username);
		panel.add(password);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}

	
	public void actionlogin(){
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String uname = username.getText();
				String upassword = password.getText();

				if(uname.equals("Sunshine") && upassword.equals("12345")) {

					Main cottagesystem = new Main();
					cottagesystem.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
					//username.setText("Username here!");
					//password.setText("");
					//username.requestFocus();
				}

			}
		});
	}
}
