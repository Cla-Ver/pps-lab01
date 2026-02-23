import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final int ACCOUNT_ID = 1;
    private final int WRONG_ACCOUNT_ID = 2;
    private final double INITIAL_BALANCE = 0;
    private final double INITIAL_DEPOSIT = 100;


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", ACCOUNT_ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        final double SECOND_DEPOSIT_AMOUNT = 50;
        bankAccount.deposit(accountHolder.id(), INITIAL_DEPOSIT);
        bankAccount.deposit(WRONG_ACCOUNT_ID, SECOND_DEPOSIT_AMOUNT);
        assertEquals(INITIAL_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final double WITHDRAWAL_AMOUNT = 70;
        bankAccount.deposit(accountHolder.id(), INITIAL_DEPOSIT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAWAL_AMOUNT);
        assertEquals(INITIAL_DEPOSIT - WITHDRAWAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        final double WITHDRAWAL_AMOUNT = 70;
        bankAccount.deposit(accountHolder.id(), INITIAL_DEPOSIT);
        bankAccount.withdraw(WRONG_ACCOUNT_ID, WITHDRAWAL_AMOUNT);
        assertEquals(INITIAL_DEPOSIT, bankAccount.getBalance());
    }
}
