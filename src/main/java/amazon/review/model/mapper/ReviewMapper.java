package amazon.review.model.mapper;

import amazon.review.model.Review;
import amazon.review.model.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review map(ReviewDto reviewDto) {
        Review review = new Review();
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        review.setScore(reviewDto.getScore());
        review.setTime(reviewDto.getTime());
        review.setSummary(reviewDto.getSummary());
        review.setText(reviewDto.getText());
        return review;
    }
}
