package com.example.jayhind.lecture_app.apidemo;

/**
 * Created by Jay Hind on 4/25/2018.
 */

public class Articles {
    String author;
    String title;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {

        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "author "+author+" title-"+title;
    }
}