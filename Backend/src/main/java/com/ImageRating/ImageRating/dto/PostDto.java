package com.ImageRating.ImageRating.dto;

import com.ImageRating.ImageRating.dto.ImageDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private UUID id;
    private String title;
    private String description;
    private int rating;
    private List<ImageDto> images;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}