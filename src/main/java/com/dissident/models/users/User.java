package com.dissident.models.users;

import com.dissident.models.posts.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;

@Entity(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 50, message = "username must be between 5 and 50 characters")
    private String username;

    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 320, message = "Email must be between 10 and 320 characters")
    @Email
    private String email;

    @Column(nullable = false)
    @NotNull
    private LocalDate joinedDate = LocalDate.now();

    @Column(nullable = false)
    @Size(max = 30)
    private String password;

    @Column(nullable = false)
    private String passwordSalt;

    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="FOLLOWS",
            joinColumns={@JoinColumn(name="following_user_id")},
            inverseJoinColumns={@JoinColumn(name="followed_user_id")})
    private Set<User> followers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="FOLLOWS",
            joinColumns={@JoinColumn(name="followed_user_id")},
            inverseJoinColumns={@JoinColumn(name="following_user_id")})
    private Set<User> following = new HashSet<>();

    @Version
    private int version;
}
