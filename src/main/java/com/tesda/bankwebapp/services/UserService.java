package com.tesda.bankwebapp.services;

import com.tesda.bankwebapp.models.User;

import java.util.Optional;

public interface UserService {

    void createUser(User user);

    Optional<User> findByUsername(String username);
}
