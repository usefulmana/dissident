package com.dissident.dtos;

import com.dissident.models.users.AccountStatus;
import com.dissident.models.users.Gender;
import com.dissident.models.users.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    private String username;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate joinedDate;
    private LocalDate birthDay;
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private AccountStatus accountStatus;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<UserDTO> following = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<UserDTO> followers = new HashSet<>();

    public static UserDTO fromUser(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setJoinedDate(user.getJoinedDate());
        dto.setBirthDay(user.getBirthDay());
        dto.setGender(user.getGender());
        dto.setFollowers(user
                .getFollowers()
                .stream()
                .map(UserDTO::fromUserSimple)
                .collect(Collectors.toSet()));
        dto.setFollowing(user
                .getFollowing()
                .stream()
                .map(UserDTO::fromUserSimple)
                .collect(Collectors.toSet()));
        return dto;
    }

    public static UserDTO fromUserSimple(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public User toUser(){
        User user = new User();
        user.setUsername(getUsername());
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setBirthDay(getBirthDay());
        user.setGender(getGender());
        user.setAccountStatus(getAccountStatus());
        return user;
    }

}
