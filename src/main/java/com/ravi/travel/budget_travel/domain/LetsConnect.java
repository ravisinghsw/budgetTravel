package com.ravi.travel.budget_travel.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ravi.travel.budget_travel.utilities.SocialMedia;

public class LetsConnect {

    private long id;

    @JsonBackReference
    private Author author;

    private SocialMedia socialMedia;

    private String socialMediaUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getSocialMediaUrl() {
        return socialMediaUrl;
    }

    public void setSocialMediaUrl(String socialMediaUrl) {
        this.socialMediaUrl = socialMediaUrl;
    }

    @Override
    public String toString() {
        return "LetsConnect{" +
                "id=" + id +
                ", author=" + author +
                ", socialMedia=" + socialMedia +
                ", socialMediaUrl='" + socialMediaUrl + '\'' +
                '}';
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
