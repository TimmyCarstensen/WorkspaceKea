package view;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

/**
 * 
 * @author Matias
 *
 */
public class Log extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton loginbutton = new JButton("Login");
	private JPanel panel = new JPanel();
	private JTextField username = new JTextField(15);
	private JPasswordField password = new JPasswordField(15);
	private JLabel userlabel, passlabel;

	/**
	 * Laver gui til login
	 */
	public Log()
	{
		super("Login Autentification");
		setSize(300,180);
		setLocation(500,280);
		this.panel.setLayout (null);
		this.panel.setBackground(Color.DARK_GRAY);

		this.userlabel = new JLabel("Username: ");
		this.userlabel.setForeground(Color.WHITE);
		this.passlabel = new JLabel("Password: ");
		this.passlabel.setForeground(Color.WHITE);

		this.username.setBounds(70,30,150,20);
		this.password.setBounds(70,70,150,20);
		this.userlabel.setBounds(70,15,85,10);
		this.passlabel.setBounds(70,45,85,30);
		this.loginbutton.setBounds(110,100,80,20);

		this.username.setText("");
		this.password.setText("");

		this.panel.add(loginbutton);
		this.panel.add(userlabel);
		this.panel.add(username);
		this.panel.add(passlabel);
		this.panel.add(password);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();

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
	}
	
	/**
	 * 
	 */
	public void actionlogin(){
		this.loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String uname = username.getText();
				@SuppressWarnings("deprecation")
				String upassword = password.getText();

				if(uname.equals("sunshine") && upassword.equals("1234")) {

					Main cottagesystem = null;
					try {
						cottagesystem = new Main();
					} catch (IOException e) {
						e.printStackTrace();
					}
					cottagesystem.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
				}

			}
		});
	}
}
