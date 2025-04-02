package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.models.Roles;
import com.ImageRating.ImageRating.service.RoleService;
import com.ImageRating.ImageRating.service.UserRegistrationService;
import com.ImageRating.ImageRating.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private final UserService userService;
    private final RoleService roleService;

    public UserRegistrationServiceImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public ProfileDto registerUser(RegistrationDto registrationDto) {
        if (userService.existsByUsername(registrationDto.userName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }
        RoleDto defaultRole = roleService.findByRole(Roles.USER);
        return userService.saveUser(registrationDto, defaultRole);
    }
}