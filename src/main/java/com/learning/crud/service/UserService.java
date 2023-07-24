package com.learning.crud.service;

import com.learning.crud.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> findAll();
    Optional<User> findUserById(Long id);
    void deleteUserById(Long id);
    Optional<User> saveUser(User user);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByStatus(String status);
}
