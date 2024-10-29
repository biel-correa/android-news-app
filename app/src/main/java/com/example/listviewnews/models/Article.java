package com.example.listviewnews.models;

public class Article {
    private int id;
    private String title;
    private String description;
    private String type;
    private boolean isLive;

    public Article(int id, String title, String description,  String type, boolean isLive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.isLive = isLive;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
