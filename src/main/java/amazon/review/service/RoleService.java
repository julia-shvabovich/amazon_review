package amazon.review.service;

import amazon.review.model.Role;

public interface RoleService {
    void save(Role role);

    Role findByName(String roleName);
}
