package ar.com.nat.auth.service;

import ar.com.nat.auth.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
