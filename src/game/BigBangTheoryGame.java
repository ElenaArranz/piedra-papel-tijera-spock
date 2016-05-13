package game;

import game.rules.*;

import java.util.HashMap;
import java.util.Map;

public class BigBangTheoryGame {

    public static enum PossiblePlay {SCISSORS, ROCK, PAPER, LIZARD, SPOCK}

    public static final int DRAW = 0;
    public static final int WIN_LEFT = 1;
    public static final int WIN_RIGHT = -1;

    private static final Map<PossiblePlay, Class<? extends Rule>> ruleForElement = new HashMap<PossiblePlay, Class<? extends Rule>>();

    static {
        ruleForElement.put(PossiblePlay.SCISSORS, ScissorsRules.class);
        ruleForElement.put(PossiblePlay.ROCK, RockRules.class);
        ruleForElement.put(PossiblePlay.PAPER, PaperRules.class);
        ruleForElement.put(PossiblePlay.LIZARD, LizardRules.class);
        ruleForElement.put(PossiblePlay.SPOCK, SpockRules.class);
    }

    ;

    public int play(PossiblePlay left, PossiblePlay right) {
        if (left.equals(right)) return DRAW;

        Rule paperRule = null;
        try {
            paperRule = ruleForElement.get(left).newInstance();
            return paperRule.versus(right);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return DRAW;
    }
}