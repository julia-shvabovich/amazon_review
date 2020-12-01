package amazon.review.service.impl;

import amazon.review.model.User;
import amazon.review.repository.UserRepository;
import amazon.review.service.UserService;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getMostActive(int amount) {
        return userRepository.findMostActive(PageRequest.of(0, amount));
    }
}
