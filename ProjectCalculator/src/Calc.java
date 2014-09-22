import java.awt.*;

import javax.swing.*;

public class Calc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run(){
					displayGUI();
				}
		});
	}
	
	public static void displayGUI(){
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 500);
	    frame.setLayout(new GridLayout(3, 2));
	    frame.add(new JButton("+"));
	    frame.add(new JButton("-"));
	    frame.add(new JButton("*"));
	    frame.add(new JButton("/"));
	    frame.add(new JButton("="));
	    
		frame.pack();
		frame.setVisible(true);
	}

}
