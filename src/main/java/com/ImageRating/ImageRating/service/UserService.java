package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.UserEntity;

public interface UserService {
    ProfileDto saveUser(RegistrationDto registrationDto, RoleDto defaultRole);
    boolean existsByUsername(String username);
}
