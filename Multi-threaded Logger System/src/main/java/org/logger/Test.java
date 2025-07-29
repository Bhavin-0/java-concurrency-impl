package org.logger;

public class Test {
    public static void main(String[] args) {
        //creating 10 threads to access logger
        for(int i=0;i<10;i++){
            //Anonynms func to view that they are the same instances
            Thread thread = new Thread(()->{
                Logger logger = Logger.getLogger();
                System.out.println("Logger instance : " + logger.hashCode()+ " | Thread : " + Thread.currentThread().getName());
            });
            thread.start();
        }
    }
}
