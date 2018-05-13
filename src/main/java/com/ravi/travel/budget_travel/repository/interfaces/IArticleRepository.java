package com.ravi.travel.budget_travel.repository.interfaces;

import com.ravi.travel.budget_travel.domain.Article;

import java.util.List;

public interface IArticleRepository {

    List<Article> getArticles();
}
