package game;

import java.util.Arrays;

public abstract class Rule {

    public static final int DRAW = 0;
    public static final int WIN_LEFT = 1;
    public static final int WIN_RIGHT = -1;

    protected abstract PossiblePlay[] getWeakness();

    public int versus(PossiblePlay right) {
        if (Arrays.asList(getWeakness()).contains(right)) {
            return WIN_LEFT;
        }
        return WIN_RIGHT;
    }

    public static enum PossiblePlay {SCISSORS, ROCK, PAPER, LIZARD, SPOCK}
}
