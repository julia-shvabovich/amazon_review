package amazon.review.service;

import amazon.review.model.User;
import java.util.List;

public interface UserService {
    List<User> getMostActive(int amount);
}
