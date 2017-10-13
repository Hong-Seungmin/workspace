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
			System.out.println("1.�Ա� 2.��� 0.����");
			sel = sc.nextInt();
			
			switch(sel){
			case 1:
				System.out.println("�Աݾ��� �Է��ϼ��� : ");
				money = sc.nextInt();
				acc.deposit(money);
				System.out.println("�ܾ�"+acc.getBalance());
				break;
			case 2:
				System.out.println("��ݾ��� �Է��ϼ��� : ");
				money = sc.nextInt();
				acc.withdraw(money);
				System.out.println("�ܾ�"+acc.getBalance());
				break;
			case 0:
				return;
			default:
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
			}
			catch(InputMismatchException e){
				System.out.println("�߸��Է��Ͽ����ϴ�.");
				sc.nextLine();
			}
		}
	}

}
