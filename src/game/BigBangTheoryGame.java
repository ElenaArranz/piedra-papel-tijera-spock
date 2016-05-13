package game;

import java.util.HashMap;
import java.util.Map;

public class BigBangTheoryGame {

    public static final String SCISSORS = "SCISSORS";
    public static final String ROCK = "ROCK";
    public static final String PAPER = "PAPER";
    public static final String LIZARD = "LIZARD";
    public static final String SPOCK = "SPOCK";

    public static final int DRAW = 0;
    public static final int WIN_LEFT = 1;
    public static final int WIN_RIGHT = -1;

    private static final Map<String, Class<? extends Rule>> ruleForElement = new HashMap<String, Class<? extends Rule>>();

    static {
        ruleForElement.put(SCISSORS, ScissorsRules.class);
        ruleForElement.put(ROCK, RockRules.class);
        ruleForElement.put(PAPER, PaperRules.class);
        ruleForElement.put(LIZARD, LizardRules.class);
        ruleForElement.put(SPOCK, SpockRules.class);
    }

    ;

    public int play(String left, String right) {
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

    static class ScissorsRules implements Rule {
        @Override
        public int versus(String right) {
            if (right.equals(PAPER) || right.equals(LIZARD)) {
                return WIN_LEFT;
            }
            return WIN_RIGHT;
        }
    }

    static class SpockRules implements Rule {
        @Override
        public int versus(String right) {
            if (right.equals(SCISSORS) || right.equals(ROCK)) {
                return WIN_LEFT;
            }
            return WIN_RIGHT;
        }
    }

    static class PaperRules implements Rule {
        @Override
        public int versus(String right) {
            if (right.equals(ROCK) || right.equals(SPOCK)) {
                return WIN_LEFT;
            }
            return WIN_RIGHT;
        }
    }

    static class RockRules implements Rule {
        @Override
        public int versus(String right) {
            if (right.equals(SCISSORS) || right.equals(LIZARD)) {
                return WIN_LEFT;
            }
            return WIN_RIGHT;
        }
    }

    static class LizardRules implements Rule {
        @Override
        public int versus(String right) {
            if (right.equals(ROCK) || right.equals(SPOCK)) {
                return WIN_LEFT;
            }
            return WIN_RIGHT;
        }
    }

    interface Rule {
        public int versus(String right);
    }
}