import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class theater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int s;
		int z,x;
		Scanner sc = new Scanner(System.in);

		List list = new ArrayList();
		
		System.out.println("영화관 수를 입력하세요.");
		n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			System.out.print("영화관 좌석 수를 입력하세요. n m");
			z = sc.nextInt();
			x = sc.nextInt();
			list.add(new DVD_Room(z,x));
			((DVD_Room)list.get(i)).init();
		}
		
		while(true){
			System.out.println("예약할 관을 선택하세요.");
			s = sc.nextInt();
			if(s>n)
				continue;
			
			((DVD_Room)list.get(s)).print();
			
			System.out.println("원하시는 좌석번호를 입력하세요.n m");	
			z = sc.nextInt();
			x = sc.nextInt();
			
			if(((DVD_Room)list.get(s)).reserve(z,x))
				System.out.println("예약이 완료되었습니다.");
			else
				System.out.println("이미 예약된 자리입니다.");
		}
	}
}

class DVD_Room {
	int[][] room;
	int n, m;
	
	DVD_Room(int n, int m){
		this.n = n;
		this.m = m;
	}
	void init(){
		room = new int[n][m];
		for(int i=0; i<n;i++)
			for(int j=0; j<m;j++)
				room[i][j]=0;
	}

	boolean reserve(int n, int m) {
		if (this.n < n && this.m < m) {
			if (room[n][m] == 0) {
				room[n][m] = 1;
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	void print(){
		for(int i=0; i<m*3;i++)
			System.out.print("-");
		System.out.println();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++)
				System.out.print(j + "  ");
			System.out.println();
		}
		
		for(int i=0; i<m*3;i++)
			System.out.print("-");
		System.out.println();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++)
				System.out.print(room[i][j] + "  ");
			System.out.println();
		}
	}
}