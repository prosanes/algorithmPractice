package com.prosanes.stringContainsStringPermutation;

public class Runner {
    private String toRun = "";
    private int left = 0;
    private int right = -1;
    private int maxSeparation = -1;
    public enum Stepped { LEFT, RIGHT };
    public class Step {
        public Character c;
        public Stepped stepped;
        public Step(Character c, Stepped s) { this.c = c; stepped = s; }
    }

    public Runner(String toRun, int maxSeparation) {
        this.toRun = toRun;
        this.maxSeparation = maxSeparation;
    }

    public Step oneStep() {
        Step step;

        if (isEnd()) return null;

        if (right - (left-1) >= maxSeparation && !isFirstStep()) {
            step = new Step(getLeftChar(), Stepped.LEFT);
            left++;
        } else {
            right++;
            step = new Step(getRightChar(), Stepped.RIGHT);
        }

        return step;
    }

    private boolean isEnd() {
        return right >= (toRun.length() - 1);
    }

    private boolean isFirstStep() {
       return right == -1;
    }

    private Character getLeftChar() {
        return toRun.charAt(left);
    }

    public Character getRightChar() {
        return toRun.charAt(right);
    }

    public Integer getMatchIndex() {
        return (Integer) left;
    }

}
