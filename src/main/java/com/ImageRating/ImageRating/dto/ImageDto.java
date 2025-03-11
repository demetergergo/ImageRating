package com.ImageRating.ImageRating.dto;

import com.ImageRating.ImageRating.models.Post;

import java.util.UUID;

public record ImageDto(
    UUID id,
    String photoUrl,
    double rating,
    Post post
) {
}