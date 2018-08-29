package ar.com.nat.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.nat.auth.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
