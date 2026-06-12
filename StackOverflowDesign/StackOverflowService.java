package StackOverflowDesign;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflowService {

    private Map<String,User> userMap=new ConcurrentHashMap<>();
    private Map<String,Question> questionMap=new ConcurrentHashMap<>();
    private Map<String,Answer> answerMap=new ConcurrentHashMap<>();
    private PostObserver reputationManager=new ReputationManager();

    StackOverflowService(){

    }


    public User createUser(String name){
        User user =new User(name);
        userMap.put(user.getId(),user);
        return user;
    }



    public void addQuestion(String body,String title,User author){

        Question q =new Question(body,author,title);
        q.addObserver(reputationManager);
        questionMap.put(q.getId(),q);

        System.out.println("Question added successfully !!");
    }

    public void addAnswer(String body,User author,Question question){
        Answer ans =new Answer(body,author);
        question.addAnswer(ans);
        answerMap.put(ans.getId(),ans);
        ans.addObserver(reputationManager);
    }

    public void addComment(String body,User author,Post post){
        Comment comment=new Comment(body,author,post);
         post.addComment(comment);
    }

    public void VoteOnPost(VoteType voteType,User actor,Post post){
        EventType eventType=null;
        if(post instanceof Question ){
            eventType=voteType==VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        }else if(post instanceof Answer){
            eventType=voteType==VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER;
        }

        Event event =new Event(eventType,actor,post);
        post.notifyObserver(event);
    }

    public List<Question> searchQuestion(SearchStrategy searchStrategy){

       return  searchStrategy.SearchQuestions(questionMap.values().stream().toList());

    }


}
