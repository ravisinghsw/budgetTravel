package com.ravi.travel.budget_travel.domain;

public class ArticleCategory {

    private int id;

    private String articleType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
                "id=" + id +
                ", articleType='" + articleType + '\'' +
                '}';
    }
}
