package vn.codegym.furama.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.Role;
import vn.codegym.furama.repository.RoleRepository;
import vn.codegym.furama.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String role_name) {
        return this.roleRepository.findByRoleName(role_name);
    }
}
