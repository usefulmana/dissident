package com.dissident.service.interfaces;

import com.dissident.dtos.UserDTO;
import com.dissident.models.users.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    UserDTO findById(UUID uuid);
    List<UserDTO> findAll();
    UUID addUser(UserDTO user);
}
