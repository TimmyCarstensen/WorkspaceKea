/*     */ package gui;
/*     */ 
/*     */ import control.CONTROLSHEET;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class GUI
/*     */   implements ActionListener
/*     */ {
	/*  25 */   CONTROLSHEET CONTROL = new CONTROLSHEET();
	/*     */   private JFrame createFrame;
	/*     */   private JPanel westPanel1;
	/*     */   private JPanel southPanel;
	/*     */   private JPanel southPanel1;
	/*     */   private JPanel northPanel;
	/*     */   private JLabel charNameLabel;
	/*     */   private JTextField charNameTxField;
	/*     */   private JLabel charAgeLabel;
	/*     */   private JTextField charAgeTxField;
	/*     */   private JLabel charGenderLabel;
	/*     */   private JTextField charGenderTxField;
	/*     */   private JLabel charHeightLabel;
	/*     */   private JTextField charHeightTxField;
	/*     */   private JLabel charWeightLabel;
	/*     */   private JTextField charWeightTxField;
	/*     */   private JLabel charEyeLabel;
	/*     */   private JTextField charEyeTxField;
	/*     */   private JLabel charHairLabel;
	/*     */   private JTextField charHairTxField;
	/*     */   private JLabel charMannerismsLabel;
	/*     */   private JTextArea charMannerismsTxArea;
	/*     */   private JLabel charFeaturesLabel;
	/*     */   private JTextArea charFeaturesTxArea;
	/*     */   private JLabel charHouseLabel;
	/*     */   private JTextField charHouseTxField;
	/*     */   private JLabel charStoryLabel;
	/*     */   private JTextArea charStoryTxArea;
	/*     */   private JButton createChar;
	/*     */   private URL dogUrl;
	/*     */   private Icon dogIcon;
	/*     */   private JLabel dogLabel;
	/*     */ 
	/*     */   public String getCharName()
	/*     */   {
		/*  95 */     return this.charNameTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharAge()
	/*     */   {
		/* 101 */     return this.charAgeTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharGender()
	/*     */   {
		/* 107 */     return this.charGenderTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharHouse()
	/*     */   {
		/* 113 */     return this.charHouseTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharHeight()
	/*     */   {
		/* 119 */     return this.charHeightTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharWeight()
	/*     */   {
		/* 125 */     return this.charWeightTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharEye()
	/*     */   {
		/* 131 */     return this.charEyeTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharHair()
	/*     */   {
		/* 137 */     return this.charHairTxField.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharMannerisms()
	/*     */   {
		/* 143 */     return this.charMannerismsTxArea.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharFeatures()
	/*     */   {
		/* 149 */     return this.charFeaturesTxArea.getText();
	/*     */   }
	/*     */ 
	/*     */   public String getCharStory()
	/*     */   {
		/* 156 */     return this.charStoryTxArea.getText();
	/*     */   }
	/*     */ 
	/*     */   public GUI()
			/*     */     throws MalformedURLException
			/*     */   {
		/* 162 */     this.createFrame = new JFrame("A Song of Ice and Fire: Character Creator");
		/*     */ 
		/* 165 */     this.charNameLabel = new JLabel("Name");
		/* 166 */     this.charNameTxField = new JTextField(5);
		/*     */ 
		/* 169 */     this.charAgeLabel = new JLabel("Age");
		/* 170 */     this.charAgeTxField = new JTextField(2);
		/*     */ 
		/* 173 */     this.charGenderLabel = new JLabel("Gender");
		/* 174 */     this.charGenderTxField = new JTextField(5);
		/*     */ 
		/* 177 */     this.charHeightLabel = new JLabel("Height (cm)");
		/* 178 */     this.charHeightTxField = new JTextField(5);
		/*     */ 
		/* 181 */     this.charWeightLabel = new JLabel("Weight (kg)");
		/* 182 */     this.charWeightTxField = new JTextField(5);
		/*     */ 
		/* 185 */     this.charEyeLabel = new JLabel("Eye Color");
		/* 186 */     this.charEyeTxField = new JTextField(5);
		/*     */ 
		/* 189 */     this.charHairLabel = new JLabel("Hair Color");
		/* 190 */     this.charHairTxField = new JTextField(5);
		/*     */ 
		/* 193 */     this.charMannerismsLabel = new JLabel("Mannerisms");
		/* 194 */     this.charMannerismsTxArea = new JTextArea(5, 20);
		/*     */ 
		/* 197 */     this.charFeaturesLabel = new JLabel("Distinguishing Features");
		/* 198 */     this.charFeaturesTxArea = new JTextArea(5, 20);
		/*     */ 
		/* 201 */     this.charHouseLabel = new JLabel("House");
		/* 202 */     this.charHouseTxField = new JTextField(5);
		/*     */ 
		/* 205 */     this.charStoryLabel = new JLabel("Personal History");
		/* 206 */     this.charStoryTxArea = new JTextArea(5, 20);
		/*     */ 
		/* 208 */     this.createChar = new JButton("Create Character");
		/* 209 */     this.createChar.addActionListener(this);
		/*     */ 
		/* 211 */     this.dogUrl = new URL("http://i.imgur.com/7ASit.gif");
		/* 212 */     this.dogIcon = new ImageIcon(this.dogUrl);
		/* 213 */     this.dogLabel = new JLabel(this.dogIcon);
		/*     */ 
		/* 217 */     this.westPanel1 = new JPanel(new GridLayout(8, 1));
		/* 218 */     this.westPanel1.add(this.charNameLabel);
		/* 219 */     this.westPanel1.add(this.charNameTxField);
		/* 220 */     this.westPanel1.add(this.charAgeLabel);
		/* 221 */     this.westPanel1.add(this.charAgeTxField);
		/* 222 */     this.westPanel1.add(this.charGenderLabel);
		/* 223 */     this.westPanel1.add(this.charGenderTxField);
		/* 224 */     this.westPanel1.add(this.charHouseLabel);
		/* 225 */     this.westPanel1.add(this.charHouseTxField);
		/* 226 */     this.westPanel1.add(this.charHeightLabel);
		/* 227 */     this.westPanel1.add(this.charHeightTxField);
		/* 228 */     this.westPanel1.add(this.charWeightLabel);
		/* 229 */     this.westPanel1.add(this.charWeightTxField);
		/* 230 */     this.westPanel1.add(this.charEyeLabel);
		/* 231 */     this.westPanel1.add(this.charEyeTxField);
		/* 232 */     this.westPanel1.add(this.charHairLabel);
		/* 233 */     this.westPanel1.add(this.charHairTxField);
		/*     */ 
		/* 235 */     this.northPanel = new JPanel(new FlowLayout());
		/* 236 */     this.northPanel.add(this.dogLabel);
		/*     */ 
		/* 238 */     this.southPanel1 = new JPanel(new GridLayout(6, 1));
		/* 239 */     this.southPanel1.add(this.charMannerismsLabel);
		/* 240 */     this.southPanel1.add(this.charMannerismsTxArea);
		/* 241 */     this.southPanel1.add(this.charFeaturesLabel);
		/* 242 */     this.southPanel1.add(this.charFeaturesTxArea);
		/* 243 */     this.southPanel1.add(this.charStoryLabel);
		/* 244 */     this.southPanel1.add(this.charStoryTxArea);
		/*     */ 
		/* 246 */     this.southPanel = new JPanel(new BorderLayout());
		/* 247 */     this.southPanel.add(this.southPanel1, "Center");
		/* 248 */     this.southPanel.add(this.createChar, "South");
		/*     */ 
		/* 253 */     this.createFrame.setDefaultCloseOperation(3);
		/* 254 */     this.createFrame.setLayout(new BorderLayout());
		/* 255 */     this.createFrame.add(this.northPanel, "North");
		/* 256 */     this.createFrame.add(this.westPanel1, "West");
		/* 257 */     this.createFrame.add(this.southPanel, "South");
		/* 258 */     this.createFrame.pack();
		/* 259 */     this.createFrame.setResizable(false);
		/* 260 */     this.createFrame.setVisible(true);
	/*     */   }
	/*     */ 
	/*     */   public static void main(String[] args)
			/*     */     throws MalformedURLException
			/*     */   {
		/* 266 */     new GUI();
	/*     */   }
	/*     */ 
	/*     */   public void actionPerformed(ActionEvent event)
	/*     */   {
		/* 272 */     if (event.getSource() == this.createChar)
		/*     */     {
			/* 274 */       this.CONTROL.writeCharFile(getCharName(),
					this.CONTROL.convertAge(getCharAge()), getCharGender(),
					getCharHouse(),
					this.CONTROL.convertHeight(getCharHeight()),
					this.CONTROL.convertWeight(getCharWeight()),
					getCharEye(),
					getCharHair(),
					getCharMannerisms(),
					getCharFeatures(),
					getCharStory());
			/* 275 */       JOptionPane.showMessageDialog(null, "Your character has been created! \n Now look to your C: drive for the .txt!");
		/*     */     }
	/*     */   }
/*     */ }

/* Location:           C:\Users\Timmy\Documents\1Timmy\Copenhagen Erhvervs Akademi\1. Semester\SoftwareKonstruktion 1\Uge 41\Sheet 0.1.jar
 * Qualified Name:     gui.GUI
 * JD-Core Version:    0.6.0
 */