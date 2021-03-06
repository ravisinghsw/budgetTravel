package com.ravi.travel.budget_travel.handler;

import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.exception.ResourceNotFoundException;
import com.ravi.travel.budget_travel.service.ArticleService;
import com.ravi.travel.budget_travel.utilities.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(value = "SYNC")
public class SyncRequestHandler {

    private static Logger log = LoggerFactory.getLogger(SyncRequestHandler.class);

    @Autowired
    private ArticleService articleService ;


    public ApiResponse executeReq(String type, Map<String, String> params) {
        log.info("Thread executeReq {}",Thread.currentThread());
        ApiResponse response = new ApiResponse();
        List<Article> authorList = articleService.article(params.get("name")) ;
        if(CollectionUtils.isEmpty(authorList)){
            throw new ResourceNotFoundException(" No Article Found of Author :"+params.get("name")) ;
        };;
      /*  Map<String,String> res = authorList.stream().collect(Collectors.toMap(Article::getAuthor ,
                Article::getDescription));
        response.setStatus("SUCCESS");
        response.setResponseParams(res);*/
        response.setErrorDesc("NA");
        return response;
    }
}
