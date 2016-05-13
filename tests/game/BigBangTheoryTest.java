package game;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static game.BigBangTheoryGame.*;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BigBangTheoryTest {

    private final PossiblePlay left;
    private final PossiblePlay right;
    private final int result;
    private final String testName;

    public BigBangTheoryTest(String testName, PossiblePlay left, PossiblePlay right, int result) {
        this.testName = testName;
        this.left = left;
        this.right = right;
        this.result = result;
    }

    @Test
    public void testGame() {
        BigBangTheoryGame game = new BigBangTheoryGame();
        assertEquals(testName, result, game.play(left, right));
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Scissors vs. Scissors", PossiblePlay.SCISSORS, PossiblePlay.SCISSORS, DRAW},
                {"Scissors vs. Paper", PossiblePlay.SCISSORS, PossiblePlay.PAPER, WIN_LEFT},
                {"Scissors vs. Rock", PossiblePlay.SCISSORS, PossiblePlay.ROCK, WIN_RIGHT},
                {"Scissors vs. Spock", PossiblePlay.SCISSORS, PossiblePlay.SPOCK, WIN_RIGHT},
                {"Scissors vs. Lizard", PossiblePlay.SCISSORS, PossiblePlay.LIZARD, WIN_LEFT},

                {"Paper vs. Scissors", PossiblePlay.PAPER, PossiblePlay.SCISSORS, WIN_RIGHT},
                {"Paper vs. Paper", PossiblePlay.PAPER, PossiblePlay.PAPER, DRAW},
                {"Paper vs. Rock", PossiblePlay.PAPER, PossiblePlay.ROCK, WIN_LEFT},
                {"Paper vs. Spock", PossiblePlay.PAPER, PossiblePlay.SPOCK, WIN_LEFT},
                {"Paper vs. Lizard", PossiblePlay.PAPER, PossiblePlay.LIZARD, WIN_RIGHT},

                {"Rock vs. Scissors", PossiblePlay.ROCK, PossiblePlay.SCISSORS, WIN_LEFT},
                {"Rock vs. Paper", PossiblePlay.ROCK, PossiblePlay.PAPER, WIN_RIGHT},
                {"Rock vs. Rock", PossiblePlay.ROCK, PossiblePlay.ROCK, DRAW},
                {"Rock vs. Spock", PossiblePlay.ROCK, PossiblePlay.SPOCK, WIN_RIGHT},
                {"Rock vs. Lizard", PossiblePlay.ROCK, PossiblePlay.LIZARD, WIN_LEFT},

                {"Spock vs. Scissors", PossiblePlay.SPOCK, PossiblePlay.SCISSORS, WIN_LEFT},
                {"Spock vs. Paper", PossiblePlay.SPOCK, PossiblePlay.PAPER, WIN_RIGHT},
                {"Spock vs. Rock", PossiblePlay.SPOCK, PossiblePlay.ROCK, WIN_LEFT},
                {"Spock vs. Spock", PossiblePlay.SPOCK, PossiblePlay.SPOCK, DRAW},
                {"Spock vs. Lizard", PossiblePlay.SPOCK, PossiblePlay.LIZARD, WIN_RIGHT},

                {"Lizard vs. Scissors", PossiblePlay.LIZARD, PossiblePlay.SCISSORS, WIN_RIGHT},
                {"Lizard vs. Paper", PossiblePlay.LIZARD, PossiblePlay.PAPER, WIN_RIGHT},
                {"Lizard vs. Rock", PossiblePlay.LIZARD, PossiblePlay.ROCK, WIN_LEFT},
                {"Lizard vs. Spock", PossiblePlay.LIZARD, PossiblePlay.SPOCK, WIN_LEFT},
                {"Lizard vs. Lizard", PossiblePlay.LIZARD, PossiblePlay.LIZARD, DRAW},
        });
    }
}
