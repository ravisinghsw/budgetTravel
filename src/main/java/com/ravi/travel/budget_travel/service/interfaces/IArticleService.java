package com.ravi.travel.budget_travel.service.interfaces;

import com.ravi.travel.budget_travel.domain.Article;

import java.util.List;

public interface IArticleService {
    List<Article> articles();

    List<Article> article(String author);
}
