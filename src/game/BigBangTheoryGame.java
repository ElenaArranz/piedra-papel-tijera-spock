package game;

import game.Rule.PossiblePlay;
import game.rules.*;

import java.util.HashMap;
import java.util.Map;

import static game.Rule.PossiblePlay.*;

public class BigBangTheoryGame {

    private static final Map<PossiblePlay, Class<? extends Rule>> ruleForElement = new HashMap<PossiblePlay, Class<? extends Rule>>();

    static {
        ruleForElement.put(SCISSORS, ScissorsRules.class);
        ruleForElement.put(ROCK, RockRules.class);
        ruleForElement.put(PAPER, PaperRules.class);
        ruleForElement.put(LIZARD, LizardRules.class);
        ruleForElement.put(SPOCK, SpockRules.class);
    }

    ;

    public int play(PossiblePlay left, PossiblePlay right) {
        if (left.equals(right)) return Rule.DRAW;

        Rule paperRule = null;
        try {
            paperRule = ruleForElement.get(left).newInstance();
            return paperRule.versus(right);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return Rule.DRAW;
    }
}