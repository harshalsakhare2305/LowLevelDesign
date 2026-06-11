package Stackoverflow;

import java.util.List;
public interface SearchStrategy {
    List<Question> filter(List<Question> questionsList);
}
