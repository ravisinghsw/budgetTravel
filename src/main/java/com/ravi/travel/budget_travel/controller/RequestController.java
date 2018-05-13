package com.ravi.travel.budget_travel.controller;


import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.exception.ResourceNotFoundException;
import com.ravi.travel.budget_travel.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.List;

@RestController
public class RequestController {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private ArticleService articleService ;


    @RequestMapping("/articlesList")
    public ResponseEntity<List<Article>> getAllArticle(){
        log.info("Response Article {}",articleService.articles());
        return new ResponseEntity<>(articleService.articles(), HttpStatus.OK);
    }


    @RequestMapping("/articles")
    public ResponseEntity<List<Article>> getArticles(@RequestParam(value = "author" , defaultValue = "ALL") String author){
        log.info("Author ",author);
        List<Article> authorList = articleService.article(author) ;
        if(CollectionUtils.isEmpty(authorList)){
            throw new ResourceNotFoundException(" No Article Found of Author :"+author) ;
        }
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }




}
