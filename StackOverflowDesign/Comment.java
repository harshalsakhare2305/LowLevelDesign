package StackOverflowDesign;

public class Comment extends Content{

    private Post reference;


    public Comment(String body, User author, Post reference) {
        super(body, author);
        this.reference = reference;
    }

    public Post getReference() {
        return reference;
    }


}
