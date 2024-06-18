package com.dissident.service.interfaces;

import com.dissident.models.users.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    Optional<User> findById(UUID uuid);
    List<User> findAll();
}
