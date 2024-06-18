package com.dissident.models.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 50)
    private String username;

    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 320)
    @Email
    private String email;

    @Column(nullable = false)
    private LocalDate joinedDate = LocalDate.now();

    @Column(nullable = false)
    @Size(max = 30)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    @JsonIgnore
    private String passwordSalt;

    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;

}
