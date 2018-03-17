package com.igumnov.common;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LogTest {

    @Before
    public void before() {
        java.io.File d = new java.io.File("tmp");
        if (!d.exists()) {
            d.mkdir();
        } else {
            Folder.deleteWithContent("tmp");
            d.mkdir();
        }
    }


    @Test
    public void logTest () throws IOException {
        Log.setLogLevel(Log.INFO);
        Log.disableStdout();
        Log.file("tmp/test.log");
        Log.info("Info message");
        Log.error("Err message");
        Log.trace("Trace message");
        Log.debug("Debug message");
        Log.warn("Warn message");
        assertTrue(File.readAllToString("tmp/test.log").length() < 100);
        assertTrue(File.readAllToString("tmp/test.log").length() > 70);
    }
}
