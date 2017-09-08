package com.prosanes.stringContainsStringPermutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @Test
    public void constructorTest() {
        Counter c = new Counter("abbc");
        assertEquals(1, c.charCounter.get('a').max);
        assertEquals(2, c.charCounter.get('b').max);
        assertEquals(1, c.charCounter.get('c').max);
    }

}