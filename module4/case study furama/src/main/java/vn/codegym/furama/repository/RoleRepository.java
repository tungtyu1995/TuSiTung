package vn.codegym.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String role_name);
}
