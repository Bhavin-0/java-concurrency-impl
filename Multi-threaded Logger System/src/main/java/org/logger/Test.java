package org.logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void case1(){
        //CASE 1 : creating 10 threads to access logger
        for(int i=0;i<10;i++){
            //Anonymsms func to view that they are the same instances
            Thread thread = new Thread(()->{
                Logger logger = Logger.getLogger();
                System.out.println("Logger instance : " + logger.hashCode()+ " | Thread : " + Thread.currentThread().getName());
            });
            thread.start();
        }
    }

    //CASE 2 : To view the exception
    public static void case2 (){
        Thread thread = new Thread(()->{
           try {
               Logger first = Logger.getLogger();

               //using Reflection to break the singleton design
               Constructor<Logger> constructor = Logger.class.getDeclaredConstructor();
               constructor.setAccessible(true);

               //this will throw RunTimeException from Constructor
               Logger second = constructor.newInstance();
               System.out.println("Second Logger : " + second.hashCode());
           }catch (Exception re){
//               System.err.println("caught Exception : " + re.getCause().getMessage()) ;
               re.printStackTrace();
           }
        });
        thread.start();

    }

    public static void main(String[] args) {
        case1();
        case2();
    }
}
