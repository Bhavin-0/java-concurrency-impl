package org.example;

import org.junit.jupiter.api.Test;
import org.logger.ConsoleLogger;
import org.logger.FileLogger;
import org.logger.LoggerLevel;
import org.logger.LoggerTarget;

import java.io.Console;

public class LoggerTest {
    @Test
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger(LoggerLevel.INFO);
        FileLogger fileLogger = new FileLogger(LoggerLevel.INFO);

        //Link the loggers :  consoleLogger -> fileLogger
        consoleLogger.setNextLogger(fileLogger);

        //msg for console logger
        consoleLogger.logMessage(LoggerLevel.INFO,"This is a console logger ",LoggerTarget.CONSOLE);
        fileLogger.logMessage(LoggerLevel.INFO,"This is a file logger ",LoggerTarget.FILE);
        fileLogger.logMessage(LoggerLevel.ERROR,"This is error form file logger ",LoggerTarget.FILE);
    }
}
