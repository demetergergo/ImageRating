package com.ImageRating.ImageRating.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "images")
public record Image(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        String photoUrl,
        double rating,

        @ManyToOne
        @JoinColumn(name="post_id", nullable = false)
        Post post
) {
}
