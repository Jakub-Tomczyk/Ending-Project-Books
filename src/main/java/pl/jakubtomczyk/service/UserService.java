package pl.jakubtomczyk.service;


import pl.jakubtomczyk.entity.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);

}
