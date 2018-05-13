package com.ravi.travel.budget_travel;

import java.util.function.Consumer;
import java.util.function.Function;

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


    public static void main(String[] args) {

        Consumer<String> callBackFunc = MethodCallBack::callBackFunc;
        useCallBack("Hello",callBackFunc);

    }



    private static void useCallBack(String param , Consumer<String> callBackFunc){
        callBackFunc.accept("By useCallBack"+param);
    }

    private static void callBackFunc(String param){
        System.out.println("Call Back !!!! "+param);
    }
}
