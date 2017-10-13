package slotmachine;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyCounter();
	}

}

class MyCounter extends JFrame implements ActionListener {
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;

	public MyCounter() {
		setSize(500, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		;

		labels = new JLabel[3];
		numbers = new int[3];

		for (int i = 0; i < 3; i++) {
			labels[i] = new JLabel("" + numbers[i]);
			labels[i].setFont(new Font("Serig", Font.BOLD | Font.ITALIC, 100));
			labels[i].setSize(100, 100);
			;
			labels[i].setLocation(100 + 100 * i, 20);
			panel.add(labels[i]);
		}

		button = new JButton("½ºÇÉ");
		button.setSize(250, 50);
		button.setLocation(100, 150);
		panel.add(button);
		button.addActionListener(this);

		add(panel);
		setTitle("My Game");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Thread tNumber = new Thread(){
			public void run(){
				for (int i = 0; i < 3; i++) {
					int count = (int) (Math.random() * 30 + 20);
					
					for (int j = 0; j < count; j++) {
						//numbers[i] = (int) (Math.random() * 10); //·£´ý ¼öÄ¡
						numbers[i] = j%10;
						labels[i].setText(" " + numbers[i]);
						
						try {
							Thread.sleep(j*10);
						} catch (InterruptedException e1) {	}
					}
				}
				if((numbers[0] == numbers[1]) && (numbers[1]==numbers[2])){
					JOptionPane.showMessageDialog(null, "ÃàÇÏÃàÇÏ","¿ì¿Õ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		};
		tNumber.start();
	}
}