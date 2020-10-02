package vn.codegym.userform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.userform.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
