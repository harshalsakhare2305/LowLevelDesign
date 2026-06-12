package StackOverflowDesign;

import java.util.List;

public interface SearchStrategy {
    List<Question> SearchQuestions(List<Question> questions);
}
