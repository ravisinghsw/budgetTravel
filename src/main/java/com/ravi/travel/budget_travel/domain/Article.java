package com.ravi.travel.budget_travel.domain;

public class Article {

    private Long id ;

    private String description;

    private String author ;

    private Long viewCount;

    public Article(Long id, String description, String author, Long viewCount) {
        this.id = id;
        this.description = description;
        this.author = author;
        this.viewCount = viewCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}
