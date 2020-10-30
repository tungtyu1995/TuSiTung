package vn.codegym.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
