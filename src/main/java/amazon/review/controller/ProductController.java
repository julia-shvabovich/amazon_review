package amazon.review.controller;

import amazon.review.model.dto.ProductDto;
import amazon.review.model.mapper.ProductMapper;
import amazon.review.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final String PAGE_SIZE = "1000";
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/most-commented")
    public List<ProductDto> getMostCommented(
            @RequestParam(defaultValue = PAGE_SIZE) int amount) {
        return productService.getMostCommented(amount).stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
