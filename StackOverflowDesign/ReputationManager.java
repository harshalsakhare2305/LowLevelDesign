package StackOverflowDesign;

public class ReputationManager implements PostObserver{

     private final int UPVOTE_Q_REP=5;
     private final int UPVOTE_ANS_REP=10;
     private final int ACCEPTED_ANS_REP=15;
     private final int DOWNVOTE_PENALTY_REP=-1;
     private final int DOWNVOTE_PENALTY_REP_AUTHOR=-2;


    @Override
    public void OnPostEvent(Event event) {
        User actor = event.getActor();
        User author =event.getPost().getAuthor();

        switch (event.getEventType()){
            case UPVOTE_QUESTION :
                author.updateReputation(UPVOTE_Q_REP);
                break;
            case UPVOTE_ANSWER:
                author.updateReputation(UPVOTE_ANS_REP);
                break;
            case ANSWER_ACCEPTED:
                author.updateReputation(ACCEPTED_ANS_REP);
                break;
            case DOWNVOTE_QUESTION:
                author.updateReputation(DOWNVOTE_PENALTY_REP_AUTHOR);
                actor.updateReputation(DOWNVOTE_PENALTY_REP);
                break;
            case DOWNVOTE_ANSWER:
                author.updateReputation(DOWNVOTE_PENALTY_REP_AUTHOR);
                actor.updateReputation(DOWNVOTE_PENALTY_REP);
                break;
        }
    }
}
