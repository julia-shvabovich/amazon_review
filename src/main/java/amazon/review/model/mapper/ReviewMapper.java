package amazon.review.model.mapper;

import amazon.review.model.Review;
import amazon.review.model.dto.ReviewCsvDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review mapToReview(ReviewCsvDto reviewDto) {
        Review review = new Review();
        review.setHelpfulnessNumerator(reviewDto.getHelpfulnessNumerator());
        review.setHelpfulnessDenominator(reviewDto.getHelpfulnessDenominator());
        review.setScore(reviewDto.getScore());
        review.setTime(reviewDto.getTime());
        review.setSummary(reviewDto.getSummary());
        review.setText(reviewDto.getText());
        return review;
    }

    public ReviewCsvDto mapToDto(Review review) {
        ReviewCsvDto dto = new ReviewCsvDto();
        dto.setId(review.getId());
        dto.setProfileName(review.getUser().getProfileName());
        dto.setHelpfulnessNumerator(review.getHelpfulnessNumerator());
        dto.setHelpfulnessDenominator(review.getHelpfulnessDenominator());
        dto.setScore(review.getScore());
        dto.setTime(review.getTime());
        dto.setSummary(review.getSummary());
        dto.setProductId(review.getProduct().getExternalId());
        dto.setText(review.getText());
        dto.setUserId(review.getUser().getExternalId());
        return dto;
    }
}
