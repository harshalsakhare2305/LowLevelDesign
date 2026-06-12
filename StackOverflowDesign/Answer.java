package StackOverflowDesign;

public class Answer extends Post{

    private boolean isAccepted=false;

    public Answer(String body,User author){
        super(body,author);
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
