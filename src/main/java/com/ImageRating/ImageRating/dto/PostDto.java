package com.ImageRating.ImageRating.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PostDto(
    UUID id,
    String title,
    String description,
    List<ImageDto> images,
    LocalDateTime createdOn,
    LocalDateTime updatedOn
) {
}