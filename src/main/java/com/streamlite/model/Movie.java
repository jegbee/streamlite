package com.streamlite.model;

public class Movie {
    private String title;
    private String description;
    private String imageUrl;
    private String videoUrl;

    public Movie(String title, String description, String imageUrl, String videoUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getVideoUrl() { return videoUrl; }
}
