package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.dto.PostUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ImageService {
    List<ImageDto> findAllImages();
    ImageDto saveImage(ImageDto imageDto);
    ImageDto getImageById(UUID id);
    void updateImage(ImageDto imageDto);
    void deleteImageById(UUID id);
}
