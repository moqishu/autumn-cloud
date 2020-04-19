package com.natsucloud.common.logback;

import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

/**
 *
 *
 * */
public class LogHelper {

    /**空数组*/
    private static final Object[] EMPTY_ARRAY = new Object[] {};
    /**全类名*/
    private static final String FQCN = LogHelper.class.getName();

    private static LocationAwareLogger getLogger() {
        JavaLangAccess access = SharedSecrets.getJavaLangAccess();
        Throwable throwable = new Throwable();
        StackTraceElement frame = access.getStackTraceElement(throwable, 2);
        return (LocationAwareLogger) LoggerFactory.getLogger(frame.getClassName());
    }

    public static void debug(String message){
        getLogger().log(null,FQCN,LocationAwareLogger.DEBUG_INT,message,EMPTY_ARRAY,null);
    }

    public static void info(String message){
        getLogger().log(null,FQCN,LocationAwareLogger.INFO_INT,message,EMPTY_ARRAY,null);
    }

    public static void error(String message){
        getLogger().log(null,FQCN,LocationAwareLogger.ERROR_INT,message,EMPTY_ARRAY,null);
    }

    public static void warn(String message){
        getLogger().log(null,FQCN,LocationAwareLogger.WARN_INT,message,EMPTY_ARRAY,null);
    }
}
