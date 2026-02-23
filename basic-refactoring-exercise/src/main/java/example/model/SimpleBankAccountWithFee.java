package example.model;

public class SimpleBankAccountWithFee implements BankAccount {

    private final SimpleBankAccount bankAccount;
    private final double fee;
    public SimpleBankAccountWithFee(AccountHolder ah, double balance, double fee){
        bankAccount = new SimpleBankAccount(ah, balance);
        this.fee = fee;
    }
    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        bankAccount.deposit(userID, amount);
    }

    @Override
    public void withdraw(int userID, double amount) {
        bankAccount.withdraw(userID, amount);
        bankAccount.withdraw(userID, fee);
    }
}
