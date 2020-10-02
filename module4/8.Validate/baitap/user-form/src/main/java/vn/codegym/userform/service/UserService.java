package vn.codegym.userform.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.userform.model.User;


import java.util.List;

public interface UserService {
    void save(User user) throws DuplicateEmailException;

    List<User> findAll();

    User findById(Long id);

    void update(User user);

    void remove(Long id);

    Page<User> findAll(Pageable pageable);
}
