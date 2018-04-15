package com.wework.assignment.utilities;

import org.apache.log4j.Logger;

public class Log {

    private final static Logger logger = Logger.getLogger(Log.class);

    public static void debug(String msg) {
        logger.debug(msg);
        System.out.println(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
        System.out.println(msg);
    }

    public static void error(String msg, Throwable e) {
        logger.error(msg, e);
        System.out.println(msg);
    }

    public static void info(String msg) {
        logger.info(msg);
        System.out.println(msg);
    }
}
