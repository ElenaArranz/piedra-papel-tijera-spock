package game.rules;

import game.Rule;

import static game.BigBangTheoryGame.ROCK;
import static game.BigBangTheoryGame.SCISSORS;

public class SpockRules extends Rule {
    @Override
    protected String[] getWeakness() {
        return new String[]{SCISSORS, ROCK};
    }
}