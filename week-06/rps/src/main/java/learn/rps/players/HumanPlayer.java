package learn.rps.players;

import learn.rps.ConsoleIO;
import learn.rps.game.Throw;

public class HumanPlayer implements Player {

    @Override
    public Throw shoot() {

        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        int choice = ConsoleIO.readInt("Select [1-3]: ", 1, 3);

        return Throw.values()[choice - 1];
    }
}
