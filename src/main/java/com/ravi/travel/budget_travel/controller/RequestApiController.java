package com.ravi.travel.budget_travel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RequestApiController {

    private static Logger log = LoggerFactory.getLogger(RequestApiController.class);

    @Autowired
    private ApplicationContext context;


    /*public void process(CompletableFuture<ApiResponse> responseCompletableFuture, String type, Map<String, String> params) {
        log.info("Thread {}",Thread.currentThread());
        String reqType = params.get("REQUEST_TYPE");
        RequestHandler abstractRequestHandler = (RequestHandler)context.getBean(reqType) ;
        abstractRequestHandler.doExecuteRequest(responseCompletableFuture,type,params);

    }*/
}
