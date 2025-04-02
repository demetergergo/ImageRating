package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;

public interface UserRegistrationService {
    ProfileDto registerUser(RegistrationDto registrationDto);
}
