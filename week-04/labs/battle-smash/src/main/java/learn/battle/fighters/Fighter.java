package learn.battle.fighters;

public class Fighter {

    private final String name;
    private int balance = 100;

    private final String specialAttack;

    public Fighter(String name, String specialAttack) {
        this.name = name;
        this.specialAttack = specialAttack;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOut() {
        return balance <= 0;
    }

    public void reduceBalance(int amount) {
        balance -= amount;
    }
}
