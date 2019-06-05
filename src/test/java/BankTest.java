import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Collection;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	Bank underTest;
	BankAccount account1;
	BankAccount account2;

	@Before

	public void setUp() {
		underTest = new Bank();
		account1 = new BankAccount("1", "checking", 100);
		account2 = new BankAccount("2", "Saving", 100);
	}

	@Test
	public void shouldBeAbleToAddAccount() {
		underTest.add(account1);
		BankAccount retrievedAccount = underTest.findAccount("1");
		assertThat(retrievedAccount, is(account1));
	}

	@Test
	public void shouldBeAbleToAddTwoAccounts() {
		underTest.add(account1);
		underTest.add(account2);
		Collection<BankAccount> allAccounts = underTest.getAllAccounts();
		assertThat(allAccounts,containsInAnyOrder(account1, account2));
		assertEquals(2, allAccounts.size());
		// another way to test: assertEquals(2, allAccounts.size());
	}

	@Test
	public void shouldBeAbleToCloseAnAccount() {
		underTest.add(account1);
		underTest.add(account2);
		BankAccount retrievedAccount = underTest.findAccount(account1.getAccountNumber());
		assertThat(retrievedAccount, is(IsNull.nullValue()));
	}

	@Test
	public void shouldWithdrawFromAccount() {
		underTest.add(account1);
		underTest.withdraw(account1.getAccountNumber(), 50);
		assertThat(account1.getBalance(), is(50));
	}
}
