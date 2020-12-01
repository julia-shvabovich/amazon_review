package amazon.review.service.impl;

import amazon.review.model.Review;
import amazon.review.repository.ReviewRepository;
import amazon.review.service.ReviewService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void saveAll(List<Review> comments) {
        reviewRepository.saveAll(comments);
    }
}
