package com.example.listviewnews;

import com.example.listviewnews.models.Article;

import java.util.ArrayList;
import java.util.List;

public class Db {
    private static Db instance;
    private List<Article> articles;

    private Db() {
        articles = new ArrayList<>();
        articles.add(new Article(1, "Breaking News: Market Hits Record High", "The stock market reached an all-time high today, driven by tech stocks.", "news", false));
        articles.add(new Article(2, "Sports Update: Local Team Wins Championship", "The local football team won the championship in a thrilling match.", "sports", false));
        articles.add(new Article(3, "Weather Alert: Heavy Rain Expected Tomorrow", "Meteorologists predict heavy rain and thunderstorms in the area tomorrow.", "weather", true));
        articles.add(new Article(4, "Technology: New Smartphone Released", "A major tech company has released its latest smartphone model today.", "technology", false));
        articles.add(new Article(5, "Health: Tips for a Healthy Lifestyle", "Experts share tips on how to maintain a healthy lifestyle through diet and exercise.", "health", false));
        articles.add(new Article(6, "Entertainment: Upcoming Movie Releases", "A list of highly anticipated movies set to be released this year.", "entertainment", false));
        articles.add(new Article(7, "Politics: Election Results Announced", "The results of the recent election have been announced, with a surprising outcome.", "politics", false));
        articles.add(new Article(8, "Travel: Top Destinations for 2024", "Travel experts reveal the top destinations to visit in 2024.", "travel", false));
        articles.add(new Article(9, "Finance: How to Save Money", "Financial advisors provide tips on how to save money effectively.", "finance", false));
        articles.add(new Article(10, "Science: New Discovery in Space", "Scientists have made a groundbreaking discovery in space exploration.", "science", false));
    }

    public static synchronized Db getInstance() {
        if (instance == null) {
            instance = new Db();
        }
        return instance;
    }

    public Article getById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Article getLiveArticle() {
        for (Article article : articles) {
            if (article.isLive()) {
                return article;
            }
        }
        return null;
    }
}