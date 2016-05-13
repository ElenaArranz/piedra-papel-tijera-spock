package game.rules;

import game.BigBangTheoryGame;
import game.Rule;


public class RockRules extends Rule {
    @Override
    protected BigBangTheoryGame.PossiblePlay[] getWeakness() {
        return new BigBangTheoryGame.PossiblePlay[]{BigBangTheoryGame.PossiblePlay.SCISSORS, BigBangTheoryGame.PossiblePlay.LIZARD};
    }
}