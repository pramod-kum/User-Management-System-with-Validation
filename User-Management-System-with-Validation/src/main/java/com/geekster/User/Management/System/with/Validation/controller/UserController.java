package com.geekster.User.Management.System.with.Validation.controller;

import com.geekster.User.Management.System.with.Validation.model.UserModel;
import com.geekster.User.Management.System.with.Validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserService userservice;


@PostMapping("/addUser")
    public String addUser(@Valid @RequestBody UserModel usermodel){
        return userservice.addNewUser(usermodel);
    }
@GetMapping("/getAllUser")
    public ArrayList<UserModel> getAllUser(){
    return userservice.getAllUsers();
    }

    @GetMapping("getUser/{userid}")
    public UserModel getUser(@PathVariable int userid){
    return userservice.getUserById(userid);
    }

    @PutMapping("/updateUserInfo/{userid}")
    public String updateUserInfo(@PathVariable int userid , @RequestBody UserModel usermodel){
    return userservice.updateUser(userid , usermodel);
    }
    @DeleteMapping("/deleteUser/{userid}")
    public String deleteUser(@PathVariable int userid){
    return userservice.deleteUserById(userid);
    }
}


