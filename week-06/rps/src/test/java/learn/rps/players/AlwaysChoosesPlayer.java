package learn.rps.players;

import learn.rps.game.Throw;

// Double
public class AlwaysChoosesPlayer implements Player {

    private final Throw choice;

    public AlwaysChoosesPlayer(Throw choice) {
        this.choice = choice;
    }

    @Override
    public Throw shoot() {
        return choice;
    }
}
