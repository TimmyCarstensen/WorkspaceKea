package imageViewer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;

/**
 * Trying out the exercises in the book
 * @author Timmy
 * @version 1.00
 */
public class ImageViewer {

	private JFrame frame;
	
	/**
	 * Make a Imageviewer
	 */
	public ImageViewer(){
		makeFrame();
		makeMenuBar(this.frame);
		makeLabels();
	}
	
	public static void main(String[] args){
		new ImageViewer();
	}
	
	public void makeFrame(){
		frame = new JFrame("ImageViewer");
		
		frame.pack();
		frame.setSize(1000, 600);
		frame.setVisible(true);
	}
	
	public void makeMenuBar(JFrame frame){
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu fileMenu = new JMenu("file");
		JMenu helpMenu = new JMenu("help");
		
		menubar.add(fileMenu);
		menubar.add(helpMenu);
		
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem quitItem = new JMenuItem("Quit");
		
		JMenuItem about = new JMenuItem("About");
		
		fileMenu.add(openItem);
		fileMenu.add(quitItem);
		
		helpMenu.add(about);
	}
	
	public void makeLabels(){
		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel filenameLabel = new JPanel (new GridLayout(3,3));
		contentPane.add(filenameLabel);
		
		JLabel statusLabel = new JLabel("Version 1.0");
		contentPane.add(statusLabel);
	}
	
}
