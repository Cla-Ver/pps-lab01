import example.model.AccountHolder;
import example.model.SimpleBankAccountWithFee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithFeeTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithFee bankAccountWithFee;
    private double INITIAL_BALANCE = 0;
    private double INITIAL_DEPOSIT = 100;

    @BeforeEach
    void init(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccountWithFee = new SimpleBankAccountWithFee(accountHolder, INITIAL_BALANCE);
    }
    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccountWithFee.getBalance());
    }

}
