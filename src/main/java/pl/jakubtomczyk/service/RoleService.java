package pl.jakubtomczyk.service;

import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Role;
import pl.jakubtomczyk.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public void save(Role role) {
        this.roleRepository.save(role);
    }

    public Role findOneByName(String roleName) {
        return this.roleRepository.findOneByName(roleName);
    }
}
