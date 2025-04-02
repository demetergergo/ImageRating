package com.ImageRating.ImageRating.dto;

import lombok.Data;


public record RegistrationDto(
        String userName,
        String password,
        String email,
        String biography) {
}
