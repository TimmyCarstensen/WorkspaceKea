package proxyList;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameProxy extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Instance variables
	private JPanel contentPane;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private ProxyList proxyList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameProxy frame = new FrameProxy();
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
	public FrameProxy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Init the ProxyList
		proxyList = new ProxyList();

		// Add JLabels
		JLabel lblNewLabel = new JLabel("Text Item");
		JLabel lblNewLabel_1 = new JLabel("Index");
		lblNewLabel_1.setBounds(37, 221, 64, 14);
		lblNewLabel.setBounds(37, 130, 64, 14);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);

		// Add text fields
		jTextField1 = new JTextField();
		jTextField1.setBounds(111, 127, 86, 20);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);

		jTextField2 = new JTextField();
		jTextField2.setBounds(111, 218, 86, 20);
		contentPane.add(jTextField2);
		jTextField2.setColumns(10);

		//
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAddItem.setBounds(49, 155, 89, 23);
		contentPane.add(btnAddItem);

		JButton btnRemoveItem = new JButton("Remove item");
		btnRemoveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeItem();
			}
		});
		btnRemoveItem.setBounds(148, 155, 114, 23);
		contentPane.add(btnRemoveItem);

		JButton btnGetThis = new JButton("Get this");
		btnGetThis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getThis();
			}
		});
		btnGetThis.setBounds(49, 246, 89, 23);
		contentPane.add(btnGetThis);

		JButton btnNewButton = new JButton("Remove index");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeIndex();
			}
		});
		btnNewButton.setBounds(148, 246, 114, 23);
		contentPane.add(btnNewButton);

		JButton btnShowAll = new JButton("Show all");
		btnShowAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showAll();
			}
		});
		btnShowAll.setBounds(343, 78, 89, 23);
		contentPane.add(btnShowAll);

		JButton btnNewButton_1 = new JButton("Clear list");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearList();
			}
		});
		btnNewButton_1.setBounds(393, 246, 89, 23);
		contentPane.add(btnNewButton_1);

		
		proxyList.setBounds(435, 53, 270, 183);
		contentPane.add(proxyList);
	}

	public void add() {
		proxyList.add(jTextField1.getText());
	}

	public void showAll() {
		String T[] = proxyList.getAll();
		proxyList.removeAll();
		for (int i = 0; i < T.length; i++) {
			proxyList.add(T[i]);
		}
	}

	public void removeItem() {
		proxyList.remove(jTextField1.getText());
	}

	public void removeIndex() {
		proxyList.remove(Integer.parseInt(jTextField2.getText()));
	}

	public void getThis() {
		jTextField1.setText(proxyList.getItem(Integer.parseInt(jTextField2
				.getText())));
	}

	public void clearList() {
		proxyList.clearList();
	}
}
