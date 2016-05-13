package game;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static game.BigBangTheoryGame.*;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class BigBangTheoryTest {

    private final String left;
    private final String right;
    private final int result;
    private final String testName;

    public BigBangTheoryTest(String testName, String left, String right, int result){
            this.testName = testName;
            this.left = left;
            this.right = right;
            this.result = result;
        }

        @Test
        public void testGame(){
            BigBangTheoryGame game = new BigBangTheoryGame();
            assertEquals(testName, result, game.play(left, right));
        }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Scissors vs. Scissors",  SCISSORS, SCISSORS, DRAW},
                {"Scissors vs. Paper",  SCISSORS, PAPER, WIN_LEFT},
                {"Scissors vs. Rock",  SCISSORS, ROCK, WIN_RIGHT},
                {"Scissors vs. Spock",  SCISSORS, SPOCK, WIN_RIGHT},
                {"Scissors vs. Lizard",  SCISSORS, LIZARD, WIN_LEFT},

                {"Paper vs. Scissors",  PAPER, SCISSORS, WIN_RIGHT},
                {"Paper vs. Paper",  PAPER, PAPER, DRAW},
                {"Paper vs. Rock",  PAPER, ROCK, WIN_LEFT},
                {"Paper vs. Spock",  PAPER, SPOCK, WIN_LEFT},
                {"Paper vs. Lizard",  PAPER, LIZARD, WIN_RIGHT},

                {"Rock vs. Scissors",  ROCK, SCISSORS, WIN_LEFT},
                {"Rock vs. Paper",  ROCK, PAPER, WIN_RIGHT},
                {"Rock vs. Rock",  ROCK, ROCK, DRAW},
                {"Rock vs. Spock",  ROCK, SPOCK, WIN_RIGHT},
                {"Rock vs. Lizard",  ROCK, LIZARD, WIN_LEFT},

                {"Spock vs. Scissors",  SPOCK, SCISSORS, WIN_LEFT},
                {"Spock vs. Paper",  SPOCK, PAPER, WIN_RIGHT},
                {"Spock vs. Rock",  SPOCK, ROCK, WIN_LEFT},
                {"Spock vs. Spock",  SPOCK, SPOCK, DRAW},
                {"Spock vs. Lizard",  SPOCK, LIZARD, WIN_RIGHT},

                {"Lizard vs. Scissors",  LIZARD, SCISSORS, WIN_RIGHT},
                {"Lizard vs. Paper",  LIZARD, PAPER, WIN_RIGHT},
                {"Lizard vs. Rock",  LIZARD, ROCK, WIN_LEFT},
                {"Lizard vs. Spock",  LIZARD, SPOCK, WIN_LEFT},
                {"Lizard vs. Lizard",  LIZARD, LIZARD, DRAW},
        });
    }
}
