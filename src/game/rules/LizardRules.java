package game.rules;

import game.BigBangTheoryGame;
import game.Rule;


public class LizardRules extends Rule {
    @Override
    protected BigBangTheoryGame.PossiblePlay[] getWeakness() {
        return new BigBangTheoryGame.PossiblePlay[]{BigBangTheoryGame.PossiblePlay.SPOCK, BigBangTheoryGame.PossiblePlay.ROCK};
    }
}