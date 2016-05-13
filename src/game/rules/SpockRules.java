package game.rules;

import game.BigBangTheoryGame;
import game.Rule;


public class SpockRules extends Rule {
    @Override
    protected BigBangTheoryGame.PossiblePlay[] getWeakness() {
        return new BigBangTheoryGame.PossiblePlay[]{BigBangTheoryGame.PossiblePlay.SCISSORS, BigBangTheoryGame.PossiblePlay.ROCK};
    }
}