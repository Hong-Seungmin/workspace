package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel;
		int money;
		
		BankAccount acc = new BankAccount(1000000);
		while(true){
			try{
			System.out.println("1.입금 2.출금 0.종료");
			sel = sc.nextInt();
			
			switch(sel){
			case 1:
				System.out.println("입금액을 입력하세요 : ");
				money = sc.nextInt();
				acc.deposit(money);
				System.out.println("잔액"+acc.getBalance());
				break;
			case 2:
				System.out.println("출금액을 입력하세요 : ");
				money = sc.nextInt();
				acc.withdraw(money);
				System.out.println("잔액"+acc.getBalance());
				break;
			case 0:
				return;
			default:
				System.out.println("잘못입력하였습니다.");
			}
			}
			catch(InputMismatchException e){
				System.out.println("잘못입력하였습니다.");
				sc.nextLine();
			}
		}
	}

}
