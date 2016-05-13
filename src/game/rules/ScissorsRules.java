package game.rules;

import game.BigBangTheoryGame;
import game.Rule;


public class ScissorsRules extends Rule {
    @Override
    protected BigBangTheoryGame.PossiblePlay[] getWeakness() {
        return new BigBangTheoryGame.PossiblePlay[]{BigBangTheoryGame.PossiblePlay.PAPER, BigBangTheoryGame.PossiblePlay.LIZARD};
    }
}

