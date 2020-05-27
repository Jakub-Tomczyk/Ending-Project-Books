package pl.jakubtomczyk.service;

import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.User;
import pl.jakubtomczyk.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public List<User> readAll() {
        return this.userRepository.findAll();
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }

    public void update(User user, Long id) {
        this.userRepository.findOneById(id);

    }
}
