package game.rules;

import game.Rule;

import static game.Rule.PossiblePlay.*;


public class SpockRules extends Rule {
    @Override
    protected PossiblePlay[] getWeakness() {
        return new PossiblePlay[]{SCISSORS, ROCK};
    }
}