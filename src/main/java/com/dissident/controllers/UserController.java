package com.dissident.controllers;

import com.dissident.dtos.ResourceCreatedResponse;
import com.dissident.dtos.UserDTO;
import com.dissident.models.users.User;
import com.dissident.service.interfaces.IUserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable String id){
        return userService.findById(UUID.fromString(id));
    }

    @PostMapping("/user")
    public ResponseEntity<ResourceCreatedResponse> addUser(@RequestBody UserDTO user){
        return ResponseEntity.ok(new ResourceCreatedResponse(userService.addUser(user).toString()));
    }

}
