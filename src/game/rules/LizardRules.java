package game.rules;

import game.Rule;

import static game.Rule.PossiblePlay.*;


public class LizardRules extends Rule {
    @Override
    protected PossiblePlay[] getWeakness() {
        return new PossiblePlay[]{SPOCK, ROCK};
    }
}