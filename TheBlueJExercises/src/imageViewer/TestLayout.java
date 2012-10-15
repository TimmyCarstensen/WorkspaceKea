package imageViewer;

import java.awt.*;
import java.applet.Applet;
public class TestLayout extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TestLayout(){
   
	}
	 
	public void init() {
		setLayout(new GridLayout(3,2));
		
		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("4"));
		add(new Button("5"));
		add(new Button("6"));
	}
    

	public static void main(String args){
		new TestLayout();
	}
}
