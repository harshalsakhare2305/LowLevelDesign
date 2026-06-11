package Stackoverflow;

import java.util.*;

public class Question extends Post{

    private String title;
    private Set<Tag> tagSet;
    private List<Answer> answerList;
    private Answer acceptedAnswer;


    public Question(String title,String body,User author){
        super(UUID.randomUUID().toString(),body,author);
        this.tagSet=new HashSet<>();
        this.title=title;
        this.answerList=new ArrayList<>();
    }

    public void addAnswer(Answer ans){
        answerList.add(ans);
    }

    public synchronized void acceptAnswer(Answer ans){
        if(!this.author.getId().equals(ans.getAuthor().getId()) && this.acceptedAnswer==null){
            this.acceptedAnswer=ans;
            ans.setAccepted(true);
            notifyObserver(new Event(EventType.ACCEPT_ANSWER,ans.getAuthor(),ans));
        }
    }




    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public String getTitle() {
        return title;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }
}
