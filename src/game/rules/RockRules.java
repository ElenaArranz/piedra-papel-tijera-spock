package game.rules;

import game.Rule;

import static game.BigBangTheoryGame.LIZARD;
import static game.BigBangTheoryGame.SCISSORS;

public class RockRules extends Rule {
    @Override
    protected String[] getWeakness() {
        return new String[]{SCISSORS, LIZARD};
    }
}