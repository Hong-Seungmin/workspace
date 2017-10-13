
public class MineSweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minemine g1 = new minemine();
		
		g1.init();
		g1.set_board();
		g1.count_board();
		g1.print_board();
		g1.print_count();
	}
}

class minemine {
	boolean[][] board;
	int[][] count;

	void init() {
		board = new boolean[10][10];
		count = new int[10][10];
	}
	
	void print_board(){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				if (board[i][j])
					System.out.print("# ");
				else
					System.out.print(". ");
			System.out.println();
		}
	}

	void print_count(){
		System.out.println();
		System.out.println();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				if (board[i][j])
					System.out.print(". ");
				else
					System.out.print(count[i][j] + " ");
			System.out.println();
		}
	}
	
	void set_board() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				if (Math.random() < 0.3)
					board[i][j] = true;
	}

	void count_board() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				if (board[i][j]) {
					// j가 0이면 좌측벽 9이면 우측벽
					if ((j != 0) && (j != 9)) {
						// i가 0이면 천장 9이면 바닥
						if ((i != 0) && (i != 9)) {
							count[i - 1][j - 1]++;
							count[i - 1][j]++;
							count[i - 1][j + 1]++;
							count[i][j - 1]++;
							count[i][j + 1]++;
							count[i + 1][j - 1]++;
							count[i + 1][j]++;
							count[i + 1][j + 1]++;
						} else if (i == 9) {
							count[i - 1][j - 1]++;
							count[i - 1][j]++;
							count[i - 1][j + 1]++;
							count[i][j - 1]++;
							count[i][j + 1]++;
						} else if (i == 0) {
							count[i][j - 1]++;
							count[i][j + 1]++;
							count[i + 1][j - 1]++;
							count[i + 1][j]++;
							count[i + 1][j + 1]++;
						}
					} else if (j == 0) {
						if ((i != 0) && (i != 9)) {
							count[i - 1][j]++;
							count[i - 1][j + 1]++;
							count[i][j + 1]++;
							count[i + 1][j]++;
							count[i + 1][j + 1]++;
						} else if (i == 9) {
							count[i - 1][j]++;
							count[i - 1][j + 1]++;
							count[i][j + 1]++;
						} else if (i == 0) {
							count[i][j + 1]++;
							count[i + 1][j]++;
							count[i + 1][j + 1]++;
						}
					} else if (j == 9) {
						if ((i != 0) && (i != 9)) {
							count[i - 1][j - 1]++;
							count[i - 1][j]++;
							count[i][j - 1]++;
							count[i + 1][j - 1]++;
							count[i + 1][j]++;
						} else if (i == 9) {
							count[i - 1][j - 1]++;
							count[i - 1][j]++;
							count[i][j - 1]++;

						} else if (i == 0) {
							count[i][j - 1]++;
							count[i + 1][j - 1]++;
							count[i + 1][j]++;
						}
					}
				}
	}
}