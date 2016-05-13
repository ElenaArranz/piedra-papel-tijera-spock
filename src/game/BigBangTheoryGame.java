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

    private static final Map<String, Class<?extends Rule>> ruleForElement = new HashMap<String,Class<?extends Rule>>();
    static {ruleForElement.put(PAPER, PaperRules.class);
    };

    public int play(String left, String right){
        if (left.equals(right)) {
            return DRAW;
        } else if (left.equals(PAPER)) {
            // return new PaperRules().versus(right);
            Rule paperRule = null;
            try {
                paperRule = ruleForElement.get(left).newInstance();
                return paperRule.versus(right);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if (left.equals(ROCK)) {
            return rockVs(right);
        } else if (left.equals(LIZARD)) {
            return lizzardVs(right);
        } else if (left.equals(SPOCK)) {
            return spockVs(right);
        } else if (left.equals(SCISSORS)) {
            return scissorsVs(right);
        }
        return WIN_LEFT;
    }

    private int scissorsVs(String right) {
        if (right.equals(ROCK) || right.equals(SPOCK)) {
            return WIN_RIGHT;
        }
        return WIN_LEFT;
    }

    private int rockVs(String right) {
        if (right.equals(PAPER)) {
            return WIN_RIGHT;
        }
        return WIN_LEFT;
    }

    private int spockVs(String right) {
        if (right.equals(SCISSORS)) {
            return WIN_LEFT;
        }
        return WIN_RIGHT;
    }

    private int lizzardVs(String right) {
        if (right.equals(SPOCK)) {
            return WIN_LEFT;
        }
        return WIN_RIGHT;
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

    static class LizzardRules implements Rule {

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