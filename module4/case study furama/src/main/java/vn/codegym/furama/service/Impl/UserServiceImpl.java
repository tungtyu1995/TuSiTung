package vn.codegym.furama.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.Role;
import vn.codegym.furama.model.User;
import vn.codegym.furama.repository.UserRepository;
import vn.codegym.furama.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = this.userRepository.findByUsername(username);

        if (appUser == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        Role roleNames = appUser.getRole();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(roleNames.getRoleName());
        grantList.add(authority);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), grantList);

        return userDetails;
    }
}