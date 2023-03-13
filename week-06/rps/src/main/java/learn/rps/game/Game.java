package learn.rps.game;

import learn.rps.players.Player;

public class Game {

    private final Player one;
    private final Player two;
    private final int rounds;
    private int playerOneWin = 0;
    private int tie = 0;
    private int playerTwoWin = 0;

    public Game(Player one, Player two, int rounds) {
        this.one = one;
        this.two = two;
        this.rounds = rounds;
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            int result = playRound();
            if (result == 0) {
                System.out.println("It's a tie.");
                tie++;
            } else if (result > 0) {
                System.out.println("Player 1 wins the round.");
                playerOneWin++;
            } else {
                System.out.println("Player 2 wins the round.");
                playerTwoWin++;
            }
            System.out.println();
        }
        summarize();
    }

    protected int playRound() {

        Throw p1Choice = makeChoice(1, one);
        Throw p2Choice = makeChoice(2, two);

        if (p1Choice == p2Choice) {
            return 0;
        } else if ((p1Choice == Throw.ROCK && p2Choice == Throw.SCISSORS)
                || (p1Choice == Throw.PAPER && p2Choice == Throw.ROCK)
                || (p1Choice == Throw.SCISSORS && p2Choice == Throw.PAPER)) {
            return 1;
        }
        return -1;
    }

    private Throw makeChoice(int playerNumber, Player player) {
        System.out.printf("Player %s go!%n", playerNumber);
        Throw choice = player.shoot();
        System.out.printf("Player %s chooses %s.%n", playerNumber, choice.getName());
        System.out.println();
        return choice;
    }

    private void summarize() {
        System.out.println("Results -------");
        System.out.printf("Rounds: %s%n", rounds);
        System.out.printf("Player 1 wins: %s%n", playerOneWin);
        System.out.printf("Player 2 wins: %s%n", playerTwoWin);
        System.out.printf("Ties: %s%n", tie);
    }
}
