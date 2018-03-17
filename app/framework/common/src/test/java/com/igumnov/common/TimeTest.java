package com.igumnov.common;


import static org.junit.Assert.*;

import com.igumnov.common.time.TimeException;
import org.junit.Test;

public class TimeTest {
    @Test
    public void testPauseInSeconds() throws TimeException {
        Benchmark.timerStart();
        Time.pauseInSeconds(1);
        long pause1 = Benchmark.timerStop();
        assertTrue(pause1 >= 1000 && pause1 <= 1500);

        Benchmark.timerStart();
        Time.pauseInSeconds(0.5);
        long pause2 = Benchmark.timerStop();
        assertTrue(pause2 >= 500 && pause2 <= 1000);

    }

    @Test
    public void testTimerStartPauseResumeStop() throws Exception {
        Benchmark.timerStart();
        Time.pauseInSeconds(1);
        long pause1 = Benchmark.timerPause();
        assertTrue("1 sec", pause1 >= 1000 && pause1 <= 1500);

        Time.pauseInSeconds(0.5);
        Benchmark.timerResume();
        Time.pauseInSeconds(0.5);
        long pause2 = Benchmark.timerPause();
        assertTrue("1.5 sec", pause2 >= 1500 && pause2 <= 2000);

        Time.pauseInSeconds(1);
        Benchmark.timerResume();
        Time.pauseInSeconds(1);
        long pause3 = Benchmark.timerStop();
        assertTrue("2.5 sec", pause3 >= 2500 && pause3 <= 3000);


    }


    @Test
    public void testTimerStartPauseResumeStopByName() throws Exception {
        String name = "test";
        Benchmark.timerStart(name);
        Time.pauseInSeconds(1);
        long pause1 = Benchmark.timerPause(name);
        assertTrue("1 sec", pause1 >= 1000 && pause1 <= 1500);

        Time.pauseInSeconds(0.5);
        Benchmark.timerResume(name);
        Time.pauseInSeconds(0.5);
        long pause2 = Benchmark.timerPause(name);
        assertTrue("1.5 sec", pause2 >= 1500 && pause2 <= 2000);

        Time.pauseInSeconds(1);
        Benchmark.timerResume(name);
        Time.pauseInSeconds(1);
        long pause3 = Benchmark.timerStop(name);
        assertTrue("2.5 sec", pause3 >= 2500 && pause3 <= 3000);


    }


    @Test
    public void testTimerStop() throws Exception {
        try {
            Benchmark.timerStop();
        } catch (Exception e) {
            assertTrue(true);
        }
    }


    @Test
    public void testTimerPause() throws Exception {
        try {
            Benchmark.timerPause();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testTimerResume() throws Exception {
        try {
            Benchmark.timerResume();
        } catch (Exception e) {
            assertTrue(true);
        }
    }


    @Test
    public void testTimerStartResume() throws Exception {
        try {
            Benchmark.timerStart();
            Benchmark.timerResume();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRepeatCase() throws TimeException {

        for (int i = 0; i < 100; ++i) {
            Benchmark.timerBegin("loop2");
            Time.sleepInSeconds(0.01);
            Benchmark.timerEnd("loop2");
        }
        assertEquals(Benchmark.timerGetRepeatCount("loop2"), 100);
        assertTrue("timerGetAverageTime", (Benchmark.timerGetAverageTime("loop2")) < Benchmark.timerGetTotalTime("loop2") * 0.1);
        assertTrue("timerGetTotalTime", (Benchmark.timerGetAverageTime("loop2")) * 100 * 0.9 < Benchmark.timerGetTotalTime("loop2"));
        assertTrue("timerGetTotalTime", (Benchmark.timerGetAverageTime("loop2")) * 100 * 1.1 > Benchmark.timerGetTotalTime("loop2"));

    }


}