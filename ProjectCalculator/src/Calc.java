import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	public JButton buttonOne = new JButton("1");
	public JButton buttonTwo = new JButton("2");
	public JButton buttonThree = new JButton("3");
	public JButton buttonFour = new JButton("4");
	public JButton buttonFive = new JButton("5");
	public JButton buttonSix = new JButton("6");
	public JButton buttonSeven = new JButton("7");
	public JButton buttonEight = new JButton("8");
	public JButton buttonNine = new JButton("9");
	public JButton buttonClear = new JButton("CLR");
	public JButton buttonZero = new JButton("0");
	public JButton buttonEquals = new JButton("=");
	public JButton buttonPlus = new JButton("+");
	public JButton buttonMinus = new JButton("-");
	public JButton buttonMultiply = new JButton("*");
	public JButton buttonDivide = new JButton("/");
	public JButton buttonMod = new JButton("%");
	public JTextField textField = new JTextField();

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}

	public Calculator() {
		super();
		this.setTitle("Calculator");
		this.setSize(100, 100);
		this.setVisible(true);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		container.add(panel1);
		container.add(panel2);
		Box vbox1 = Box.createVerticalBox();
		Box vbox2 = Box.createVerticalBox();
		Box vbox3 = Box.createVerticalBox();
		Box vbox4 = Box.createVerticalBox();
		textField.setPreferredSize(new Dimension(200, 20));
		settingButtonSize();
		panel1.add(textField);
		vbox1.add(buttonOne);
		vbox2.add(buttonTwo);
		vbox3.add(buttonThree);
		vbox1.add(buttonFour);
		vbox2.add(buttonFive);
		vbox3.add(buttonSix);
		vbox1.add(buttonSeven);
		vbox2.add(buttonEight);
		vbox3.add(buttonNine);
		vbox1.add(buttonClear);
		vbox2.add(buttonZero);
		vbox3.add(buttonEquals);
		vbox4.add(buttonPlus);
		vbox4.add(buttonMinus);
		vbox4.add(buttonMultiply);
		vbox4.add(buttonDivide);
		vbox4.add(buttonMod);
		panel2.add(vbox1);
		panel2.add(vbox2);
		panel2.add(vbox3);
		panel2.add(vbox4);
		buttonOne.addActionListener(this);
		buttonTwo.addActionListener(this);
		buttonThree.addActionListener(this);
		buttonFour.addActionListener(this);
		buttonFive.addActionListener(this);
		buttonSix.addActionListener(this);
		buttonSeven.addActionListener(this);
		buttonEight.addActionListener(this);
		buttonNine.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonZero.addActionListener(this);
		buttonEquals.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonMod.addActionListener(this);
		this.add(container);
		this.pack();
	}

	public void settingButtonSize() {
		Dimension button = new Dimension(50, 50);
		buttonOne.setSize(button);
		buttonTwo.setSize(button);
		buttonThree.setSize(button);
		buttonFour.setSize(button);
		buttonFive.setSize(button);
		buttonSix.setSize(button);
		buttonSeven.setSize(button);
		buttonEight.setSize(button);
		buttonNine.setSize(button);
		buttonClear.setSize(button);
		buttonZero.setSize(button);
		buttonEquals.setSize(button);
		buttonPlus.setSize(button);
		buttonMinus.setSize(button);
		buttonMultiply.setSize(button);
		buttonDivide.setSize(button);
		buttonMod.setSize(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonOne) {
			textField.setText(textField.getText() + "1");
		} else if (e.getSource() == buttonTwo) {
			textField.setText(textField.getText() + "2");
		} else if (e.getSource() == buttonThree) {
			textField.setText(textField.getText() + "3");
		} else if (e.getSource() == buttonFour) {
			textField.setText(textField.getText() + "4");
		} else if (e.getSource() == buttonFive) {
			textField.setText(textField.getText() + "5");
		} else if (e.getSource() == buttonSix) {
			textField.setText(textField.getText() + "6");
		} else if (e.getSource() == buttonSeven) {
			textField.setText(textField.getText() + "7");
		} else if (e.getSource() == buttonEight) {
			textField.setText(textField.getText() + "8");
		} else if (e.getSource() == buttonNine) {
			textField.setText(textField.getText() + "9");
		} else if (e.getSource() == buttonClear) {
			textField.setText("");
		} else if (e.getSource() == buttonZero) {
			textField.setText(textField.getText() + "0");
		} else if (e.getSource() == buttonEquals) {
			try {
				textField.setText("" + getAnswer(textField.getText()));
			} catch (Exception error) {
				System.out.println("There was no input");
				System.out.println(error);
			}
		} else if (e.getSource() == buttonPlus) {
			textField.setText(textField.getText() + "+");
		} else if (e.getSource() == buttonMinus) {
			textField.setText(textField.getText() + "-");
		} else if (e.getSource() == buttonMultiply) {
			textField.setText(textField.getText() + "*");
		} else if (e.getSource() == buttonDivide) {
			textField.setText(textField.getText() + "/");
		} else if (e.getSource() == buttonMod) {
			textField.setText(textField.getText() + "%");
		}

	}

	public int getAnswer(String text) {
		if (text.equals("")) {
			return 0;
		}
		String input = "";
		int number = 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> operators = new ArrayList<String>();
		try {
			Integer.parseInt("" + text.charAt(0));
			Integer.parseInt("" + text.charAt(text.length() - 1));
		} catch (Exception testError) {
			System.out
					.println("The first and last characters must be numbers.");
			System.out.println(testError);
			return 0;
		}
		for (int i = 0; i < text.length(); i++) {
			input += text.charAt(i);
			try {
				int numInput = Integer.parseInt(input);
				number = numInput;

				// System.out.println(number);
			} catch (Exception notNum) {
				if ((text.charAt(i) + "").equals("+")
						|| (text.charAt(i) + "").equals("-")
						|| (text.charAt(i) + "").equals("*")
						|| (text.charAt(i) + "").equals("/")
						|| (text.charAt(i) + "").equals("%")) {
					operators.add("" + text.charAt(i));
				} else {
					System.out.println("Only input numbers or opperators.");
					return 0;
				}
				numbers.add(number);
				input = "";
			}
		}
		if (number != 0) {
			numbers.add(number);
		}
		int answer = 0;
		for (int s = 0; s < numbers.size() - 1; s++) {
			if (operators.get(s).equals("+")) {
				answer = numbers.get(s) + numbers.get(s + 1);
				numbers.set(s + 1, answer);
			} else if (operators.get(s).equals("-")) {
				answer = numbers.get(s) - numbers.get(s + 1);
				numbers.set(s + 1, answer);
			} else if (operators.get(s).equals("*")) {
				answer = numbers.get(s) * numbers.get(s + 1);
				numbers.set(s + 1, answer);
			}
			if (operators.get(s).equals("/")) {
				answer = numbers.get(s) / numbers.get(s + 1);
				numbers.set(s + 1, answer);
			}
			if (operators.get(s).equals("%")) {
				answer = numbers.get(s) % numbers.get(s + 1);
				numbers.set(s + 1, answer);
			}
		}
		return answer;
	}
}
