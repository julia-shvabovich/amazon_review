package amazon.review.model.mapper;

import amazon.review.model.Word;
import amazon.review.model.dto.WordDto;
import org.springframework.stereotype.Component;

@Component
public class WordMapper {
    public WordDto mapToDto(Word word) {
        WordDto dto = new WordDto();
        dto.setId(word.getId());
        dto.setAmount(word.getAmount());
        dto.setValue(word.getValue());
        return dto;
    }
}
