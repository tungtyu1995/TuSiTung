package vn.codegym.furama.service;

import vn.codegym.furama.model.Role;

public interface RoleService {
    Role findByRoleName(String role_name);
}
