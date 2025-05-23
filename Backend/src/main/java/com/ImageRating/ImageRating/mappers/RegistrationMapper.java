package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.models.Image;
import com.ImageRating.ImageRating.models.UserEntity;

public class RegistrationMapper {
    public static ImageDto mapToImageDto(Image image) {
        return new ImageDto(
                image.getId(),
                image.getPhotoUrl(),
                image.getUserLikes().size()
        );
    }

    //password, roles must be set outside of this method
    public static UserEntity mapToUserEntity(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.userName());
        user.setEmail(registrationDto.email());
        user.setBiography(registrationDto.biography());
        return user;
    }

}
