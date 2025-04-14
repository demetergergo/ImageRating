package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.UserEntity;

import java.util.UUID;

public interface UserService {
    ProfileDto saveUser(RegistrationDto registrationDto, RoleDto defaultRole);
    boolean existsByUsername(String username);
    UUID findByUsername(String username);
    void promoteUserToAdmin(UUID userId);
    void demoteUserFromAdmin(UUID userId);
}
