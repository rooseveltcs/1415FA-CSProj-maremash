import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener{
	public JButton buttonOne = new JButton("1");
    public JButton buttonTwo = new JButton("2");
    public JButton buttonThree = new JButton("3");
    public JButton buttonFour = new JButton("4");
    public JButton buttonFive = new JButton("5");
    public JButton buttonSix = new JButton("6");
    public JButton buttonSeven = new JButton("7");
    public JButton buttonEight = new JButton("8");
    public JButton buttonNine = new JButton("9");
    public JButton buttonDecimal = new JButton(".");
    public JButton buttonZero = new JButton("0");
    public JButton buttonEquals = new JButton("=");
    public JButton buttonPlus = new JButton("+");
    public JButton buttonMinus = new JButton("-");
    public JButton buttonMultiply= new JButton("*");
    public JButton buttonDivide = new JButton("/");
    public JButton buttonMod = new JButton("%");
    public JTextField textField = new JTextField();
	/**
	 * @param args
	 */
    public Calc(){
    	super();
    	this.setSize(400, 400);
    	this.setVisible(true);
    	Container container = this.getContentPane();
    	container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
	    Box vbox1 = Box.createVerticalBox();
	    Box vbox2 = Box.createVerticalBox();
	    Box vbox3 = Box.createVerticalBox();
	    Box vbox4 = Box.createVerticalBox();
	    container.add(textField);
	    vbox1.add(buttonOne);
	    vbox2.add(buttonTwo);
	    vbox3.add(buttonThree);
	    vbox1.add(buttonFour);
	    vbox2.add(buttonFive);
	    vbox3.add(buttonSix);
	    vbox1.add(buttonSeven);
	    vbox2.add(buttonEight);
	    vbox3.add(buttonNine);
	    vbox1.add(buttonDecimal);
	    vbox2.add(buttonZero);
	    vbox3.add(buttonEquals);
	    vbox4.add(buttonPlus);
	    vbox4.add(buttonMinus);
	    vbox4.add(buttonMultiply);
	    vbox4.add(buttonDivide);
	    vbox4.add(buttonMod);
	    container.add(vbox1);
	    container.add(vbox2);
	    container.add(vbox3);
	    container.add(vbox4);
	    buttonOne.addActionListener(this);
	    buttonTwo.addActionListener(this);
	    buttonThree.addActionListener(this);
	    buttonFour.addActionListener(this);
	    buttonFive.addActionListener(this);
	    buttonSix.addActionListener(this);
	    buttonSeven.addActionListener(this);
	    /*buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);
	    buttonOne.addActionListener(this);*/
	    

    	
    }
	public static void main(String[] args) {
		Calc calc = new Calc();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == buttonOne){
			System.out.println("1");
		} else if(e.getSource() == buttonTwo){
			System.out.println("2");
		}else if(e.getSource() == buttonThree){
			System.out.println("3");
		}else if(e.getSource() == buttonFour){
			System.out.println("4");
		}else if(e.getSource() == buttonFive){
			System.out.println("5");
		}else if(e.getSource() == buttonSix){
			System.out.println("6");
		}else if(e.getSource() == buttonSeven){
			System.out.println("7");
		}else if(e.getSource() == buttonEight){
			System.out.println("8");
		}else if(e.getSource() == buttonNine){
			System.out.println("9");
		}else if(e.getSource() == buttonDecimal){
			System.out.println(".");
		}else if(e.getSource() == buttonZero){
			System.out.println("0");
		}else if(e.getSource() == buttonEquals){
			System.out.println("=");
		}else if(e.getSource() == buttonPlus){
			System.out.println("+");
		}else if(e.getSource() == buttonMinus){
			System.out.println("-");
		}else if(e.getSource() == buttonMultiply){
			System.out.println("*");
		}else if(e.getSource() == buttonDivide){
			System.out.println("/");
		}else if(e.getSource() == buttonMod){
			System.out.println("%");
		}
		
	}
}
