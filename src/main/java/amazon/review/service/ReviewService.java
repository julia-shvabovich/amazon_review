package amazon.review.service;

import amazon.review.model.Review;
import java.util.List;

public interface ReviewService {
    void saveAll(List<Review> entities);
}
