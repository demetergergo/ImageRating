package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.models.Image;

public class ImageMapper {
    public static ImageDto mapToImageDto(Image image) {
        return new ImageDto(
                image.id(),
                image.photoUrl(),
                image.rating(),
                image.post()
        );
    }
    public static Image mapToImage(ImageDto imageDto) {
        return new Image(
                imageDto.id(),
                imageDto.photoUrl(),
                imageDto.rating(),
                imageDto.post()
        );
    }
}
