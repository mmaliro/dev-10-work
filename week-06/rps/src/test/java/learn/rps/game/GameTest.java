package learn.rps.game;

import learn.rps.players.AlwaysChoosesPlayer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {

    @ParameterizedTest
    @MethodSource("choiceResultProvider")
    void shouldPlayRound(Throw one, Throw two, int expected) {
        AlwaysChoosesPlayer p1 = new AlwaysChoosesPlayer(one);
        AlwaysChoosesPlayer p2 = new AlwaysChoosesPlayer(two);
        Game game = new Game(p1, p2, 1);
        int actual = game.playRound();
        assertEquals(expected, actual);
    }


    static Stream<Arguments> choiceResultProvider() {
        return Stream.of(
                arguments(Throw.ROCK, Throw.ROCK, 0),
                arguments(Throw.PAPER, Throw.PAPER, 0),
                arguments(Throw.SCISSORS, Throw.SCISSORS, 0),
                arguments(Throw.ROCK, Throw.SCISSORS, 1),
                arguments(Throw.PAPER, Throw.ROCK, 1),
                arguments(Throw.SCISSORS, Throw.PAPER, 1),
                arguments(Throw.ROCK, Throw.PAPER, -1),
                arguments(Throw.PAPER, Throw.SCISSORS, -1),
                arguments(Throw.SCISSORS, Throw.ROCK, -1)
        );
    }
}