package slotmachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SlotMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyCounter();
	}

}

class Card {
	ImageIcon image;
	int num;
}

class User {
	private int money;

	public User() {
		money = 1000000;
	}

	public void getMoney(int m) {
		money = money + m;
	}

	public void betMoney(int m) {
		money = money - m;
	}

	public int Money() {
		return money;
	}
}

class MyCounter extends JFrame implements ActionListener {
	private JLabel[] labels;
	private JButton button;
	private Card[] cards;
	private User user;
	private JLabel labelMoney;
	private JTextField tfBetting;
	private boolean flag = true;

	public MyCounter() {
		setSize(500, 330);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		user = new User();
		tfBetting = new JTextField();
		labels = new JLabel[4];
		cards = new Card[4];

		cards[0] = new Card();
		cards[1] = new Card();
		cards[2] = new Card();
		cards[3] = new Card();

		cards[0].image = new ImageIcon("image/h0.JPG");
		cards[1].image = new ImageIcon("image/s0.jpg");
		cards[2].image = new ImageIcon("image/d0.jpg");
		cards[3].image = new ImageIcon("image/c0.jpg");

		for (int i = 0; i < 4; i++) {
			labels[i] = new JLabel("", cards[i].image, JLabel.CENTER);
			labels[i].setSize(100, 139);
			;
			labels[i].setLocation(25 + 110 * i, 20);
			panel.add(labels[i]);
		}

		labelMoney = new JLabel(Integer.toString(user.Money()));
		labelMoney.setSize(100, 10);
		labelMoney.setLocation(100, 230);
		tfBetting.setSize(100, 20);
		tfBetting.setLocation(100, 250);
		tfBetting.setText("1000");
		button = new JButton("돌려돌려");
		button.setSize(250, 50);
		button.setLocation(100, 170);
		panel.add(button);
		panel.add(labelMoney);
		panel.add(tfBetting);
		button.addActionListener(this);

		add(panel);
		setTitle("My Game");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (flag) {
			flag = false;
			user.betMoney(Integer.parseInt(tfBetting.getText()));
			labelMoney.setText(Integer.toString(user.Money()));

			Thread tNumber = new Thread() {
				public void run() {
					for (int i = 0; i < 4; i++) {
						int count = (int) (Math.random() * 30 + 15);

						for (int j = 0; j < count; j++) {
							int x = j % 14;

							switch (i) {
							case 0:
								// labels[i].setText("", new ImageIcon("image/h"
								// + x + ".JPG"),JLabel.CENTER);
								labels[i].setIcon(new ImageIcon("image/h" + x + ".JPG"));
								break;
							case 1:
								labels[i].setIcon(new ImageIcon("image/s" + x + ".JPG"));
								break;
							case 2:
								labels[i].setIcon(new ImageIcon("image/d" + x + ".JPG"));
								break;
							case 3:
								labels[i].setIcon(new ImageIcon("image/c" + x + ".JPG"));
								break;
							}
							cards[i].num = x;

							try {
								Thread.sleep(j * 10);
							} 
							catch (InterruptedException e1) {
							}
						}
					}
					if ((cards[0].num == cards[1].num) && (cards[1].num == cards[2].num)
							&& (cards[2].num == cards[3].num)) {
						JOptionPane.showMessageDialog(null, "축하축하", "우왕", JOptionPane.PLAIN_MESSAGE);
						user.getMoney(Integer.parseInt(tfBetting.getText()) * 100);
					}
					flag = true;
				}
			};
			tNumber.start();
		}
	}
}