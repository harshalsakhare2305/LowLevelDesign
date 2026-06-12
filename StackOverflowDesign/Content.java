package StackOverflowDesign;

import java.util.UUID;

public abstract class Content {
    private String id;
    private String body;
    private User Author;


    public Content(String body, User author) {
        this.id= UUID.randomUUID().toString();
        this.body = body;
        this.Author = author;
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return Author;
    }

    public String getBody() {
        return body;
    }
}
