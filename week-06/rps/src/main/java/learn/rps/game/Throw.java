package learn.rps.game;

public enum Throw {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String name;

    Throw(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
