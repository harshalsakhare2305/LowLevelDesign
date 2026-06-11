package Stackoverflow;

public class Event {
    private EventType type;
    private User actor;
    private Post targetPost;


    public Event(EventType type, User actor, Post targetPost) {
        this.type = type;
        this.actor = actor;
        this.targetPost = targetPost;
    }

    public EventType getType() {
        return type;
    }

    public Post getTargetPost() {
        return targetPost;
    }

    public User getActor() {
        return actor;
    }
}
