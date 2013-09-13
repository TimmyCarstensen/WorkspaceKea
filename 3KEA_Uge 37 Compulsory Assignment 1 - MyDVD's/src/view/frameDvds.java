package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class frameDvds extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameDvds frame = new frameDvds();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frameDvds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 66, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblInstructor = new JLabel("Instructor");
		lblInstructor.setBounds(10, 91, 61, 14);
		contentPane.add(lblInstructor);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 117, 46, 14);
		contentPane.add(lblGenre);
		
		JLabel lblLeadActor = new JLabel("Lead Actor");
		lblLeadActor.setBounds(10, 144, 71, 14);
		contentPane.add(lblLeadActor);
		
		textField = new JTextField();
		textField.setBounds(99, 88, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 63, 133, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 114, 133, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 141, 133, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSeparateWith = new JLabel("(Separate with \",\")");
		lblSeparateWith.setForeground(Color.GRAY);
		lblSeparateWith.setBounds(242, 141, 108, 14);
		contentPane.add(lblSeparateWith);
		
		JButton btnAddDvd = new JButton("Add Dvd");
		btnAddDvd.setBounds(143, 169, 89, 23);
		contentPane.add(btnAddDvd);
	}
}
