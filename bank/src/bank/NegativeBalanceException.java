package bank;

public class NegativeBalanceException extends Exception{

	public NegativeBalanceException(String e) {
		super(e);
	}
}
