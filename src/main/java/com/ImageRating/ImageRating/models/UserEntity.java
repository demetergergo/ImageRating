package com.ImageRating.ImageRating.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
public record UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        String username,
        String email,
        String password,
        @ElementCollection(fetch = FetchType.EAGER)
        @Enumerated(EnumType.STRING)
        List<Role> roles
) {
}
