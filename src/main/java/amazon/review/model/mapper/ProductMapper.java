package amazon.review.model.mapper;

import amazon.review.model.Product;
import amazon.review.model.dto.ProductDto;
import amazon.review.model.dto.ReviewCsvDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ReviewCsvDto reviewDto) {
        Product product = new Product();
        product.setExternalId(reviewDto.getProductId());
        return product;
    }

    public ProductDto mapToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        return dto;
    }
}
