package com.ravi.travel.budget_travel.handler;

import com.ravi.travel.budget_travel.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class RequestHandler {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private ArticleService articleService ;

    @Autowired
    private AsyncRequestHandler asyncRequestHandler ;

    /*
    public final boolean isSync(Map<String, String> params) {
        boolean isSyncOrAysnc = false;
        if (params.get("REQUEST_TYPE").equalsIgnoreCase("SYNC")) {
            isSyncOrAysnc = true;
        }
        return isSyncOrAysnc;
    }*/

   /* public void doExecuteRequest(CompletableFuture<ApiResponse> responseCompletableFuture, String type, Map<String, String> params) {

        boolean isSyncOrAysnc = isSync(params);

        if (isSyncOrAysnc) {
            syncExecutorService.execute(() -> {
                responseCompletableFuture.complete(this.executeReq(type, params));
            });
        } else {
            ApiResponse response = new ApiResponse();
            response.setStatus("REQUEST IN PROGRESS :: ASYNC");
            response.setErrorDesc("NA");
            responseCompletableFuture.complete(response);

            asyncExecutorService.submit(() -> {
                ApiResponse res = this.executeReq(type, params);//Process Asynchronusly
                log.info("Work Over :: " + res);
            });

        }


    }*/
}
