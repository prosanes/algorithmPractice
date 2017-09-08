package com.prosanes.stringContainsStringPermutation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void simpleCase() {
        ArrayList<Integer> solution = new Solver("abbc", "abbc").solve();
        assertEquals(solution.size(), 1);
        assertEquals(solution.get(0), (Integer) 0);
    }

    @Test
    void simpleCasePlus1() {
        ArrayList<Integer> solution = new Solver("abbc", "abbca").solve();
        assertEquals(solution.size(), 2);
        assertEquals(solution.get(0), (Integer) 0);
        assertEquals(solution.get(1), (Integer) 1);
    }

    @Test
    void noMatches() {
        ArrayList<Integer> solution = new Solver("abbc", "abbba").solve();
        assertEquals(solution.size(), 0);
    }

    @Test
    void emptyB() {
        ArrayList<Integer> solution = new Solver("", "").solve();
        assertEquals(solution.size(), 0);
    }

    @Test
    void exampleFromBook() {
        ArrayList<Integer> solution = new Solver(
            "abbc",
            "cbabadcbbabbcbabaabccbabc"
        ).solve();
        assertEquals(solution.size(), 7);
        assertEquals(solution.get(0), (Integer) 0);
        assertEquals(solution.get(1), (Integer) 6);
        assertEquals(solution.get(2), (Integer) 9);
        assertEquals(solution.get(3), (Integer) 11);
        assertEquals(solution.get(4), (Integer) 12);
        assertEquals(solution.get(5), (Integer) 20);
        assertEquals(solution.get(6), (Integer) 21);
    }

    @Test
    void sAllEqual() {
        ArrayList<Integer> solution = new Solver(
                "cc",
                "ccbcbccbb"
        ).solve();
        assertEquals(solution.size(), 2);
        assertEquals(solution.get(0), (Integer) 0);
        assertEquals(solution.get(1), (Integer) 5);
    }
}