package com.dissident.service;

import com.dissident.dtos.UserDTO;
import com.dissident.models.users.User;
import com.dissident.repos.UserRepository;
import com.dissident.service.interfaces.IUserService;
import jakarta.persistence.EntityNotFoundException;
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
    public UserDTO findById(UUID uuid) {
        User user = userRepository
                .findById(uuid)
                .orElseThrow(EntityNotFoundException::new);
        return UserDTO.fromUser(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        userRepository
                .findAll()
                .forEach(u -> users.add(UserDTO.fromUser(u)));
        return users;
    }

    @Override
    public UUID addUser(UserDTO user) {
        return userRepository.save(user.toUser()).getId();
    }

}
