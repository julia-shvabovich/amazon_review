package amazon.review.model.mapper;

import amazon.review.model.Role;
import amazon.review.model.User;
import amazon.review.model.dto.ReviewCsvDto;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final String ROLE_NAME = "USER";

    public User map(ReviewCsvDto reviewDto) {
        User user = new User();
        user.setExternalId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        user.setPassword(DEFAULT_PASSWORD);
        user.setRoles(Set.of(Role.of(ROLE_NAME)));
        return user;
    }
}
