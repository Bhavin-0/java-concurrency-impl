package org.logger;

public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(LoggerLevel level){
        this.level = level;
    }

    @Override
    protected void display(String message, LoggerTarget target) {
        if(target == LoggerTarget.CONSOLE){
            System.out.println("[ ConsoleLogger - " + level + " ] " + message);
        }
    }
}
