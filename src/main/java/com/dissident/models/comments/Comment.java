package com.dissident.models.comments;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "COMMENTS")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Lob
    private String body;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommentStatus commentStatus;

    @Version
    private int version;
}
