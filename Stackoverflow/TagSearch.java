package Stackoverflow;

import java.util.List;
import java.util.stream.Collectors;

public class TagSearch implements SearchStrategy{

    private final Tag tag;

    TagSearch(Tag tag){
        this.tag=tag;
    }
    @Override
    public List<Question> filter(List<Question> questionsList) {
        return questionsList.stream().filter(q->q.getTagSet().stream().anyMatch(t->t.getName().equalsIgnoreCase(tag.getName()))).collect(Collectors.toList());
    }
}
