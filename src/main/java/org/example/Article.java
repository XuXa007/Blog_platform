package org.example;

import java.util.Date;

public class Article implements ArticleInterface {
    private String title;
    private String author;
    private Date publication;
    private int likes;

    public Article(String title, String author, Date publication, int likes) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.likes = likes;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public Date getPublishedDate() {
        return publication;
    }

    @Override
    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication=" + publication +
                ", likes=" + likes +
                '}';
    }
}
