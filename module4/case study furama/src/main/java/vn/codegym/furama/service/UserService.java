package vn.codegym.furama.service;

import vn.codegym.furama.model.User;

public interface UserService {
    User findByUsername(String username);

    void save(User user);
}
