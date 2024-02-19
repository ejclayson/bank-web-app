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


//    check if email exists
    @RequestMapping(value = "/users/check", method = RequestMethod.POST)
    public ResponseEntity<Object> checkDuplicate(@RequestBody Map<String, String> body) throws UserException{
        String username = body.get("username");
        String email = body.get("email");
        String mobile = body.get("mobile");
        if(!userService.findByUsername(username).isPresent()){
            if(!userService.findByEmail(email).isPresent()){
                if(!userService.findByMobile(mobile).isPresent()){
//                    String firstname = body.get("firstname");
//                    String lastname = body.get("lastname");
//                    String password = body.get("password");
//                    User newUser = new User(username, firstname, lastname,  email, mobile, password);
//                    userService.createUser(newUser);
//                    return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
                    return new ResponseEntity<>(false, HttpStatus.CREATED);
                }else{
                    //throw new UserException("Mobile already exists.");
                    return new ResponseEntity<>(true, HttpStatus.CREATED);
                }
            }else{
                //throw new UserException("Email already exists.");
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            }
        }else{
            //throw new UserException("Username already exists.");
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
    }


// add or register a user


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException{
        String username = body.get("username");
        String email = body.get("email");
        String mobile = body.get("mobile");
        String firstname = body.get("firstname");
        String lastname = body.get("lastname");
        String password = body.get("password");
        if(!userService.findByUsername(username).isPresent()){
            if(!userService.findByEmail(email).isPresent()){
                if(!userService.findByMobile(mobile).isPresent()){

                    User newUser = new User(username, firstname, lastname,  email, mobile, password);
                    userService.createUser(newUser);
//                    return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
                    return new ResponseEntity<>(true, HttpStatus.CREATED);
                }else{
                    //throw new UserException("Mobile already exists.");
                    return new ResponseEntity<>(true, HttpStatus.CREATED);
                }
            }else{
                //throw new UserException("Email already exists.");
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            }
        }else{
            //throw new UserException("Username already exists.");
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }







//        if(!userService.findByUsername(username).isPresent()){
//            if(!userService.findByEmail(email).isPresent()){
//                if(!userService.findByMobile(mobile).isPresent()){
//                    return new ResponseEntity<>(false, HttpStatus.CREATED);
//                }else{
//                    //throw new UserException("Mobile already exists.");
//                    return new ResponseEntity<>(true, HttpStatus.CREATED);
//                }
//            }else{
//                //throw new UserException("Email already exists.");
//                return new ResponseEntity<>(true, HttpStatus.CREATED);
//            }
//        }else{
//            //throw new UserException("Username already exists.");
//            return new ResponseEntity<>(true, HttpStatus.CREATED);
//        }
    }









}