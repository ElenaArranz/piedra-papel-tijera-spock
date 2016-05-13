package game;

import java.util.Arrays;

import static game.BigBangTheoryGame.WIN_LEFT;
import static game.BigBangTheoryGame.WIN_RIGHT;

public abstract class Rule {

    protected abstract String[] getWeakness();

    public int versus(String right) {
        if (Arrays.asList(getWeakness()).contains(right)) {
            return WIN_LEFT;
        }
        return WIN_RIGHT;
    }
}
