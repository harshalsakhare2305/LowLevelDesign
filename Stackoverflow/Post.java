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


}
