package bank;

public class BankAccount {
	private int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public void deposit(int money) {
		this.balance = this.balance + money;
		System.out.println(money+"���� �Ա��Ͽ����ϴ�.");
	}

	public void withdraw(int money) {
		try{
			if(money>balance)
				throw new NegativeBalanceException("�ܾ��� �����մϴ�.");
			
		this.balance = this.balance - money;
		System.out.println(money+"���� ����Ͽ����ϴ�.");
		}
		catch(NegativeBalanceException e){
			System.out.println("�ܾ��� �����մϴ�.");
		}
	}
	
	public int getBalance(){
		return balance;
	}
}
