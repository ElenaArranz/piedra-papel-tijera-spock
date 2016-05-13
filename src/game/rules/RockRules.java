package game.rules;

import game.Rule;

import static game.Rule.PossiblePlay.*;


public class RockRules extends Rule {
    @Override
    protected PossiblePlay[] getWeakness() {
        return new PossiblePlay[]{SCISSORS, LIZARD};
    }
}