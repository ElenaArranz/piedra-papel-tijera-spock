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

    static class ScissorsRules extends Rule {
        @Override
        protected String[] getWeakness() {
            return new String[] {PAPER, LIZARD};
        }
    }

    static class SpockRules extends Rule {
        @Override
        protected String[] getWeakness() {
            return new String[] {SCISSORS, ROCK};
        }
    }

    static class PaperRules extends Rule {
        @Override
        protected String[] getWeakness() {
            return new String[] {ROCK, SPOCK};
        }
    }

    static class RockRules extends Rule {
        @Override
        protected String[] getWeakness() {
            return new String[] {SCISSORS, LIZARD};
        }
    }

    static class LizardRules extends Rule {
        @Override
        protected String[] getWeakness() {
            return new String[] {SPOCK, ROCK};
        }
    }
}