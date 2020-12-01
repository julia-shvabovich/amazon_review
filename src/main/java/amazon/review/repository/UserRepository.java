package amazon.review.repository;

import amazon.review.model.User;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT "
            + "new amazon.review.model.User(r.user.externalId) "
            + "FROM Review r "
            + "GROUP BY r.user.profileName "
            + "ORDER BY COUNT(r) DESC")
    List<User> findMostActive(Pageable pageable);
}
