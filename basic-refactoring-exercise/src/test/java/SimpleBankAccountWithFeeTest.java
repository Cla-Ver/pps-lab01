import example.model.AccountHolder;
import example.model.SimpleBankAccountWithFee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithFeeTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithFee bankAccountWithFee;
    private final int ACCOUNT_ID = 1;
    private final double INITIAL_BALANCE = 0;
    private final double FEE_AMOUNT = 1;
    private final double INITIAL_DEPOSIT = 100;

    @BeforeEach
    void init(){
        accountHolder = new AccountHolder("Mario", "Rossi", ACCOUNT_ID);
        bankAccountWithFee = new SimpleBankAccountWithFee(accountHolder, INITIAL_BALANCE, FEE_AMOUNT);
    }
    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccountWithFee.getBalance());
    }
    @Test
    void testBalanceAfterWithdrawalWithFee(){
        final double WITHDRAWAL_AMOUNT = 10;
        bankAccountWithFee.deposit(ACCOUNT_ID, INITIAL_DEPOSIT);
        bankAccountWithFee.withdraw(ACCOUNT_ID, WITHDRAWAL_AMOUNT);
        assertEquals(INITIAL_DEPOSIT - WITHDRAWAL_AMOUNT - FEE_AMOUNT, bankAccountWithFee.getBalance());
    }


}
