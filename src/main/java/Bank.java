import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

	Map<String, BankAccount> accounts = new HashMap<>();

	public void add(BankAccount account) {
		accounts.put(account.getAccountNumber(), account);

	}

	public BankAccount findAccount(String accountNum) {

		return accounts.get(accountNum);
	}

	public Collection<BankAccount> getAllAccounts() {
		// TODO Auto-generated method stub
		return accounts.values();
	}

	public void close(BankAccount account) {
		accounts.remove(account.getAccountNumber(), account);
	}

	public void withdraw(String accountNumber, int amount) {
		BankAccount withdrawFromAccount = findAccount(accountNumber);
		withdrawFromAccount.withdraw(amount);

	}
}
