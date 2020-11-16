package amazon.review.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;
    private String productId;
    private String userId;
}
