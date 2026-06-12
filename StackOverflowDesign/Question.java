package StackOverflowDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Question extends Post{

    private List<Answer> answerList;
    private Set<Tag> tagSet;
    private Answer accepted_ans;
    private String title;

    public Question(String body,User author,String title){
        super(body,author);
        this.title=title;

        this.answerList=new ArrayList<>();
    }

    public void addAnswer(Answer ans){
        answerList.add(ans);
    }

    public void setAccepted_ans(Answer accepted_ans) {
        this.accepted_ans = accepted_ans;
    }

    public String getTitle() {
        return title;
    }



    public Answer getAccepted_ans() {
        return accepted_ans;
    }
}
