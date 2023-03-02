package learn.rps.players;

import learn.rps.game.Throw;

import java.util.Random;

public class ComputerPlayer implements Player {

    private final Random random = new Random();
    private Throw[] choices = Throw.values();

    @Override
    public Throw shoot() {
        return choices[random.nextInt(choices.length)];
    }
}
