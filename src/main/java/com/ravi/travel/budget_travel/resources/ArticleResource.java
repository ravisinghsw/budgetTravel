package com.ravi.travel.budget_travel.resources;


import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.handler.RequestHandler;
import com.ravi.travel.budget_travel.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleResource {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private RequestHandler requestHandler;

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> getArticles() {
        log.info("Inside getArticles");
        return new ResponseEntity<>(articleService.articles(), HttpStatus.OK);
    }

    @GetMapping(value = "/articles/{author}")
    public ResponseEntity<List<Article>> getArticles(@PathVariable("author") String author) throws InterruptedException {
        log.info("Inside getArticles for " + author);
        return new ResponseEntity<>(articleService.article(author), HttpStatus.OK);

    }

    @PostMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> articles(@RequestBody Article article) {
        articleService.saveAndUpdateArticle(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
