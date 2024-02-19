package com.tesda.bankwebapp.services;

import com.tesda.bankwebapp.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);


//    Optional<User> findByUsernameEmailMobile(String username, String email, String mobile);
    void createUser(User user);

//    Optional<User> findByUsername(String username);


}
