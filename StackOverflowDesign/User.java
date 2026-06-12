package StackOverflowDesign;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private String id;
    private AtomicInteger reputation =new AtomicInteger(0);
    private String name;


    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void updateReputation(int change){
        reputation.addAndGet(change);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AtomicInteger getReputation() {
        return reputation;
    }
}
