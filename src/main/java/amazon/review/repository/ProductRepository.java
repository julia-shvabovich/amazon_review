package amazon.review.repository;

import amazon.review.model.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new amazon.review.model.Product("
            + "r.product.externalId) "
            + "FROM Review r "
            + "GROUP BY r.product.externalId "
            + "ORDER BY COUNT(r) DESC")
    List<Product> findMostCommented(Pageable pageable);
}
