public class Vault implements MoneyStorage{

    private double balance;
    private String description;

    public Vault(double balance, String description) {
        this.balance = balance;
        this.description = description;
    }

    /**
     * @return the current balance
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * @return a description of the MoneyStorage
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * @param amount money to add to the balance.
     * @return true if the deposit was successful, false if not.
     */
    @Override
    public boolean deposit(double amount) {
        if(amount >= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    /**
     * @param amount money to remove from the balance.
     * @return the amount of money successfully withdrawn.
     * May not be the full parameter amount if rules doesn't allow it.
     */
    @Override
    public double withdraw(double amount) {
        if(balance - amount < 0) {
            amount = balance;
            balance = 0;
            return amount;
        }
        balance -= amount;
        return amount;
    }

    @Override
    public void setMoneyStorage(Wallet myWallet) {

    }

    @Override
    public MoneyStorage getMoneyStorage() {
        return null;
    }
}
