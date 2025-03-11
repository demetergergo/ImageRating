package com.ImageRating.ImageRating.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
public record post(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,

        String title,
        Image image,
        double rating,

        @CreationTimestamp
        LocalDateTime createdOn,

        @UpdateTimestamp
        LocalDateTime updatedOn) {
}
