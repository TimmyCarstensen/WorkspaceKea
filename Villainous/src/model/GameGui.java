package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameGui extends JFrame implements ActionListener{

	
	private JPanel panel;
	private double chapter;
	private ImageIcon frank;
	private JLabel imageLabel;
	private JTextArea textArea;
	private JButton a, b, c, d;
	private JTextField enemyHp, enemyWeapon, enemySpecial;
	
	
	public GameGui()
	{
		
		
		/*
		 * Basic Layout setup:
		 */
		
		setSize( 1110, 800 );
		setTitle("Villanous");
		setDefaultCloseOperation(3);
		setLocation(300, 200);
		
		panel = new JPanel(null);
		
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		
		/*
		 * Objects of components are created:
		 */
		
		this.textArea = new JTextArea();
		
		this.imageLabel = new JLabel();
		this.frank = new ImageIcon("pictures/characters/frank/Frank.jpg");
		
		this.a = new JButton("A");
		this.b = new JButton("B");
		this.c = new JButton("C");
		this.d = new JButton("D");
		
		this.enemyHp = new JTextField("HP:");
		this.enemyWeapon = new JTextField("Weapon:");
		this.enemySpecial = new JTextField("Special:");
		
		
		//textArea added to JFrame:
		textArea.setLocation(30,60);
		textArea.setSize(600,400);
		getContentPane().add(textArea);
		
		//ImageLabel added to JFrame:
		imageLabel.setLocation(760, 60);
		imageLabel.setSize(300, 300);
		getContentPane().add(imageLabel);
		
		//Button A added to JFrame:
		a.setLocation(30, 480);
		a.setSize(280, 50);
		getContentPane().add(a);
		
		//Button B added to JFrame:
		b.setLocation(350, 480);
		b.setSize(280, 50);
		getContentPane().add(b);
		
		//Button C added to JFrame:
		c.setLocation(30, 550);
		c.setSize(280, 50);
		getContentPane().add(c);
		
		//Button D added to JFrame:
		d.setLocation(350, 550);
		d.setSize(280, 50);
		getContentPane().add(d);
		
		//enemyHP field added to JFrame:
		enemyHp.setLocation(760, 380);
		enemyHp.setSize(250, 30);
		getContentPane().add(enemyHp);
		
		//enemyWeapon field added to JFrame:
		enemyWeapon.setLocation(760, 420);
		enemyWeapon.setSize(250, 30);
		getContentPane().add(enemyWeapon);
		
		//enemySpecial field added to JFrame:
		enemySpecial.setLocation(760, 460);
		enemySpecial.setSize(250, 30);
		getContentPane().add(enemySpecial);
		
		loadChapter();
		setVisible(true);
		
		
		/*
		 * Actionlisteners are added:
		 */
		
		this.a.addActionListener(this);
		this.b.addActionListener(this);
		this.c.addActionListener(this);
		this.d.addActionListener(this);
	
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void loadChapter()
	{
		this.chapter = 0;
		
		//If chapter is 0:
		if(chapter == 0)
		{
			textArea.setText("This is chapter 0");
			imageLabel.setIcon(frank);
			
		}
		
		else if(chapter == 1)
		{
			textArea.setText("This is chapter 1");
		}
		
	}

}
