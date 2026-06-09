package Stackoverflow;

import java.time.LocalDateTime;

public  abstract class Content {
    protected String id;
    protected String body;
    protected User author;
    protected LocalDateTime creationTime;

    public Content(String id,String body,User autor){
        this.id=id;
        this.body=body;
        this.author=autor;
        this.creationTime=LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getBody() {
        return body;
    }

    public User getAuthor() {
        return author;
    }
}
