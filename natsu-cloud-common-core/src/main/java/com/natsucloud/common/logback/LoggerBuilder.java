//package com.natsucloud.common.logback;
//
//import ch.qos.logback.classic.Level;
//import ch.qos.logback.classic.Logger;
//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.core.ConsoleAppender;
//import ch.qos.logback.core.rolling.RollingFileAppender;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * 编码模式的日志
// * ${LOG_HOME}需要在xml配置(或者后台通过其他方式获取)
// *
// * */
//@Component
//public class LoggerBuilder {
//    private ConcurrentHashMap<String, Logger> container = new ConcurrentHashMap<>();
//
//    public Logger getLogger(String name,Class<?> clazz) {
//        Logger logger = container.get(name);
//        if (logger != null) {
//            return logger;
//        }
//        synchronized (LoggerBuilder.class) {
//            logger = container.get(name);
//            if (logger != null) {
//                return logger;
//            }
//            logger = build(name,clazz);
//            container.put(name, logger);
//        }
//        return logger;
//    }
//
//    private Logger build(String name,Class<?> clazz) {
//        RollingFileAppender errorAppender = new AppenderFactory().createRollingFileAppender(name, Level.ERROR);
//        RollingFileAppender infoAppender = new AppenderFactory().createRollingFileAppender(name, Level.INFO);
//        RollingFileAppender debugAppender = new AppenderFactory().createRollingFileAppender(name, Level.DEBUG);
//        ConsoleAppender consoleAppender = new AppenderFactory().createConsoleAppender();
//        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
//        Logger logger = context.getLogger(clazz + " [" + name + "]");
//        //设置不向上级打印信息
//        logger.setAdditive(false);
//        logger.addAppender(errorAppender);
//        logger.addAppender(infoAppender);
//        logger.addAppender(debugAppender);
//        logger.addAppender(consoleAppender);
//
//        return logger;
//    }
//
//    /*@Autowired
//    private LoggerBuilder loggerBuilder;
//    org.slf4j.Logger logger2 = loggerBuilder.getLogger("name",SysUserController.class);
//    logger2.info("测试...我系{}","name");*/
//}