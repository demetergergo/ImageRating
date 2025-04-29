package com.ImageRating.ImageRating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private UUID id;
    private String username;
    private String email;
    private String biography;
}
