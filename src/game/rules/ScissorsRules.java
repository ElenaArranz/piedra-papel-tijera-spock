package game.rules;

import game.Rule;

import static game.BigBangTheoryGame.LIZARD;
import static game.BigBangTheoryGame.PAPER;

public class ScissorsRules extends Rule {
    @Override
    protected String[] getWeakness() {
        return new String[]{PAPER, LIZARD};
    }
}

