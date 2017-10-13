import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyButton extends JButton {
	static int count = 0;
	int index;

	public MyButton(String s) {
		super(s);
		index = count++;
	}
}

public class Puzzle extends JFrame implements ActionListener {
	MyButton[] buttons;
	MyButton reset;

	public Puzzle() {
		super("puzzle");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 2, 2));
		buttons = new MyButton[9];
		randCreate();
		buttons[8] = new MyButton(" ");
		for (int i = 0; i < 9; i++)
			panel.add(buttons[i]);
		for (int i = 0; i < 9; i++)
			buttons[i].addActionListener(this);
		add(panel, BorderLayout.CENTER);
		reset = new MyButton("reset");
		reset.addActionListener(this);
		reset.setBackground(Color.red);
		reset.setForeground(Color.yellow);
		add(reset, BorderLayout.SOUTH);
		// reset.addActionListener(this);

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		MyButton b = (MyButton) e.getSource();
		if (b.getText().equals(" ") == true)
			return;
		if (b.getText().equals(reset.getText()) == true)
			reset();
		else {
			if (b.index == 0) {
				if (buttons[1].getText().equals(" ")) {
					buttons[1].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[3].getText().equals(" ")) {
					buttons[3].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 1) {
				if (buttons[0].getText().equals(" ")) {
					buttons[0].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[2].getText().equals(" ")) {
					buttons[2].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[4].getText().equals(" ")) {
					buttons[4].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 2) {
				if (buttons[1].getText().equals(" ")) {
					buttons[1].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[5].getText().equals(" ")) {
					buttons[5].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 3) {
				if (buttons[0].getText().equals(" ")) {
					buttons[0].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[4].getText().equals(" ")) {
					buttons[4].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[6].getText().equals(" ")) {
					buttons[6].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 4) {
				if (buttons[1].getText().equals(" ")) {
					buttons[1].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[3].getText().equals(" ")) {
					buttons[3].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[5].getText().equals(" ")) {
					buttons[5].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[7].getText().equals(" ")) {
					buttons[7].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 5) {
				if (buttons[2].getText().equals(" ")) {
					buttons[2].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[4].getText().equals(" ")) {
					buttons[4].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[8].getText().equals(" ")) {
					buttons[8].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 6) {
				if (buttons[3].getText().equals(" ")) {
					buttons[3].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[7].getText().equals(" ")) {
					buttons[7].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 7) {
				if (buttons[4].getText().equals(" ")) {
					buttons[4].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[6].getText().equals(" ")) {
					buttons[6].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[8].getText().equals(" ")) {
					buttons[8].setText(b.getText());
					b.setText(" ");
				}
			} else if (b.index == 8) {
				if (buttons[5].getText().equals(" ")) {
					buttons[5].setText(b.getText());
					b.setText(" ");
				}
				if (buttons[7].getText().equals(" ")) {
					buttons[7].setText(b.getText());
					b.setText(" ");
				}
			}

			buttons[8].transferFocus();
			if (isCheck()) {
				JOptionPane.showMessageDialog(null, "정답입니다.");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Puzzle();
	}

	private void randCreate() {
		Random rand = new Random();
		boolean flag = false;

		for (int i = 0; i < 8; i++) {
			int r = (rand.nextInt(8) + 1);

			for (int j = 0; j < i; j++) {
				if (buttons[j].getText().equals(Integer.toString(r))) {
					i--;
					flag = true;
					continue;
				}
			}
			if (flag) {
				flag = false;
				continue;
			}
			buttons[i] = new MyButton(Integer.toString(r));
		}
	}

	private void reset() {
		Random rand = new Random();
		boolean flag = false;
		JOptionPane.showMessageDialog(null, "바꿉니다.");
		for (int i = 0; i < 8; i++) {
			int r = (rand.nextInt(8) + 1);

			for (int j = 0; j < i; j++) {
				if (buttons[j].getText().equals(Integer.toString(r))) {
					i--;
					flag = true;
					continue;
				}
			}
			if (flag) {
				flag = false;
				continue;
			}
			buttons[i].setText((Integer.toString(r)));
		}
	}

	private boolean isCheck() {
		for (int i = 0; i < 8; i++) {
			if (buttons[i].getText().equals(Integer.toString(i + 1)) == false) {
				return false;
			}
		}
		return true;
	}
}
