package com.ImageRating.ImageRating.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private UUID id;
    private String photoUrl;
}