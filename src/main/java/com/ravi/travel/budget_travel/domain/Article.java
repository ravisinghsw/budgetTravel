package com.ravi.travel.budget_travel.domain;

import javax.persistence.*;

@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id ;

    @Column(name="Description")
    private String description;

    @Column(name = "Author")
    private String author ;

    @Column(name = "view_count")
    private Long viewCount;

    public Article(Long id, String description, String author, Long viewCount) {
        this.id = id;
        this.description = description;
        this.author = author;
        this.viewCount = viewCount;
    }

    public Article(){

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
