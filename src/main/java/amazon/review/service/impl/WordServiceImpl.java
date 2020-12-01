package amazon.review.service.impl;

import amazon.review.model.Word;
import amazon.review.repository.WordRepository;
import amazon.review.service.WordService;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<Word> getMostUsedWords(int amount) {
        return wordRepository.findMostUsed(PageRequest.of(0, amount));
    }
}
