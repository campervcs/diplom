package com.igumnov.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest {

    @Test
    public void testRandom() {
        for (int i = 1; i < 100; ++i) {
            int rndInt = Number.randomIntByRange(-1, 10);
            assertTrue("randomIntByRange", rndInt >= -1 && rndInt <= 10);
            long rndLong = Number.randomLongByRange(-1L, 10L);
            assertTrue("randomLongByRange", rndLong >= -1 && rndLong <= 10);
            double rndDouble = Number.randomDoubleByRange(-1.0, 10.0);
            assertTrue("randomDoubleByRange", rndDouble >= -1 && rndDouble <= 10);

        }
    }

}
