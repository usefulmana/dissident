package com.dissident.service;

import com.dissident.models.users.User;
import com.dissident.repos.UserRepository;
import com.dissident.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository
                .findAll()
                .forEach(users::add);
        return users;
    }
}
