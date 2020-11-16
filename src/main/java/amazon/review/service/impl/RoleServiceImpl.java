package amazon.review.service.impl;

import amazon.review.model.Role;
import amazon.review.repository.RoleRepository;
import amazon.review.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByRoleName(Role.of(roleName).getRoleName());
    }
}
