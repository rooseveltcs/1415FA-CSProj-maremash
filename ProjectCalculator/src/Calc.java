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
	    Container container = frame.getContentPane();
	    container.setPreferredSize(new Dimension(400, 400));
	    container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
	    Box vbox1 = Box.createVerticalBox();
	    Box vbox2 = Box.createVerticalBox();
	    Box vbox3 = Box.createVerticalBox();
	    Box vbox4 = Box.createVerticalBox();
	    container.add(new JTextField());
	    JButton one = new JButton("1");
	    JButton two = new JButton("2");
	    JButton three = new JButton("3");
	    JButton four = new JButton("4");
	    JButton five = new JButton("5");
	    JButton six = new JButton("6");
	    JButton seven = new JButton("7");
	    JButton eight = new JButton("8");
	    JButton nine = new JButton("9");
	    JButton decimal = new JButton(".");
	    JButton zero = new JButton("0");
	    JButton equals = new JButton("=");
	    JButton plus = new JButton("+");
	    JButton minus = new JButton("-");
	    JButton multiply= new JButton("*");
	    JButton divide = new JButton("/");
	    JButton mod = new JButton("%");
	    vbox1.add(one);
	    vbox2.add(two);
	    vbox3.add(three);
	    vbox1.add(four);
	    vbox2.add(five);
	    vbox3.add(six);
	    vbox1.add(seven);
	    vbox2.add(eight);
	    vbox3.add(nine);
	    vbox1.add(decimal);
	    vbox2.add(zero);
	    vbox3.add(equals);
	    vbox4.add(plus);
	    vbox4.add(minus);
	    vbox4.add(multiply);
	    vbox4.add(divide);
	    vbox4.add(mod);
	    container.add(vbox1);
	    container.add(vbox2);
	    container.add(vbox3);
	    container.add(vbox4);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
