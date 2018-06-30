package com.ravi.travel.budget_travel.service;


import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.repository.ArticleRepository;
import com.ravi.travel.budget_travel.repository.interfaces.IArticleRepository;
import com.ravi.travel.budget_travel.service.interfaces.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private IArticleRepository articleRepository ;

    @Override
    public List<Article> articles() {
        List<Article> articles = null;
        try {
            articles  = articleRepository.findAll();

        }catch (Exception ex) {
            log.error("ERROR while fetching all articles from reposiotry :"+ex.getMessage(),ex);
            throw new RuntimeException("ERROR while fetching all articles from reposiotry :"+ex.getMessage());
        }
        return articles ;
    }

    @Override
    public List<Article> article(String author) {
        List<Article> articles = null;
        try {
            articles  = articleRepository.findAllByAuthor(author);
        }catch (Exception ex) {
            log.error("ERROR while fetching  articles for author :"+author,ex);
            throw new RuntimeException("ERROR while fetching  articles for author :"+author);
        }
        return articles ;
    }

    public void saveAndUpdateArticle(Article article){
        try {
            articleRepository.saveAndFlush(article);
        }catch (Exception ex){
            log.error("ERROR while save/update  article"+article,ex);
            throw new RuntimeException("ERROR while save/update  article"+article);
        }
    }
}
