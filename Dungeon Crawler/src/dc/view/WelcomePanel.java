//lqp693
package dc.view;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WelcomePanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JLabel regeneration, magnitude;
	private ButtonGroup buttonGroup;
	private JRadioButton warriorButton, clericButton, mageButton;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public WelcomePanel(MainFrame mainFrame) 
	{
		this.mainFrame = mainFrame;
		setLayout(null);

		JLabel titel = new JLabel("DUNGEON CRAWLER!!!");
		titel.setFont(new Font("Tahoma", Font.BOLD, 20));
		titel.setBounds(177, 11, 235, 36);
		add(titel);

		// ExplainGameText used to be a JTextArea and not a JTextPane.
		JTextPane explainGameText = new JTextPane();
		// Next 3 lines only works on JTextPane.
		SimpleAttributeSet attribs = new SimpleAttributeSet();  
		StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER); 
		explainGameText.setParagraphAttributes(attribs,true);
 
		explainGameText.setEditable(false);
		explainGameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		explainGameText.setBackground(UIManager.getColor("Panel.background"));
		explainGameText.setBounds(100, 73, 380, 200);
		explainGameText.setText("Velkommen til Dungeon Crawler!\r\n\r\nV\u00E6lg en Helt, og skriv dit navn.\r\n\r\nTryk derefter p\u00E5 \"start the game\"");
//		explainGameText.;
		add(explainGameText);

		textField = new JTextField();
		textField.setBounds(208, 285, 230, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblHero = new JLabel("Hero name:");
		lblHero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHero.setBounds(110, 285, 74, 20);
		add(lblHero);

		// regeneration / magnitude.
		regeneration = new JLabel("regeneration: ?");
		regeneration.setFont(new Font("Tahoma", Font.BOLD, 15));
		regeneration.setBounds(206, 344, 191, 19);
		add(regeneration);

		magnitude = new JLabel("magnitude: ?");
		magnitude.setFont(new Font("Tahoma", Font.BOLD, 15));
		magnitude.setBounds(206, 370, 191, 19);
		add(magnitude);

		addRadioButton();

		startButton();
	}
	public void addRadioButton()
	{
		// Radiobuttons with actionlisteners.
		warriorButton = new JRadioButton("Warrior");
		warriorButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				regeneration.setText("Regeneration: 5");
				magnitude.setText("Magnitude: 3");
			}
		});
		warriorButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		warriorButton.setBounds(32, 342, 100, 25);
		add(warriorButton);

		clericButton = new JRadioButton("Cleric");
		clericButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				regeneration.setText("Regeneration: 20");
				magnitude.setText("Magnitude: 1");
			}
		});
		clericButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clericButton.setBounds(32, 368, 100, 25);
		add(clericButton);

		mageButton = new JRadioButton("Mage");
		mageButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				regeneration.setText("Regeneration: 10");
				magnitude.setText("Magnitude: 2");
			}
		});
		mageButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		mageButton.setBounds(32, 394, 100, 25);
		add(mageButton);
		
		// Grouping radiobuttons together.
		buttonGroup = new ButtonGroup();
		buttonGroup.add(warriorButton);
		buttonGroup.add(clericButton);
		buttonGroup.add(mageButton);

		warriorButton.doClick();
	}

	
	public  void startButton()
	{
		JButton btnNewButton = new JButton("Start the game");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String heroType = "";
				if(buttonGroup.isSelected(warriorButton.getModel()))
				{
					heroType = "warrior";
				}else if(buttonGroup.isSelected(mageButton.getModel()))
				{
					heroType = "mage";
				}else if(buttonGroup.isSelected(clericButton.getModel()))
				{
					heroType = "cleric";
				}
				String name = textField.getText(); 
				if(name.equals(""))
					name = "Gazuuk";
				mainFrame.choseHero(heroType, name);
				mainFrame.startGamePanel();
			}
		});
		btnNewButton.setBounds(416, 343, 136, 25);
		add(btnNewButton);

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{

	}
}
