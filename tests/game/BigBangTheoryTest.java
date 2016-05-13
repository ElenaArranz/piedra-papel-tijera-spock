package game;


import game.Rule.PossiblePlay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static game.Rule.PossiblePlay.*;
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
                {"Scissors vs. Scissors", SCISSORS, SCISSORS, Rule.DRAW},
                {"Scissors vs. Paper", SCISSORS, PAPER, Rule.WIN_LEFT},
                {"Scissors vs. Rock", SCISSORS, ROCK, Rule.WIN_RIGHT},
                {"Scissors vs. Spock", SCISSORS, SPOCK, Rule.WIN_RIGHT},
                {"Scissors vs. Lizard", SCISSORS, LIZARD, Rule.WIN_LEFT},

                {"Paper vs. Scissors", PAPER, SCISSORS, Rule.WIN_RIGHT},
                {"Paper vs. Paper", PAPER, PAPER, Rule.DRAW},
                {"Paper vs. Rock", PAPER, ROCK, Rule.WIN_LEFT},
                {"Paper vs. Spock", PAPER, SPOCK, Rule.WIN_LEFT},
                {"Paper vs. Lizard", PAPER, LIZARD, Rule.WIN_RIGHT},

                {"Rock vs. Scissors", ROCK, SCISSORS, Rule.WIN_LEFT},
                {"Rock vs. Paper", ROCK, PAPER, Rule.WIN_RIGHT},
                {"Rock vs. Rock", ROCK, ROCK, Rule.DRAW},
                {"Rock vs. Spock", ROCK, SPOCK, Rule.WIN_RIGHT},
                {"Rock vs. Lizard", ROCK, LIZARD, Rule.WIN_LEFT},

                {"Spock vs. Scissors", SPOCK, SCISSORS, Rule.WIN_LEFT},
                {"Spock vs. Paper", SPOCK, PAPER, Rule.WIN_RIGHT},
                {"Spock vs. Rock", SPOCK, ROCK, Rule.WIN_LEFT},
                {"Spock vs. Spock", SPOCK, SPOCK, Rule.DRAW},
                {"Spock vs. Lizard", SPOCK, LIZARD, Rule.WIN_RIGHT},

                {"Lizard vs. Scissors", LIZARD, SCISSORS, Rule.WIN_RIGHT},
                {"Lizard vs. Paper", LIZARD, PAPER, Rule.WIN_RIGHT},
                {"Lizard vs. Rock", LIZARD, ROCK, Rule.WIN_LEFT},
                {"Lizard vs. Spock", LIZARD, SPOCK, Rule.WIN_LEFT},
                {"Lizard vs. Lizard", LIZARD, LIZARD, Rule.DRAW},
        });
    }
}
