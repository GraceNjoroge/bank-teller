
public class BankAccount {

	private String accountNumber;
	private int balance;

	public BankAccount(String accountNumber, String string2, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;

	}

	public String getAccountNumber() {

		return accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
	balance -=amount;

	}
}
