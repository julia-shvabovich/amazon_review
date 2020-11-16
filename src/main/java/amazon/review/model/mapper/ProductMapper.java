package amazon.review.model.mapper;

import amazon.review.model.Product;
import amazon.review.model.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product map(ReviewDto reviewDto) {
        Product product = new Product();
        product.setExternalId(reviewDto.getProductId());
        return product;
    }
}
