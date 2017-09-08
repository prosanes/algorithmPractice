package com.prosanes.stringContainsStringPermutation;

import java.util.HashMap;

public class Counter {
    public HashMap<Character, CurrentAndMax> charCounter = new HashMap<>();
    public int totalOk;
    private int totalChars;

    public Counter(String toFind) {
        totalOk = 0;
        totalChars = toFind.length();
        toFind.chars()
            .mapToObj(i -> (char)i)
            .forEach(c -> {
                CurrentAndMax value = charCounter.get(c);
                if (value == null) {
                    charCounter.put(c, new CurrentAndMax(0 ,1));
                } else {
                    value.max += 1;
                }
            });
    }

    public void increment(Character c) {
        CurrentAndMax curMax = charCounter.getOrDefault(c, new CurrentAndMax(0, 0));
        charCounter.putIfAbsent(c, curMax);
        curMax.current += 1;
        if (curMax.current <= curMax.max) {
            totalOk += 1;
        }
    }

    public void decrement(Character c) {
        CurrentAndMax curMax = charCounter.get(c);
        if (curMax.current <= curMax.max) {
            totalOk -= 1;
        }
        curMax.current -= 1;
    }

    public boolean isMatch() {
        return totalOk == totalChars;
    }

    public class CurrentAndMax {
        public int current;
        public int max;

        public CurrentAndMax(int current, int max) {
            this.current = current;
            this.max = max;
        }
    }
}
