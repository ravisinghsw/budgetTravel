package com.ravi.travel.budget_travel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * https://www.callicoder.com/java-8-completablefuture-tutorial/
 * https://spring.io/guides/gs/rest-service/
 * https://howtodoinjava.com/spring/spring-boot2/spring-rest-request-validation/
 * http://www.deadcoderising.com/java8-writing-asynchronous-code-with-completablefuture/
 * http://www.baeldung.com/java-static-default-methods
 * https://www.javacodegeeks.com/2016/01/exception-handling-spring-restful-web-service.html
 * https://www.javacodegeeks.com/2016/01/exception-handling-spring-restful-web-service.html
 */
public class MethodCallBack {

    private static  Logger log = LoggerFactory.getLogger(MethodCallBack.class);

    public static void main(String[] args) throws InterruptedException {


        ThreadFactory threadFactory = new ThreadFactory() {
            ThreadFactory factory  = Executors.defaultThreadFactory();
            AtomicLong atomicLong = new AtomicLong(0);
            @Override
            public Thread newThread(Runnable r) {


               Thread thread = factory.newThread(r);
               thread.setName("Budget_Travel_"+atomicLong.getAndIncrement());
               return thread;
            }
        };


        ExecutorService executorsService = Executors.newCachedThreadPool(threadFactory);
        executorsService.submit(()->{
            MDC.put("logFileName",Thread.currentThread().getName());

            log.info(Thread.currentThread() + " In Executors ");
        Consumer<String> callBackFunc = MethodCallBack::callBackFunc;
        useCallBack(callBackFunc);
        });
        executorsService.submit(()->{
            MDC.put("logFileName",Thread.currentThread().getName());

            log.info(Thread.currentThread() + " In Executors ");
            Consumer<String> callBackFunc = MethodCallBack::callBackFunc;
            useCallBack(callBackFunc);
        });

        Thread.sleep(5000);

        executorsService.shutdown();

    }



    private static void useCallBack(Consumer<String> callBackFunc){
        log.info(Thread.currentThread() + " "+ "Hello");
        callBackFunc.accept("By useCallBack"+ "Hello");
    }

    private static void callBackFunc(String param){
        log.info(Thread.currentThread() + " "+ param);
        log.info("Call Back !!!! "+param);
        MDC.remove("logFileName");
    }
}
