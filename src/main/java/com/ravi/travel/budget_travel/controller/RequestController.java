package com.ravi.travel.budget_travel.controller;


import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.exception.ResourceNotFoundException;
import com.ravi.travel.budget_travel.service.ArticleService;
import com.ravi.travel.budget_travel.utilities.ApiRequest;
import com.ravi.travel.budget_travel.utilities.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());



    @Autowired
    private RequestApiController requestApiController ;


    @GetMapping("/articlesList")
    public String getAllArticle(){
        //log.info("Response Article {}",articleService.articles());
        return "SUCCESS";
    }


    @PostMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getArticles(@RequestBody ApiRequest author) throws InterruptedException {
        log.info("Request Recived {} ",author);
        ApiResponse response = null;
        CompletableFuture<ApiResponse> responseCompletableFuture=new  CompletableFuture<>();

        ForkJoinPool.commonPool().execute(()->{
            requestApiController.process(responseCompletableFuture,author.getType(),author.getParams());
        });


        try {
            response = responseCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("Response Recivied {} ",response);
        log.info(" Waiting for 10mins ");
        Thread.sleep(1000*60*10);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }




}
