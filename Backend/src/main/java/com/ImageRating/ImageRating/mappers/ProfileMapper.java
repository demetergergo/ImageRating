package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.models.UserEntity;

public class ProfileMapper {
    public static ProfileDto mapToProfileDto(UserEntity userEntity) {
        return new ProfileDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getBiography()
        );
    }
}
