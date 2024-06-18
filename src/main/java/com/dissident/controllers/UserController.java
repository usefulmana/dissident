package com.dissident.controllers;

import com.dissident.models.users.User;
import com.dissident.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id){
        return userService.findById(UUID.fromString(id)).orElse(null);
    }
}
