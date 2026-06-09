package Stackoverflow;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Post extends Content{
    private AtomicInteger voteCount=new AtomicInteger(0);
    private  Map<String,VoteType> voters =new ConcurrentHashMap<>();
    private  List<Comment> comments =new ArrayList<>();
    private List<PostObserver> observers=new ArrayList<>();

    public Post(String id,String body,User author){
        super(id,body,author);
    }

    public void addObserver(PostObserver observer){
        observers.add(observer);
    }

    protected void notifyObserver(Event event){
        for(PostObserver o:observers){
            o.onPostEvent(event);
        }
    }

    public synchronized void vote(User user,VoteType voteType){
        String userId= user.getId();
        if(voters.get(userId)==voteType)return;// Already voted

        int scoreChange =0;
        if(voters.containsKey(userId)){
            scoreChange=(voteType==VoteType.UPVOTE? 2 : -2);
        }else{
            scoreChange=(voteType==VoteType.UPVOTE ? 1 :-1);
        }

        voters.put(userId,voteType);
        voteCount.addAndGet(scoreChange);

        EventType eventType=EventType.UPVOTE_QUESTION;

        if(this instanceof Question){
            eventType=(voteType==VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION);
        }else{
            eventType =(voteType==VoteType.UPVOTE ? EventType.UPVOTE_ANSWER:EventType.DOWN_ANSWER);
        }

        notifyObserver(new Event(eventType,user,this));
    }


}
