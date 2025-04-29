package com.ImageRating.ImageRating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateImageDto {
    private String photoUrl;
    private int rating;
}
