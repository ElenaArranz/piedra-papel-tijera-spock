package game.rules;

import game.Rule;

import static game.Rule.PossiblePlay.*;


public class ScissorsRules extends Rule {
    @Override
    protected PossiblePlay[] getWeakness() {
        return new PossiblePlay[]{PAPER, LIZARD};
    }
}

