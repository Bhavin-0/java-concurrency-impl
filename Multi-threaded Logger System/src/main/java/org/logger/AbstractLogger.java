package org.logger;

public abstract class AbstractLogger {
    protected LoggerLevel level;
    private AbstractLogger nextLogger;

    //Setter to pass nextLogger - used to link logger together
    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(LoggerLevel level, String message, LoggerTarget target){
        if(this.level == level){
            display(message,target);
        }

        if(nextLogger != null){
            nextLogger.logMessage(level,message,target);
        }
    }


    protected abstract void display(String message, LoggerTarget target);
}
