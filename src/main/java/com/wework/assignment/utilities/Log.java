package com.wework.assignment.utilities;

import org.apache.log4j.Logger;

public class Log {

    private final static Logger infoLogger = Logger.getLogger("infoLogger");
    private final static Logger debugLogger = Logger.getLogger("debugLogger");

    public static void debug(String msg) {
        infoLogger.debug(msg);
        debugLogger.debug(msg);
        System.out.println(msg);
    }

    public static void error(String msg) {
        infoLogger.error(msg);
        System.out.println(msg);
    }

    public static void error(String msg, Throwable e) {
        infoLogger.error(msg, e);
        System.out.println(msg);
    }

    public static void info(String msg) {
        infoLogger.info(msg);
        System.out.println(msg);
    }
}
