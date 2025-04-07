package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.models.Roles;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface RoleService {
    RoleDto findByRole(Roles Roles);
}
