package amazon.review.model.dto;

import amazon.review.model.Role;
import java.util.Set;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String profileName;
    private String password;
    private Set<Role> roles;
}
