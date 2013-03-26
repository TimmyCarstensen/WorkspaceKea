package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.QuestionController;



/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Questionnaries extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String quest_answer = "";
//	private String[] answer1, answer2;
	private JButton questionnaries1, questionnaries2, print;
	private JPanel jpCenter, jpSouth, jpNorth;
	private QuestionController qc = new QuestionController();
	/**
	 * @param args
	 */
	public Questionnaries()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		
		// Create components
		jpNorth = new JPanel(new FlowLayout());
		jpCenter = new JPanel(new FlowLayout());
		jpSouth = new JPanel(new FlowLayout());
		this.questionnaries1 = new JButton("questionaries 1");
		this.questionnaries2 = new JButton("questionaries 2");
		this.print = new JButton("Reset");
		final JTextArea printOutQuestionnariesTextArea = new JTextArea();
		
		
		//Assign components functions
		//questionnaries button 1
		this.questionnaries1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				questionnariesMakeString(1);
				printOutQuestionnariesTextArea.setText(quest_answer);
			}			
		});
		//questionnarie button 2
		this.questionnaries2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				questionnariesMakeString(2);
				printOutQuestionnariesTextArea.setText(quest_answer);
				
			}	
		});
		//print button
		this.print.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e){
				quest_answer = "";
				printOutQuestionnariesTextArea.setText(quest_answer);
			}
		});
		
		//questionnarie TextArea
		printOutQuestionnariesTextArea.setBackground(Color.WHITE);
		
		// add components
		jpNorth.add(this.questionnaries1);
		jpNorth.add(this.questionnaries2);
		jpCenter.add(printOutQuestionnariesTextArea);
		
		jpSouth.add(this.print);
		add(jpNorth, BorderLayout.NORTH);
		add(jpCenter, BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	/**
	 * Make a string when asking question that contains both questions and answers.
	 * @param choice
	 */
	public void questionnariesMakeString(int choice)
	{
		this.quest_answer = this.quest_answer + "-----------------------------------\nYou picked questionnarie: " + choice + "\n";
		for(String a : qc.getQuestions(choice)) 
		{
			String TempAnswer = JOptionPane.showInputDialog(null, a);
			this.quest_answer = this.quest_answer + a + ": " + TempAnswer + "\n";
		}
	}
}
