package com.ravi.travel.budget_travel.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ravi.travel.budget_travel.utilities.SocialMedia;

import java.util.List;

public class Author {

    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String briefInformation;

    private boolean authorized ;

    private SocialMedia auhorizedBy;

    private String profilePicUrl;

    @JsonManagedReference
    private List<Article> articles;

    @JsonManagedReference
    private List<LetsConnect> letsConnect;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public SocialMedia getAuhorizedBy() {
        return auhorizedBy;
    }

    public void setAuhorizedBy(SocialMedia auhorizedBy) {
        this.auhorizedBy = auhorizedBy;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> artiles) {
        this.articles = artiles;
    }

    public List<LetsConnect> getLetsConnect() {
        return letsConnect;
    }

    public void setLetsConnect(List<LetsConnect> letsConnect) {
        this.letsConnect = letsConnect;
    }

    public String getBriefInformation() {
        return briefInformation;
    }

    public void setBriefInformation(String briefInformation) {
        this.briefInformation = briefInformation;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", briefInformation='" + briefInformation + '\'' +
                ", authorized=" + authorized +
                ", auhorizedBy=" + auhorizedBy +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                ", articles=" + articles +
                ", letsConnect=" + letsConnect +
                '}';
    }
}
