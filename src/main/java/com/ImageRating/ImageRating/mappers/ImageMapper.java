package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.models.Image;

public class ImageMapper {
    public static ImageDto mapToImageDto(Image image) {
        return new ImageDto(
                image.getId(),
                image.getPhotoUrl(),
                image.getRating()
        );
    }
    public static Image mapToImage(ImageDto imageDto) {
        Image image = new Image();
        image.setId(imageDto.getId());
        image.setPhotoUrl(imageDto.getPhotoUrl());
        image.setRating(imageDto.getRating());
        return image;
    }
}
