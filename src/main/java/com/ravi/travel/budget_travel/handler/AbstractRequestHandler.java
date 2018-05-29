package com.ravi.travel.budget_travel.handler;

import com.ravi.travel.budget_travel.utilities.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public abstract class AbstractRequestHandler {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public abstract ApiResponse executeReq(String type, Map<String, String> params);

    private ExecutorService syncExecutorService = Executors.newCachedThreadPool() ;

    private ExecutorService asyncExecutorService = Executors.newFixedThreadPool(20);

    public final boolean isSync(Map<String, String> params){
        boolean isSyncOrAysnc = false ;
        if(params.get("REQUEST_TYPE").equalsIgnoreCase("SYNC")){
            isSyncOrAysnc = true;
        }
        return isSyncOrAysnc;
    }

    public void doExecuteRequest(CompletableFuture<ApiResponse> responseCompletableFuture,String type, Map<String, String> params){

        boolean isSyncOrAysnc = isSync(params);

        if(isSyncOrAysnc){
            syncExecutorService.execute(()->{
                responseCompletableFuture.complete(this.executeReq(type,params));
            });
        } else {
            ApiResponse response = new ApiResponse();
            response.setStatus("REQUEST IN PROGRESS :: ASYNC");
            response.setErrorDesc("NA");
            responseCompletableFuture.complete(response);

            asyncExecutorService.submit(()->{
                ApiResponse res= this.executeReq(type,params);//Process Asynchronusly
                log.info("Work Over :: "+res);
            });

        }


    }
}
