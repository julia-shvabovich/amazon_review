package amazon.review.service;

import amazon.review.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getMostCommented(int amount);
}
