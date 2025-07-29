package org.logger;

public class Logger {
    //Volatile to ensure changes are visible to all the threads
    private static volatile Logger logger;

    //private constructor to prevent instantiation
    private Logger(){
        if(logger != null){
            throw new RuntimeException("Use getLogger() method instead of creating with new");
        }
    }

    //Global access method
    public static Logger getLogger() {
        if(logger == null){
            synchronized (Logger.class){
                //double check if logger still null ( another thread might have initialized it while waiting for the lock)
                if (logger == null){
                    logger = new Logger();
                }
            }
        }
        return logger;
    }
}
