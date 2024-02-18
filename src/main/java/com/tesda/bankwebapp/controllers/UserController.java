package com.tesda.bankwebapp.controllers;


import com.tesda.bankwebapp.exceptions.UserException;
import com.tesda.bankwebapp.models.User;
import com.tesda.bankwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException{
        String username = body.get("username");
        if(!userService.findByUsername(username).isEmpty()){
            throw new UserException("Username already exists.");
        }else{
            String password = body.get("password");
            String firstname = body.get("firstname");
            String lastname = body.get("lastname");
            String mobile = body.get("mobile");
            String email = body.get("email");

            User newUser = new User(username, password, firstname, lastname, mobile, email);

            userService.createUser(newUser);

            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);

        }
    }
}