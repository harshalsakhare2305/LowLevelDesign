package StackOverflowDesign;

import java.util.List;
import java.util.stream.Collectors;

public class TitleSearch implements SearchStrategy{

    private String keyword;

    public TitleSearch(String keyword) {
        this.keyword = keyword;
    }


    @Override
    public List<Question> SearchQuestions(List<Question> questions) {
        return questions.stream().filter( q -> q.getTitle().contains(keyword)).collect(Collectors.toList());
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
