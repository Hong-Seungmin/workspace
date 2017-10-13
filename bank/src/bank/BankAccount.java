package bank;

public class BankAccount {
	private int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public void deposit(int money) {
		this.balance = this.balance + money;
		System.out.println(money+"원을 입금하였습니다.");
	}

	public void withdraw(int money) {
		try{
			if(money>balance)
				throw new NegativeBalanceException("잔액이 부족합니다.");
			
		this.balance = this.balance - money;
		System.out.println(money+"원을 출금하였습니다.");
		}
		catch(NegativeBalanceException e){
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	public int getBalance(){
		return balance;
	}
}
