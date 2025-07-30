package org.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger extends AbstractLogger{

    private static final String LOG_DIR = "logs";
    private static final String LOG_FILE = "logs/logs.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public FileLogger(LoggerLevel level){
        this.level = level;
        createLogDirectory();
    }

    private void createLogDirectory(){
        File directory = new File(LOG_DIR);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }

    @Override
    protected void display(String message,LoggerTarget target){
        if(target == LoggerTarget.FILE){
            String timeStamp = LocalDateTime.now().format(FORMATTER);
            String logMessage = String.format("[ %s ] [ FileLogger - %s ] %s", timeStamp,level,message);

            try(FileWriter writer = new FileWriter(LOG_FILE,true)){
                writer.write(logMessage + System.lineSeparator());
            }catch (Exception e){
                System.err.println("ERROR - Writing in a file " + e.getCause().getMessage());
            }
        }
    }

}
