package example.model;

public class SimpleBankAccountWithFee implements BankAccount {

    private final SimpleBankAccount bankAccount;
    public SimpleBankAccountWithFee(AccountHolder ah, double balance){
        bankAccount = new SimpleBankAccount(ah, balance);
    }
    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
