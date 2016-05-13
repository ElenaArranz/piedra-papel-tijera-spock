package game;

import org.junit.BeforeClass;
import org.junit.Test;

import static game.BigBangTheoryGame.*;
import static org.junit.Assert.assertEquals;


public class InitialTest {

    private final String left;
    private final String right;
    private final int result;

    public InitialTest(String left, String right, int result){
        this.left = left;
        this.right = right;
        this.result = result;
    }

    static BigBangTheoryGame game = null;

    @BeforeClass
    public static void initial() {
        game = new BigBangTheoryGame();
    }

    @Test
    public void thereIsDraw() {
        assertEquals(DRAW, game.play("X", "X"));
    }

    @Test
    public void thereIsNotDraw() {
        assertEquals(WIN_LEFT, game.play("Y", "X"));
    }

    @Test
    public void scissorsWinsPaper() {
        assertEquals(WIN_LEFT, game.play(SCISSORS, PAPER));
    }

    @Test
    public void paperLosesScissors() {
        assertEquals(WIN_RIGHT, game.play(PAPER, SCISSORS));
    }

    @Test
    public void paperWinsRock() {
        assertEquals(WIN_LEFT, game.play(PAPER, ROCK));
    }

    @Test
    public void rockLosesPaper() {
        assertEquals(WIN_RIGHT, game.play(ROCK, PAPER));
    }

    @Test
    public void rockWinsLizard() {
        assertEquals(WIN_LEFT, game.play(ROCK, LIZARD));
    }

    @Test
    public void lizardLosesRock() {
        assertEquals(WIN_RIGHT, game.play(LIZARD, ROCK));
    }

    @Test
    public void lizardWinsSpock() {
        assertEquals(WIN_LEFT, game.play(LIZARD, SPOCK));
    }

    @Test
    public void spockLosesLizard() {
        assertEquals(WIN_RIGHT, game.play(SPOCK, LIZARD));
    }

    @Test
    public void spockWinsScissors() {
        assertEquals(WIN_LEFT, game.play(SPOCK, SCISSORS));
    }

    @Test
    public void scissorWinsLizard() {
        assertEquals(WIN_LEFT, game.play(SCISSORS, LIZARD));
    }

    @Test
    public void lizardLoseScissors() {
        assertEquals(WIN_RIGHT, game.play(LIZARD, SCISSORS));
    }

    @Test
    public void scissorsLoseRock() {
        assertEquals(WIN_RIGHT, game.play(SCISSORS, ROCK));
    }
}