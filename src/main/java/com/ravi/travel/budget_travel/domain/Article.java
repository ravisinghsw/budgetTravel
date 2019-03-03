package com.ravi.travel.budget_travel.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ravi.travel.budget_travel.utilities.ArticleType;

import java.util.Date;

public class Article {


    private int id;

    private String title;

    private ArticleType articleType;


    private Author author;

    private Destination destination;

    private ArticleDocument articleDocument;

    private String articleBrief;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdTime;

    private Date modifiedTime;

    private long articleReadCount;

    private long upVote;

    private long downVote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public ArticleDocument getArticleDocument() {
        return articleDocument;
    }

    public void setArticleDocument(ArticleDocument articleDocument) {
        this.articleDocument = articleDocument;
    }

    public String getArticleBrief() {
        return articleBrief;
    }

    public void setArticleBrief(String articleBrief) {
        this.articleBrief = articleBrief;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public long getArticleReadCount() {
        return articleReadCount;
    }

    public void setArticleReadCount(long articleReadCount) {
        this.articleReadCount = articleReadCount;
    }

    public long getUpVote() {
        return upVote;
    }

    public void setUpVote(long upVote) {
        this.upVote = upVote;
    }

    public long getDownVote() {
        return downVote;
    }

    public void setDownVote(long downVote) {
        this.downVote = downVote;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", articleType=" + articleType +
                ", author=" + author +
                ", destination=" + destination +
                ", articleDocument=" + articleDocument +
                ", articleBrief='" + articleBrief + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", articleReadCount=" + articleReadCount +
                ", upVote=" + upVote +
                ", downVote=" + downVote +
                '}';
    }
}

