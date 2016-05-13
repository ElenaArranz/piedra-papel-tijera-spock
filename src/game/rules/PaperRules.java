package game.rules;

import game.BigBangTheoryGame;
import game.Rule;


public class PaperRules extends Rule {
    @Override
    protected BigBangTheoryGame.PossiblePlay[] getWeakness() {
        return new BigBangTheoryGame.PossiblePlay[]{BigBangTheoryGame.PossiblePlay.ROCK, BigBangTheoryGame.PossiblePlay.SPOCK};
    }
}
