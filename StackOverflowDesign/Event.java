package StackOverflowDesign;

public class Event {
    private EventType eventType;
    private User actor;
    private Post post;


    public Event(EventType eventType, User actor, Post post) {
        this.eventType = eventType;
        this.actor = actor;
        this.post = post;
    }

    public User getActor() {
        return actor;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Post getPost() {
        return post;
    }
}
