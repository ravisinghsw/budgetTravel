package com.ravi.travel.budget_travel.service;


import com.ravi.travel.budget_travel.domain.Article;
import com.ravi.travel.budget_travel.repository.ArticleRepository;
import com.ravi.travel.budget_travel.service.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService{

    @Autowired
    private ArticleRepository articleRepository ;


    @Override
    public List<Article> articles() {
        return articleRepository.getArticles()  ;
    }

    @Override
    public List<Article> article(String author) {
        return articleRepository.getArticle(author);
    }
}
