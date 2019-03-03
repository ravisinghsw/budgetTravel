package com.ravi.travel.budget_travel.domain;

public class Paragraph {

    public Paragraph() {

    }

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Paragraph(String paragraph, String imageUrl,String imageDestination) {
        this.paragraph = paragraph;
        this.imageUrl = imageUrl;
        this.imageDestination = imageDestination;
    }

    private String paragraph;

    private String imageUrl;

    private String imageDestination;

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDestination() {
        return imageDestination;
    }

    public void setImageDestination(String imageDestination) {
        this.imageDestination = imageDestination;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "paragraph='" + paragraph + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageDestination='" + imageDestination + '\'' +
                '}';
    }
}
