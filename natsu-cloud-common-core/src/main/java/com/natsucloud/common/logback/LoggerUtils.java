package com.natsucloud.common.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志工具类
 * 该类缺陷显示行号不是是当前类的行号
 * */
public class LoggerUtils {

    private static final Map<String, Logger> container = new HashMap<>();

    private static Logger getLogger(String name) {
        Logger logger = container.get(name);
        if(logger != null) {
            return logger;
        }
        synchronized (LoggerUtils.class) {
            logger = container.get(name);
            if(logger != null) {
                return logger;
            }
            logger = build(name);
            container.put(name,logger);
        }
        return logger;
    }

    private static Logger build(String name) {
        Logger logger = LoggerFactory.getLogger(getClassName());
        return logger;
    }

    public static void error(String msg) {

        LocationAwareLogger logger = (LocationAwareLogger)LoggerFactory.getLogger(getClassName());
//        Throwable throwable = new Throwable();
//        StackTraceElement[] ste = throwable.getStackTrace();
//        for (StackTraceElement stackTraceElement : ste) {
//            System.out
//                    .println("ClassName: " + stackTraceElement.getClassName());
//            System.out.println("Method Name: "
//                    + stackTraceElement.getMethodName());
//            System.out.println("Line number: "
//                    + stackTraceElement.getLineNumber());
//        }

        logger.error(msg);
    }

    public static void error(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).error(msg, obj);
    }

    public static void warn(String msg) {
        LoggerFactory.getLogger(getClassName()).warn(msg);
    }

    public static void warn(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).warn(msg, obj);
    }

    public static void info(String msg) {
        LoggerFactory.getLogger(getClassName()).info(msg);
    }

    public static void info(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).info(msg, obj);
    }

    public static void debug(String msg) {
        LoggerFactory.getLogger(getClassName()).debug(msg);
    }

    public static void debug(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).debug(msg, obj);
    }

    // 获取调用 error,info,debug静态类的类名
    private static String getClassName() {
        return new SecurityManager() {
            public String getClassName() {
                return getClassContext()[3].getName();
            }
        }.getClassName();
    }
}
