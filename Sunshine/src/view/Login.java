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
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton loginbutton = new JButton("Login");
	private JPanel panel = new JPanel();
	private JTextField username = new JTextField(15);
	private JPasswordField password = new JPasswordField(15);
	private JLabel userlabel, passlabel;

	/**
	 * Laver gui til login
	 */
	public Login()
	{
		super("Login Autentification");
		setSize(300,180);
		setLocation(500,280);
		this.panel.setLayout (null);
		this.panel.setBackground(Color.DARK_GRAY);

		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					actionLogin();
				}			
			}
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					actionLogin();
				}			
			}
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					actionLogin();
				}			
			}
		});

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
		this.password.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					actionLogin();
				}	
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});

		this.panel.add(loginbutton);
		this.panel.add(userlabel);
		this.panel.add(username);
		this.panel.add(passlabel);
		this.panel.add(password);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


		this.loginbutton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				actionLogin();
			}
		});

		this.username.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0) {username.setText("");}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}

		});
	}

	/**
	 * 
	 */
	public void actionLogin()
	{
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
	
}
