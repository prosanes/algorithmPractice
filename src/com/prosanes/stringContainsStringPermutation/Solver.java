package com.prosanes.stringContainsStringPermutation;

import java.util.ArrayList;

public class Solver {
    private Runner runner;
    private Counter counter;
    private boolean empty = false;
    ArrayList<Integer> matches = new ArrayList<>();

    public Solver(String s, String b) {
        if (b.length() == 0) empty = true;
        runner = new Runner(b, s.length());
        counter = new Counter(s);
    }

    public ArrayList<Integer> solve() {
        Runner.Step step;

        if (empty) return matches;

        while ((step = runner.oneStep()) != null) {
            if (step.stepped == Runner.Stepped.RIGHT) {
                counter.increment(step.c);
                checkAndAddMatch();
            } else if (step.stepped == Runner.Stepped.LEFT) {
                counter.decrement(step.c);
            }
        }

        return matches;
    }

    private void checkAndAddMatch() {
        if (counter.isMatch()) {
            matches.add(runner.getMatchIndex());
        }
    }
}
