package amazon.review.controller;

import amazon.review.model.dto.WordDto;
import amazon.review.model.mapper.WordMapper;
import amazon.review.service.WordService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private static final String PAGE_SIZE = "1000";
    private final WordService wordService;
    private final WordMapper wordMapper;

    public ReviewController(WordService wordService, WordMapper wordMapper) {
        this.wordService = wordService;
        this.wordMapper = wordMapper;
    }

    @GetMapping("/most-used-words")
    public List<WordDto> getMostUsedWords(
            @RequestParam(defaultValue = PAGE_SIZE) int amount) {
        return wordService.getMostUsedWords(amount).stream()
                .map(wordMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
