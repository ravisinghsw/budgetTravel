package com.ravi.travel.budget_travel.repository;

import com.ravi.travel.budget_travel.domain.Article;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

//@Component
public class ArticleRepository {

    private static AtomicLong count = new AtomicLong(0);

    private static List<Article> articles = new ArrayList<>();

    private static Map<String,List<Article>> authorMap = new HashMap<>();

    static {
      articles.add(new Article(count.getAndIncrement(),"Rishikesh Trip","rahul" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Hyderbad Trip","laxmi" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Pune Trip","laxmi" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Bhramtal Trip","rishi" ,0L));
      articles.add(new Article(count.getAndIncrement(),"Kasol Trip","ravi" ,0L));
      articles.forEach(ArticleRepository::addArticleInMap
      );
  }

    public  List<Article> getArticles() {
        return articles;
    }

    public Article saveArticle(Article article){
        article.setId(count.getAndIncrement());
        articles.add(article);
        addArticleInMap(article);
        return article;
    }

    public List<Article> getArticle(String author){
        return authorMap.get(author);
    }

    @NonNull
    private static void addArticleInMap(Article article) {
        if (Objects.nonNull(authorMap.get(article.getAuthor()))) {
            authorMap.get(article.getAuthor()).add(article);
        }else {
            List<Article> articles = new ArrayList<>();
            articles.add(article);
            authorMap.put(article.getAuthor(),articles);
        }
    }
}
