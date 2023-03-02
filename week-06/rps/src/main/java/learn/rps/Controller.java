package learn.rps;

import learn.rps.game.Game;
import learn.rps.players.ComputerPlayer;
import learn.rps.players.HumanPlayer;
import learn.rps.players.Player;

public class Controller {

    public void run() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println();

        do {
            play();
        } while (ConsoleIO.readInt("Play again? [1=yes,0=no]: ", 0, 1) == 1);

        System.out.println();
        System.out.println("Goodbye.");
    }

    private void play() {
        // 1. who is human, cpu
        Player one = getPlayer(1);
        Player two = getPlayer(2);

        // 2. create the game
        int rounds = ConsoleIO.readInt("How many rounds do you want to play? [1-25]: ", 1, 25);
        Game game = new Game(one, two, rounds);

        // 3. run the game
        game.play();
    }

    private Player getPlayer(int playerNumber) {
        System.out.printf("Player %s is:%n", playerNumber);
        System.out.println("1. Human");
        System.out.println("2. A Computer");
        int choice = ConsoleIO.readInt("Select [1-2]: ", 1, 2);
        System.out.println();
        if (choice == 1) {
            return new HumanPlayer();
        }

        return new ComputerPlayer();
    }
}
