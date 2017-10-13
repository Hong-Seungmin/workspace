package tic_tac_toe_gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MyPanel extends JPanel implements ActionListener {
	static JButton[][] buttons = new JButton[3][3];
	private char turn = 'X';

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		//f.setUndecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(300, 300);
		f.setVisible(true);
	}

	public MyPanel() {
		setLayout(new GridLayout(3, 3, 5, 5));
		Font f = new Font("Dialog", Font.ITALIC, 50);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(f);
				buttons[i][j].addActionListener(this);
				add(buttons[i][j]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (e.getSource() == buttons[i][j] && buttons[i][j].getText().equals(" ") == true) {
					if (turn == 'X') {
						buttons[i][j].setText("X");
						set_com();
					}
				}
			}
		}
	}

	static boolean set_com() {
		int[] rank = new int[9];

		////////////////// 주변에 빈칸이 많은가? 최소랭크
		if (buttons[0][0].getText().equals(" ")) {
			if (buttons[0][1].getText().equals(" ") && buttons[0][2].getText().equals(" ")) {
				rank[0]++;
			}
			if (buttons[1][1].getText().equals(" ") && buttons[1][2].getText().equals(" ")) {
				rank[0]++;
			}
			if (buttons[1][0].getText().equals(" ") && buttons[2][0].getText().equals(" ")) {
				rank[0]++;
			}
		}
		if (buttons[0][1].getText().equals(" ")) {
			if (buttons[1][1].getText().equals(" ") && buttons[2][1].getText().equals(" ")) {
				rank[1]++;
			}
			if (buttons[0][0].getText().equals(" ") && buttons[0][2].getText().equals(" ")) {
				rank[1]++;
			}
		}
		if (buttons[0][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals(" ") && buttons[0][1].getText().equals(" ")) {
				rank[2]++;
			}
			if (buttons[1][1].getText().equals(" ") && buttons[2][0].getText().equals(" ")) {
				rank[2]++;
			}
			if (buttons[1][2].getText().equals(" ") && buttons[2][2].getText().equals(" ")) {
				rank[2]++;
			}
		}
		if (buttons[1][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals(" ") && buttons[2][0].getText().equals(" ")) {
				rank[3]++;
			}
			if (buttons[1][1].getText().equals(" ") && buttons[1][2].getText().equals(" ")) {
				rank[3]++;
			}
		}
		if (buttons[1][1].getText().equals(" ")) {
			if (buttons[0][0].getText().equals(" ") && buttons[2][2].getText().equals(" ")) {
				rank[4]++;
			}
			if (buttons[0][1].getText().equals(" ") && buttons[2][1].getText().equals(" ")) {
				rank[4]++;
			}
			if (buttons[0][2].getText().equals(" ") && buttons[2][0].getText().equals(" ")) {
				rank[4]++;
			}
			if (buttons[1][0].getText().equals(" ") && buttons[1][2].getText().equals(" ")) {
				rank[4]++;
			}
		}
		if (buttons[1][2].getText().equals(" ")) {
			if (buttons[0][2].getText().equals(" ") && buttons[2][2].getText().equals(" ")) {
				rank[5]++;
			}
			if (buttons[1][0].getText().equals(" ") && buttons[1][1].getText().equals(" ")) {
				rank[5]++;
			}
		}
		if (buttons[2][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals(" ") && buttons[1][0].getText().equals(" ")) {
				rank[6]++;
			}
			if (buttons[1][1].getText().equals(" ") && buttons[0][2].getText().equals(" ")) {
				rank[6]++;
			}
			if (buttons[2][1].getText().equals(" ") && buttons[2][2].getText().equals(" ")) {
				rank[6]++;
			}
		}
		if (buttons[2][1].getText().equals(" ")) {
			if (buttons[0][1].getText().equals(" ") && buttons[1][1].getText().equals(" ")) {
				rank[7]++;
			}
			if (buttons[2][0].getText().equals(" ") && buttons[2][2].getText().equals(" ")) {
				rank[7]++;
			}
		}
		if (buttons[2][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals(" ") && buttons[1][1].getText().equals(" ")) {
				rank[8]++;
			}
			if (buttons[0][2].getText().equals(" ") && buttons[1][2].getText().equals(" ")) {
				rank[8]++;
			}
			if (buttons[2][0].getText().equals(" ") && buttons[2][1].getText().equals(" ")) {
				rank[8]++;
			}
		}
		///////////////// 주변에 "O")이 있는가? 최소랭크
		if (buttons[0][0].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("O") || buttons[0][2].getText().equals("O")) {
				rank[0]++;
			}
			if (buttons[1][1].getText().equals("O") || buttons[1][2].getText().equals("O")) {
				rank[0]++;
			}
			if (buttons[1][0].getText().equals("O") || buttons[2][0].getText().equals("O")) {
				rank[0]++;
			}
		}
		if (buttons[0][1].getText().equals(" ")) {
			if (buttons[1][1].getText().equals("O") || buttons[2][1].getText().equals("O")) {
				rank[1]++;
			}
			if (buttons[0][0].getText().equals("O") || buttons[0][2].getText().equals("O")) {
				rank[1]++;
			}
		}
		if (buttons[0][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") || buttons[0][1].getText().equals("O")) {
				rank[2]++;
			}
			if (buttons[1][1].getText().equals("O") || buttons[2][0].getText().equals("O")) {
				rank[2]++;
			}
			if (buttons[1][2].getText().equals("O") || buttons[2][2].getText().equals("O")) {
				rank[2]++;
			}
		}
		if (buttons[1][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") || buttons[2][0].getText().equals("O")) {
				rank[3]++;
			}
			if (buttons[1][1].getText().equals("O") || buttons[1][2].getText().equals("O")) {
				rank[3]++;
			}
		}
		if (buttons[1][1].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") || buttons[2][2].getText().equals("O")) {
				rank[4]++;
			}
			if (buttons[0][1].getText().equals("O") || buttons[2][1].getText().equals("O")) {
				rank[4]++;
			}
			if (buttons[0][2].getText().equals("O") || buttons[2][0].getText().equals("O")) {
				rank[4]++;
			}
			if (buttons[1][0].getText().equals("O") || buttons[1][2].getText().equals("O")) {
				rank[4]++;
			}
		}
		if (buttons[1][2].getText().equals(" ")) {
			if (buttons[0][2].getText().equals("O") || buttons[2][2].getText().equals("O")) {
				rank[5]++;
			}
			if (buttons[1][0].getText().equals("O") || buttons[1][1].getText().equals("O")) {
				rank[5]++;
			}
		}
		if (buttons[2][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") || buttons[1][0].getText().equals("O")) {
				rank[6]++;
			}
			if (buttons[1][1].getText().equals("O") || buttons[0][2].getText().equals("O")) {
				rank[6]++;
			}
			if (buttons[2][1].getText().equals("O") || buttons[2][2].getText().equals("O")) {
				rank[6]++;
			}
		}
		if (buttons[2][1].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("O") || buttons[1][1].getText().equals("O")) {
				rank[7]++;
			}
			if (buttons[2][0].getText().equals("O") || buttons[2][2].getText().equals("O")) {
				rank[7]++;
			}
		}
		if (buttons[2][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") || buttons[1][1].getText().equals("O")) {
				rank[8]++;
			}
			if (buttons[0][2].getText().equals("O") || buttons[1][2].getText().equals("O")) {
				rank[8]++;
			}
			if (buttons[2][0].getText().equals("O") || buttons[2][1].getText().equals("O")) {
				rank[8]++;
			}
		}
		///////////////// 주변에 "X")가 1개라도 있는가? 랭크감소
		if (buttons[0][0].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("X") || buttons[0][2].getText().equals("X")) {
				rank[0]--;
			}
			if (buttons[1][1].getText().equals("X") || buttons[1][2].getText().equals("X")) {
				rank[0]--;
			}
			if (buttons[1][0].getText().equals("X") || buttons[2][0].getText().equals("X")) {
				rank[0]--;
			}
		}
		if (buttons[0][1].getText().equals(" ")) {
			if (buttons[1][1].getText().equals("X") || buttons[2][1].getText().equals("X")) {
				rank[1]--;
			}
			if (buttons[0][0].getText().equals("X") || buttons[0][2].getText().equals("X")) {
				rank[1]--;
			}
		}
		if (buttons[0][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") || buttons[0][1].getText().equals("X")) {
				rank[2]--;
			}
			if (buttons[1][1].getText().equals("X") || buttons[2][0].getText().equals("X")) {
				rank[2]--;
			}
			if (buttons[1][2].getText().equals("X") || buttons[2][2].getText().equals("X")) {
				rank[2]--;
			}
		}
		if (buttons[1][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") || buttons[2][0].getText().equals("X")) {
				rank[3]--;
			}
			if (buttons[1][1].getText().equals("X") || buttons[1][2].getText().equals("X")) {
				rank[3]--;
			}
		}
		if (buttons[1][1].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") || buttons[2][2].getText().equals("X")) {
				rank[4]--;
			}
			if (buttons[0][1].getText().equals("X") || buttons[2][1].getText().equals("X")) {
				rank[4]--;
			}
			if (buttons[0][2].getText().equals("X") || buttons[2][0].getText().equals("X")) {
				rank[4]--;
			}
			if (buttons[1][0].getText().equals("X") || buttons[1][2].getText().equals("X")) {
				rank[4]--;
			}
		}
		if (buttons[1][2].getText().equals(" ")) {
			if (buttons[0][2].getText().equals("X") || buttons[2][2].getText().equals("X")) {
				rank[5]--;
			}
			if (buttons[1][0].getText().equals("X") || buttons[1][1].getText().equals("X")) {
				rank[5]--;
			}
		}
		if (buttons[2][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") || buttons[1][0].getText().equals("X")) {
				rank[6]--;
			}
			if (buttons[1][1].getText().equals("X") || buttons[0][2].getText().equals("X")) {
				rank[6]--;
			}
			if (buttons[2][1].getText().equals("X") || buttons[2][2].getText().equals("X")) {
				rank[6]--;
			}
		}
		if (buttons[2][1].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("X") || buttons[1][1].getText().equals("X")) {
				rank[7]--;
			}
			if (buttons[2][0].getText().equals("X") || buttons[2][2].getText().equals("X")) {
				rank[7]--;
			}
		}
		if (buttons[2][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") || buttons[1][1].getText().equals("X")) {
				rank[8]--;
			}
			if (buttons[0][2].getText().equals("X") || buttons[1][2].getText().equals("X")) {
				rank[8]--;
			}
			if (buttons[2][0].getText().equals("X") || buttons[2][1].getText().equals("X")) {
				rank[8]--;
			}
		}
		///////////////// 주변에 "O")가 2개 연달아 있는가? 최고랭크
		if (buttons[0][0].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals("O")) {
				rank[0] += 100;
			}
			if (buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O")) {
				rank[0] += 100;
			}
			if (buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O")) {
				rank[0] += 100;
			}
		}
		if (buttons[0][1].getText().equals(" ")) {
			if (buttons[1][1].getText().equals("O") && buttons[2][1].getText().equals("O")) {
				rank[1] += 100;
			}
			if (buttons[0][0].getText().equals("O") && buttons[0][2].getText().equals("O")) {
				rank[1] += 100;
			}
		}
		if (buttons[0][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") && buttons[0][1].getText().equals("O")) {
				rank[2] += 100;
			}
			if (buttons[1][1].getText().equals("O") && buttons[2][0].getText().equals("O")) {
				rank[2] += 100;
			}
			if (buttons[1][2].getText().equals("O") && buttons[2][2].getText().equals("O")) {
				rank[2] += 100;
			}
		}
		if (buttons[1][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") && buttons[2][0].getText().equals("O")) {
				rank[3] += 100;
			}
			if (buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O")) {
				rank[3] += 100;
			}
		}
		if (buttons[1][1].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") && buttons[2][2].getText().equals("O")) {
				rank[4] += 100;
			}
			if (buttons[0][1].getText().equals("O") && buttons[2][1].getText().equals("O")) {
				rank[4] += 100;
			}
			if (buttons[0][2].getText().equals("O") && buttons[2][0].getText().equals("O")) {
				rank[4] += 100;
			}
			if (buttons[1][0].getText().equals("O") && buttons[1][2].getText().equals("O")) {
				rank[4] += 100;
			}
		}
		if (buttons[1][2].getText().equals(" ")) {
			if (buttons[0][2].getText().equals("O") && buttons[2][2].getText().equals("O")) {
				rank[5] += 100;
			}
			if (buttons[1][0].getText().equals("O") && buttons[1][1].getText().equals("O")) {
				rank[5] += 100;
			}
		}
		if (buttons[2][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O")) {
				rank[6] += 100;
			}
			if (buttons[1][1].getText().equals("O") && buttons[0][2].getText().equals("O")) {
				rank[6] += 100;
			}
			if (buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals("O")) {
				rank[6] += 100;
			}
		}
		if (buttons[2][1].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("O") && buttons[1][1].getText().equals("O")) {
				rank[7] += 100;
			}
			if (buttons[2][0].getText().equals("O") && buttons[2][2].getText().equals("O")) {
				rank[7] += 100;
			}
		}
		if (buttons[2][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O")) {
				rank[8] += 100;
			}
			if (buttons[0][2].getText().equals("O") && buttons[1][2].getText().equals("O")) {
				rank[8] += 100;
			}
			if (buttons[2][0].getText().equals("O") && buttons[2][1].getText().equals("O")) {
				rank[8] += 100;
			}
		}
		///////////////// 주변에 "X")가 2개 연달아 있는가? 중간랭크
		if (buttons[0][0].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X")) {
				rank[0] += 50;
			}
			if (buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X")) {
				rank[0] += 50;
			}
			if (buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X")) {
				rank[0] += 50;
			}
		}
		if (buttons[0][1].getText().equals(" ")) {
			if (buttons[1][1].getText().equals("X") && buttons[2][1].getText().equals("X")) {
				rank[1] += 50;
			}
			if (buttons[0][0].getText().equals("X") && buttons[0][2].getText().equals("X")) {
				rank[1] += 50;
			}
		}
		if (buttons[0][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X")) {
				rank[2] += 50;
			}
			if (buttons[1][1].getText().equals("X") && buttons[2][0].getText().equals("X")) {
				rank[2] += 50;
			}
			if (buttons[1][2].getText().equals("X") && buttons[2][2].getText().equals("X")) {
				rank[2] += 50;
			}
		}
		if (buttons[1][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") && buttons[2][0].getText().equals("X")) {
				rank[3] += 50;
			}
			if (buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X")) {
				rank[3] += 50;
			}
		}
		if (buttons[1][1].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") && buttons[2][2].getText().equals("X")) {
				rank[4] += 50;
			}
			if (buttons[0][1].getText().equals("X") && buttons[2][1].getText().equals("X")) {
				rank[4] += 50;
			}
			if (buttons[0][2].getText().equals("X") && buttons[2][0].getText().equals("X")) {
				rank[4] += 50;
			}
			if (buttons[1][0].getText().equals("X") && buttons[1][2].getText().equals("X")) {
				rank[4] += 50;
			}
		}
		if (buttons[1][2].getText().equals(" ")) {
			if (buttons[0][2].getText().equals("X") && buttons[2][2].getText().equals("X")) {
				rank[5] += 50;
			}
			if (buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X")) {
				rank[5] += 50;
			}
		}
		if (buttons[2][0].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X")) {
				rank[6] += 50;
			}
			if (buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X")) {
				rank[6] += 50;
			}
			if (buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X")) {
				rank[6] += 50;
			}
		}
		if (buttons[2][1].getText().equals(" ")) {
			if (buttons[0][1].getText().equals("X") && buttons[1][1].getText().equals("X")) {
				rank[7] += 50;
			}
			if (buttons[2][0].getText().equals("X") && buttons[2][2].getText().equals("X")) {
				rank[7] += 50;
			}
		}
		if (buttons[2][2].getText().equals(" ")) {
			if (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X")) {
				rank[8] += 50;
			}
			if (buttons[0][2].getText().equals("X") && buttons[1][2].getText().equals("X")) {
				rank[8] += 50;
			}
			if (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X")) {
				rank[8] += 50;
			}
		}
		/////////////////
		int tmp = 0;
		boolean flag = false;

		for (int i = 0; i < 9; i++) {
			if (rank[tmp] < rank[i]) {
				tmp = i;
				flag = true;
			}
		}

		if (tmp == 0 && rank[0] > 0)
			flag = true;

		if (flag)
			switch (tmp) {
			case 0:
				buttons[0][0].setText("O");
				break;
			case 1:
				buttons[0][1].setText("O");
				break;
			case 2:
				buttons[0][2].setText("O");
				break;
			case 3:
				buttons[1][0].setText("O");
				break;
			case 4:
				buttons[1][1].setText("O");
				break;
			case 5:
				buttons[1][2].setText("O");
				break;
			case 6:
				buttons[2][0].setText("O");
				break;
			case 7:
				buttons[2][1].setText("O");
				break;
			case 8:
				buttons[2][2].setText("O");
				break;
			}

		return flag;
	}
}