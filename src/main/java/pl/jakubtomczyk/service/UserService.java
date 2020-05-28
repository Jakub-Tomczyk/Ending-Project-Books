package pl.jakubtomczyk.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Role;
import pl.jakubtomczyk.entity.User;
import pl.jakubtomczyk.repository.RoleRepository;
import pl.jakubtomczyk.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        // TODO :: First register than add ROLE_ADMIN


        if(user.getRoles() == null || user.getRoles().size()==0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_USER"));
            user.setRoles(roles);
        }

        userRepository.save(user);
    }

    public List<User> readAll() {
        return this.userRepository.findAll();
    }

    public void deleteById(Long id) {
        User user = findById(id);
        this.userRepository.delete(user);
    }

    public void update(User user, Long id) {
        this.userRepository.findOneById(id);
    }

    public User findById(Long id) {return this.userRepository.findById(id).orElse(null);}

    public User findByUserFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
