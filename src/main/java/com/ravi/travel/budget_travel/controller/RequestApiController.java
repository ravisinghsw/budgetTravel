package com.ravi.travel.budget_travel.controller;

import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.exception.ResourceNotFoundException;
import com.ravi.travel.budget_travel.handler.AbstractRequestHandler;
import com.ravi.travel.budget_travel.service.ArticleService;
import com.ravi.travel.budget_travel.utilities.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Component
public class RequestApiController {

    private static Logger log = LoggerFactory.getLogger(RequestApiController.class);

    @Autowired
    private ApplicationContext context;


    public void process(CompletableFuture<ApiResponse> responseCompletableFuture, String type, Map<String, String> params) {
        log.info("Thread {}",Thread.currentThread());
        String reqType = params.get("REQUEST_TYPE");
        AbstractRequestHandler abstractRequestHandler = (AbstractRequestHandler)context.getBean(reqType) ;
        abstractRequestHandler.doExecuteRequest(responseCompletableFuture,type,params);

    }
}
