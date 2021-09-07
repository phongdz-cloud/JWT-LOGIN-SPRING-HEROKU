package com.example.lhtjwtlogin.service;

import com.example.lhtjwtlogin.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
}
