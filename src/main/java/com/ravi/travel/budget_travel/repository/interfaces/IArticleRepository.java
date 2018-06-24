package com.ravi.travel.budget_travel.repository.interfaces;

import com.ravi.travel.budget_travel.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findAllByAuthor(String author);
}
