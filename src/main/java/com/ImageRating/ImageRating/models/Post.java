package com.ImageRating.ImageRating.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "posts")
@Entity
public record Post(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,

        String title,
        String description,

        @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
        List<Image> images,

        @CreationTimestamp
        LocalDateTime createdOn,

        @UpdateTimestamp
        LocalDateTime updatedOn) {
}
