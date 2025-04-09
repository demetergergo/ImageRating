package com.ImageRating.ImageRating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDto {
    private String title;
    private String description;
    private List<CreateImageDto> images;
}
