package Stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;


public class StackOverflowService {

    private Map<String,User> users =new ConcurrentHashMap<>();
    private Map<String,Question> questionMap=new ConcurrentHashMap<>();
    private Map<String,Answer> answerMap=new ConcurrentHashMap<>();
    private PostObserver reputationmanager=new ReputationManager();

    public User createuser(String name){
        User user=new User(name);
        users.put(user.getId(),user);
        return user;
    }

    public Question postQuestion(String userId,String body,String title){
        User user =users.get(userId);
        Question question=new Question(title,body,user);
        question.addObserver(reputationmanager);
        questionMap.putIfAbsent(question.getId(),question);
        return question;
    }

    public Answer postAnswer(String userId,String body,String questionId){
        User user =users.get(userId);
        Question question=questionMap.get(questionId);
        Answer ans =new Answer(body,user);
        ans.addObserver(reputationmanager);
        question.addAnswer(ans);
        answerMap.put(ans.getId(),ans);
        return ans;
    }

    public void VoteonPost(String userId,String postId,VoteType voteType){
        User user=users.get(userId);
        Post post=findPostByid(postId);
        post.vote(user,voteType);
    }

    public void acceptAnswer(String questionId,String answerId){
        Question question=questionMap.get(questionId);
        Answer ans =answerMap.get(answerId);

        question.acceptAnswer(ans);
    }

    public List<Question> searchQuestion(List<SearchStrategy> strategyList){
        // write logic here

        return new ArrayList<>();

    }

    private Post findPostByid(String postid) {
        if (questionMap.containsKey(postid)) {
            return questionMap.get(postid);
        } else if (answerMap.containsKey(postid)) return answerMap.get(postid);

        throw new NoSuchElementException("Post Not Found");

    }








}
