package Stackoverflow;

import java.util.List;
import java.util.stream.Collectors;

public class KeywordSearch implements SearchStrategy {

    private  final String keyword;

    public KeywordSearch(String keyword){
        this.keyword=keyword;
    }

    @Override
    public List<Question> filter(List<Question> questionsList) {
        return questionsList.stream().filter(q-> q.getTitle().toLowerCase().contains(keyword) || q.getBody().toLowerCase().contains(keyword)).collect(Collectors.toList());
    }
}
