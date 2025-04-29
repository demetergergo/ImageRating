package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.CreateImageDto;
import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.models.Image;

public class ImageMapper {
    public static ImageDto mapToImageDto(Image image) {
        return new ImageDto(
                image.getId(),
                image.getPhotoUrl(),
                image.getUserLikes().size()
        );
    }
    public static Image mapToImage(ImageDto imageDto) {
        Image image = new Image();
        image.setId(imageDto.getId());
        image.setPhotoUrl(imageDto.getPhotoUrl());
        return image;
    }
    public static Image mapToImage(CreateImageDto createImageDto) {
        Image image = new Image();
        image.setPhotoUrl(createImageDto.getPhotoUrl());
        return image;
    }
}
