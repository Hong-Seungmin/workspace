import java.util.Scanner;

public class Tic_Tac_Toe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gamepan g1 = new gamepan();
		
		g1.init();
		while(g1.set_com()){
			g1.print();
			g1.set_user();
		}
	}
}

class gamepan {
	char[][] pan;
	int[] rank;

	void init() {
		pan = new char[3][3];
		rank = new int[9];

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				pan[i][j] = ' ';
		for (int i = 0; i < 9; i++)
			rank[i] = 0;
	}
	
	void set_user(){
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("다음 수의 좌표를 입력하시오");
			int x = scan.nextInt();
			int y = scan.nextInt();

			if (pan[x][y] != ' ') {
				System.out.println("잘못된 위치입니다.");
				continue;
			} else{
				pan[x][y] = 'X';
				break;
			}
		}
	}

	void print(){
		for (int i = 0; i < 3; i++) {
			System.out.println("  " + pan[i][0] + "|  " + pan[i][1] + "|  " + pan[i][2]);
			if (i != 2)
				System.out.println("---|---|---");
		}
	}
	
	boolean set_com() {
		////////////////// 주변에 빈칸이 많은가? 최소랭크
		if (pan[0][0] == ' ') {
			if (pan[0][1] == ' ' && pan[0][2] == ' ') {
				rank[0]++;
			}
			if (pan[1][1] == ' ' && pan[1][2] == ' ') {
				rank[0]++;
			}
			if (pan[1][0] == ' ' && pan[2][0] == ' ') {
				rank[0]++;
			}
		}
		if (pan[0][1] == ' ') {
			if (pan[1][1] == ' ' && pan[2][1] == ' ') {
				rank[1]++;
			}
			if (pan[0][0] == ' ' && pan[0][2] == ' ') {
				rank[1]++;
			}
		}
		if (pan[0][2] == ' ') {
			if (pan[0][0] == ' ' && pan[0][1] == ' ') {
				rank[2]++;
			}
			if (pan[1][1] == ' ' && pan[2][0] == ' ') {
				rank[2]++;
			}
			if (pan[1][2] == ' ' && pan[2][2] == ' ') {
				rank[2]++;
			}
		}
		if (pan[1][0] == ' ') {
			if (pan[0][0] == ' ' && pan[2][0] == ' ') {
				rank[3]++;
			}
			if (pan[1][1] == ' ' && pan[1][2] == ' ') {
				rank[3]++;
			}
		}
		if (pan[1][1] == ' ') {
			if (pan[0][0] == ' ' && pan[2][2] == ' ') {
				rank[4]++;
			}
			if (pan[0][1] == ' ' && pan[2][1] == ' ') {
				rank[4]++;
			}
			if (pan[0][2] == ' ' && pan[2][0] == ' ') {
				rank[4]++;
			}
			if (pan[1][0] == ' ' && pan[1][2] == ' ') {
				rank[4]++;
			}
		}
		if (pan[1][2] == ' ') {
			if (pan[0][2] == ' ' && pan[2][2] == ' ') {
				rank[5]++;
			}
			if (pan[1][0] == ' ' && pan[1][1] == ' ') {
				rank[5]++;
			}
		}
		if (pan[2][0] == ' ') {
			if (pan[0][0] == ' ' && pan[1][0] == ' ') {
				rank[6]++;
			}
			if (pan[1][1] == ' ' && pan[0][2] == ' ') {
				rank[6]++;
			}
			if (pan[2][1] == ' ' && pan[2][2] == ' ') {
				rank[6]++;
			}
		}
		if (pan[2][1] == ' ') {
			if (pan[0][1] == ' ' && pan[1][1] == ' ') {
				rank[7]++;
			}
			if (pan[2][0] == ' ' && pan[2][2] == ' ') {
				rank[7]++;
			}
		}
		if (pan[2][2] == ' ') {
			if (pan[0][0] == ' ' && pan[1][1] == ' ') {
				rank[8]++;
			}
			if (pan[0][2] == ' ' && pan[1][2] == ' ') {
				rank[8]++;
			}
			if (pan[2][0] == ' ' && pan[2][1] == ' ') {
				rank[8]++;
			}
		}
		///////////////// 주변에 'O'이 있는가? 최소랭크
		if (pan[0][0] == ' ') {
			if (pan[0][1] == 'O' || pan[0][2] == 'O') {
				rank[0]++;
			}
			if (pan[1][1] == 'O' || pan[1][2] == 'O') {
				rank[0]++;
			}
			if (pan[1][0] == 'O' || pan[2][0] == 'O') {
				rank[0]++;
			}
		}
		if (pan[0][1] == ' ') {
			if (pan[1][1] == 'O' || pan[2][1] == 'O') {
				rank[1]++;
			}
			if (pan[0][0] == 'O' || pan[0][2] == 'O') {
				rank[1]++;
			}
		}
		if (pan[0][2] == ' ') {
			if (pan[0][0] == 'O' || pan[0][1] == 'O') {
				rank[2]++;
			}
			if (pan[1][1] == 'O' || pan[2][0] == 'O') {
				rank[2]++;
			}
			if (pan[1][2] == 'O' || pan[2][2] == 'O') {
				rank[2]++;
			}
		}
		if (pan[1][0] == ' ') {
			if (pan[0][0] == 'O' || pan[2][0] == 'O') {
				rank[3]++;
			}
			if (pan[1][1] == 'O' || pan[1][2] == 'O') {
				rank[3]++;
			}
		}
		if (pan[1][1] == ' ') {
			if (pan[0][0] == 'O' || pan[2][2] == 'O') {
				rank[4]++;
			}
			if (pan[0][1] == 'O' || pan[2][1] == 'O') {
				rank[4]++;
			}
			if (pan[0][2] == 'O' || pan[2][0] == 'O') {
				rank[4]++;
			}
			if (pan[1][0] == 'O' || pan[1][2] == 'O') {
				rank[4]++;
			}
		}
		if (pan[1][2] == ' ') {
			if (pan[0][2] == 'O' || pan[2][2] == 'O') {
				rank[5]++;
			}
			if (pan[1][0] == 'O' || pan[1][1] == 'O') {
				rank[5]++;
			}
		}
		if (pan[2][0] == ' ') {
			if (pan[0][0] == 'O' || pan[1][0] == 'O') {
				rank[6]++;
			}
			if (pan[1][1] == 'O' || pan[0][2] == 'O') {
				rank[6]++;
			}
			if (pan[2][1] == 'O' || pan[2][2] == 'O') {
				rank[6]++;
			}
		}
		if (pan[2][1] == ' ') {
			if (pan[0][1] == 'O' || pan[1][1] == 'O') {
				rank[7]++;
			}
			if (pan[2][0] == 'O' || pan[2][2] == 'O') {
				rank[7]++;
			}
		}
		if (pan[2][2] == ' ') {
			if (pan[0][0] == 'O' || pan[1][1] == 'O') {
				rank[8]++;
			}
			if (pan[0][2] == 'O' || pan[1][2] == 'O') {
				rank[8]++;
			}
			if (pan[2][0] == 'O' || pan[2][1] == 'O') {
				rank[8]++;
			}
		}
		///////////////// 주변에 'X'가 1개라도 있는가? 랭크감소
		if (pan[0][0] == ' ') {
			if (pan[0][1] == 'X' || pan[0][2] == 'X') {
				rank[0]--;
			}
			if (pan[1][1] == 'X' || pan[1][2] == 'X') {
				rank[0]--;
			}
			if (pan[1][0] == 'X' || pan[2][0] == 'X') {
				rank[0]--;
			}
		}
		if (pan[0][1] == ' ') {
			if (pan[1][1] == 'X' || pan[2][1] == 'X') {
				rank[1]--;
			}
			if (pan[0][0] == 'X' || pan[0][2] == 'X') {
				rank[1]--;
			}
		}
		if (pan[0][2] == ' ') {
			if (pan[0][0] == 'X' || pan[0][1] == 'X') {
				rank[2]--;
			}
			if (pan[1][1] == 'X' || pan[2][0] == 'X') {
				rank[2]--;
			}
			if (pan[1][2] == 'X' || pan[2][2] == 'X') {
				rank[2]--;
			}
		}
		if (pan[1][0] == ' ') {
			if (pan[0][0] == 'X' || pan[2][0] == 'X') {
				rank[3]--;
			}
			if (pan[1][1] == 'X' || pan[1][2] == 'X') {
				rank[3]--;
			}
		}
		if (pan[1][1] == ' ') {
			if (pan[0][0] == 'X' || pan[2][2] == 'X') {
				rank[4]--;
			}
			if (pan[0][1] == 'X' || pan[2][1] == 'X') {
				rank[4]--;
			}
			if (pan[0][2] == 'X' || pan[2][0] == 'X') {
				rank[4]--;
			}
			if (pan[1][0] == 'X' || pan[1][2] == 'X') {
				rank[4]--;
			}
		}
		if (pan[1][2] == ' ') {
			if (pan[0][2] == 'X' || pan[2][2] == 'X') {
				rank[5]--;
			}
			if (pan[1][0] == 'X' || pan[1][1] == 'X') {
				rank[5]--;
			}
		}
		if (pan[2][0] == ' ') {
			if (pan[0][0] == 'X' || pan[1][0] == 'X') {
				rank[6]--;
			}
			if (pan[1][1] == 'X' || pan[0][2] == 'X') {
				rank[6]--;
			}
			if (pan[2][1] == 'X' || pan[2][2] == 'X') {
				rank[6]--;
			}
		}
		if (pan[2][1] == ' ') {
			if (pan[0][1] == 'X' || pan[1][1] == 'X') {
				rank[7]--;
			}
			if (pan[2][0] == 'X' || pan[2][2] == 'X') {
				rank[7]--;
			}
		}
		if (pan[2][2] == ' ') {
			if (pan[0][0] == 'X' || pan[1][1] == 'X') {
				rank[8]--;
			}
			if (pan[0][2] == 'X' || pan[1][2] == 'X') {
				rank[8]--;
			}
			if (pan[2][0] == 'X' || pan[2][1] == 'X') {
				rank[8]--;
			}
		}
		///////////////// 주변에 'O'가 2개 연달아 있는가? 최고랭크
		if (pan[0][0] == ' ') {
			if (pan[0][1] == 'O' && pan[0][2] == 'O') {
				rank[0] += 100;
			}
			if (pan[1][1] == 'O' && pan[1][2] == 'O') {
				rank[0] += 100;
			}
			if (pan[1][0] == 'O' && pan[2][0] == 'O') {
				rank[0] += 100;
			}
		}
		if (pan[0][1] == ' ') {
			if (pan[1][1] == 'O' && pan[2][1] == 'O') {
				rank[1] += 100;
			}
			if (pan[0][0] == 'O' && pan[0][2] == 'O') {
				rank[1] += 100;
			}
		}
		if (pan[0][2] == ' ') {
			if (pan[0][0] == 'O' && pan[0][1] == 'O') {
				rank[2] += 100;
			}
			if (pan[1][1] == 'O' && pan[2][0] == 'O') {
				rank[2] += 100;
			}
			if (pan[1][2] == 'O' && pan[2][2] == 'O') {
				rank[2] += 100;
			}
		}
		if (pan[1][0] == ' ') {
			if (pan[0][0] == 'O' && pan[2][0] == 'O') {
				rank[3] += 100;
			}
			if (pan[1][1] == 'O' && pan[1][2] == 'O') {
				rank[3] += 100;
			}
		}
		if (pan[1][1] == ' ') {
			if (pan[0][0] == 'O' && pan[2][2] == 'O') {
				rank[4] += 100;
			}
			if (pan[0][1] == 'O' && pan[2][1] == 'O') {
				rank[4] += 100;
			}
			if (pan[0][2] == 'O' && pan[2][0] == 'O') {
				rank[4] += 100;
			}
			if (pan[1][0] == 'O' && pan[1][2] == 'O') {
				rank[4] += 100;
			}
		}
		if (pan[1][2] == ' ') {
			if (pan[0][2] == 'O' && pan[2][2] == 'O') {
				rank[5] += 100;
			}
			if (pan[1][0] == 'O' && pan[1][1] == 'O') {
				rank[5] += 100;
			}
		}
		if (pan[2][0] == ' ') {
			if (pan[0][0] == 'O' && pan[1][0] == 'O') {
				rank[6] += 100;
			}
			if (pan[1][1] == 'O' && pan[0][2] == 'O') {
				rank[6] += 100;
			}
			if (pan[2][1] == 'O' && pan[2][2] == 'O') {
				rank[6] += 100;
			}
		}
		if (pan[2][1] == ' ') {
			if (pan[0][1] == 'O' && pan[1][1] == 'O') {
				rank[7] += 100;
			}
			if (pan[2][0] == 'O' && pan[2][2] == 'O') {
				rank[7] += 100;
			}
		}
		if (pan[2][2] == ' ') {
			if (pan[0][0] == 'O' && pan[1][1] == 'O') {
				rank[8] += 100;
			}
			if (pan[0][2] == 'O' && pan[1][2] == 'O') {
				rank[8] += 100;
			}
			if (pan[2][0] == 'O' && pan[2][1] == 'O') {
				rank[8] += 100;
			}
		}
		///////////////// 주변에 'X'가 2개 연달아 있는가? 중간랭크
		if (pan[0][0] == ' ') {
			if (pan[0][1] == 'X' && pan[0][2] == 'X') {
				rank[0] += 50;
			}
			if (pan[1][1] == 'X' && pan[1][2] == 'X') {
				rank[0] += 50;
			}
			if (pan[1][0] == 'X' && pan[2][0] == 'X') {
				rank[0] += 50;
			}
		}
		if (pan[0][1] == ' ') {
			if (pan[1][1] == 'X' && pan[2][1] == 'X') {
				rank[1] += 50;
			}
			if (pan[0][0] == 'X' && pan[0][2] == 'X') {
				rank[1] += 50;
			}
		}
		if (pan[0][2] == ' ') {
			if (pan[0][0] == 'X' && pan[0][1] == 'X') {
				rank[2] += 50;
			}
			if (pan[1][1] == 'X' && pan[2][0] == 'X') {
				rank[2] += 50;
			}
			if (pan[1][2] == 'X' && pan[2][2] == 'X') {
				rank[2] += 50;
			}
		}
		if (pan[1][0] == ' ') {
			if (pan[0][0] == 'X' && pan[2][0] == 'X') {
				rank[3] += 50;
			}
			if (pan[1][1] == 'X' && pan[1][2] == 'X') {
				rank[3] += 50;
			}
		}
		if (pan[1][1] == ' ') {
			if (pan[0][0] == 'X' && pan[2][2] == 'X') {
				rank[4] += 50;
			}
			if (pan[0][1] == 'X' && pan[2][1] == 'X') {
				rank[4] += 50;
			}
			if (pan[0][2] == 'X' && pan[2][0] == 'X') {
				rank[4] += 50;
			}
			if (pan[1][0] == 'X' && pan[1][2] == 'X') {
				rank[4] += 50;
			}
		}
		if (pan[1][2] == ' ') {
			if (pan[0][2] == 'X' && pan[2][2] == 'X') {
				rank[5] += 50;
			}
			if (pan[1][0] == 'X' && pan[1][1] == 'X') {
				rank[5] += 50;
			}
		}
		if (pan[2][0] == ' ') {
			if (pan[0][0] == 'X' && pan[1][0] == 'X') {
				rank[6] += 50;
			}
			if (pan[1][1] == 'X' && pan[0][2] == 'X') {
				rank[6] += 50;
			}
			if (pan[2][1] == 'X' && pan[2][2] == 'X') {
				rank[6] += 50;
			}
		}
		if (pan[2][1] == ' ') {
			if (pan[0][1] == 'X' && pan[1][1] == 'X') {
				rank[7] += 50;
			}
			if (pan[2][0] == 'X' && pan[2][2] == 'X') {
				rank[7] += 50;
			}
		}
		if (pan[2][2] == ' ') {
			if (pan[0][0] == 'X' && pan[1][1] == 'X') {
				rank[8] += 50;
			}
			if (pan[0][2] == 'X' && pan[1][2] == 'X') {
				rank[8] += 50;
			}
			if (pan[2][0] == 'X' && pan[2][1] == 'X') {
				rank[8] += 50;
			}
		}
		/////////////////
		int tmp = 0;
		boolean flag = false;

		System.out.println("우선순위");
		for (int i = 0; i < 9; i++) {
			System.out.println(i + "번칸 :" + rank[i]);
			if (rank[tmp] < rank[i]) {
				tmp = i;
				flag = true;
			}
		}

		if (tmp == 0 && rank[0] > 0)
			flag = true;

		System.out.println("선택 칸:" + tmp);
		if (flag)
			switch (tmp) {
			case 0:
				pan[0][0] = 'O';
				break;
			case 1:
				pan[0][1] = 'O';
				break;
			case 2:
				pan[0][2] = 'O';
				break;
			case 3:
				pan[1][0] = 'O';
				break;
			case 4:
				pan[1][1] = 'O';
				break;
			case 5:
				pan[1][2] = 'O';
				break;
			case 6:
				pan[2][0] = 'O';
				break;
			case 7:
				pan[2][1] = 'O';
				break;
			case 8:
				pan[2][2] = 'O';
				break;
			}

		return flag;
	}
}