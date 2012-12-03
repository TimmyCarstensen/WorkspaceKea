package view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Log extends JFrame {

//	public static void main(String[] args) throws IOException {
//		new Log();
//	}

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JLabel usernamelabel,passwordlabel;
	private JButton loginbutton;
	private JPanel panel;
	private JTextField username;
	private JPasswordField password;
	

	
	public Log() throws IOException{
		super("Login Autentification");
		setSize(300,200);
		setLocation(500,280);
		
		this.usernamelabel = new JLabel("Username");
		this.passwordlabel = new JLabel("Password");
		//this.loginbutton = new JButton("Login");
		this.panel = new JPanel(null);
		this.username = new JTextField();
		this.password = new JPasswordField();
		
		BufferedImage buttonIcon = ImageIO.read(new File("loginbutton.jpg"));
		loginbutton = new JButton(new ImageIcon(buttonIcon));
		loginbutton.setBorder(BorderFactory.createEmptyBorder());
		loginbutton.setContentAreaFilled(false);
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
		
		username.setBounds(100,30,150,20);
		usernamelabel.setBounds(30,30,100,20);
		password.setBounds(100,65,150,20);
		passwordlabel.setBounds(30, 65, 100, 20);
		//loginbutton.setBounds(135,100,80,20);
		loginbutton.setBounds(105,100,135,43);
		
		usernamelabel.setText("Username: ");
		passwordlabel.setText("Password: ");
		
		panel.add(loginbutton);
		panel.add(usernamelabel);
		panel.add(username);
		panel.add(passwordlabel);
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
				@SuppressWarnings("deprecation")
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
