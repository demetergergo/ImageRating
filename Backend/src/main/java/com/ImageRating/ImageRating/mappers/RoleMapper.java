package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.models.Image;
import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.UserEntity;

public class RoleMapper {
    public static RoleDto mapToRoleDto(Role role) {
        return new RoleDto(
                role.getId(),
                role.getRole()
        );
    }

    public static Role mapToRole(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.id());
        role.setRole(roleDto.role());
        return role;
    }
}
