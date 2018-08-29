package ar.com.nat.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.nat.auth.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
