package game.rules;

import game.Rule;

import static game.BigBangTheoryGame.ROCK;
import static game.BigBangTheoryGame.SPOCK;

public class LizardRules extends Rule {
    @Override
    protected String[] getWeakness() {
        return new String[]{SPOCK, ROCK};
    }
}