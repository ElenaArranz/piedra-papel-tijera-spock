package game.rules;

import game.Rule;

import static game.Rule.PossiblePlay.*;


public class PaperRules extends Rule {
    @Override
    protected PossiblePlay[] getWeakness() {
        return new PossiblePlay[]{ROCK, SPOCK};
    }
}
