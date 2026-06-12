package StackOverflowDesign;



import Stackoverflow.ReputationManager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  abstract  class Post extends  Content{

    private List<Comment> commentList;
    private LocalTime creationTime;
    private List<PostObserver> observers;
    private Map<String,VoteType> votemap;

    public Post(String body,User author) {
        super(body,author);
        this.observers=new ArrayList<>();
        this.commentList=new ArrayList<>();
        creationTime=LocalTime.now();
        this.votemap=new ConcurrentHashMap<>();
    }

    public void addObserver(PostObserver o){
        this.observers.add(o);
    }

    public void notifyObserver(Event event){
        for(PostObserver o:observers){
            o.OnPostEvent(event);
        }
    }

    public void addComment(Comment comment){
        commentList.add(comment);
    }


    public void VoteOnPost(User author,VoteType voteType){

        String id =author.getId();
        if(votemap.containsKey(id) && voteType==votemap.get(id))return;

        int change;

        if(votemap.containsKey(id)){
            change =voteType==VoteType.UPVOTE? 2 : -2;
        }else{
            change = voteType==VoteType.UPVOTE ? 1 :-1;
        }

        author.updateReputation(change);

        EventType eventType=null;
        if(this instanceof Question ){
            eventType=voteType==VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        }else if(this instanceof Answer){
            eventType=voteType==VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER;
        }

        Event event =new Event(eventType,this.getAuthor(),this);
        this.notifyObserver(event);
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public List<PostObserver> getObservers() {
        return observers;
    }

    public Map<String, VoteType> getVotemap() {
        return votemap;
    }
}
