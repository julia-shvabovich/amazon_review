package amazon.review.service;

import amazon.review.model.Word;
import java.util.List;

public interface WordService {
    List<Word> getMostUsedWords(int amount);
}
