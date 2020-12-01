package amazon.review.service.impl;

import amazon.review.model.Product;
import amazon.review.repository.ProductRepository;
import amazon.review.service.ProductService;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getMostCommented(int amount) {
        return productRepository.findMostCommented(PageRequest.of(0, amount));
    }
}
