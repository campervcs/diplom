package com.igumnov.common;

import java.io.IOException;
import java.util.Date;

public class Log {
    public static final int TRACE = 0;
    public static final int DEBUG = 1;
    public static final int WARN = 2;
    public static final int INFO = 3;
    public static final int ERROR = 4;
    private static int logLevel = 3;
    private static boolean stdout = true;
    private static String file = null;

    public static void setLogLevel(int l) {
        logLevel = l;
    }

    public static void disableStdout() {
        stdout = false;
    }

    public static void file(String fileName) {
        file = fileName;
    }

    public static void info(String message) {
        if (logLevel <= INFO) {
            out(message, INFO);
        }
    }

    public static void error(String message) {
        if (logLevel <= ERROR) {
            out(message, ERROR);
        }
    }

    public static void trace(String message) {
        if (logLevel <= TRACE) {
            out(message, TRACE);
        }
    }

    public static void debug(String message) {
        if (logLevel <= DEBUG) {
            out(message, DEBUG);
        }

    }

    public static void warn(String message) {
        if (logLevel <= WARN) {
            out(message, WARN);
        }
    }

    public static void info(String message, Exception e) {
        if (logLevel <= INFO) {
            out(message + " " + Reflection.stackTraceToString(e), INFO);
        }
    }

    public static void error(String message, Exception e) {
        if (logLevel <= ERROR) {
            out(message + " " + Reflection.stackTraceToString(e), ERROR);
        }
    }

    public static void trace(String message, Exception e) {
        if (logLevel <= TRACE) {
            out(message + " " + Reflection.stackTraceToString(e), TRACE);
        }
    }

    public static void debug(String message, Exception e) {
        if (logLevel <= DEBUG) {
            out(message + " " + Reflection.stackTraceToString(e), DEBUG);
        }

    }

    public static void warn(String message, Exception e) {
        if (logLevel <= WARN) {
            out(message + " " + Reflection.stackTraceToString(e), WARN);
        }
    }

    private static void out(String message, int level) {
        String levelTxt;
        switch (level) {
            case Log.DEBUG:
                levelTxt = "DEBUG";
                break;
            case Log.TRACE:
                levelTxt = "TRACE";
                break;
            case Log.INFO:
                levelTxt = "INFO";
                break;
            case Log.ERROR:
                levelTxt = "ERROR";
                break;
            case Log.WARN:
                levelTxt = "WARN";
                break;
            default:
                levelTxt="UNKNOWN";

        }

        String line = new Date() + " " + levelTxt + " " + message;
        if (stdout) {
            System.out.println(line);
        }

        if (file != null) {
            try {
                File.appendLine(line, file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
