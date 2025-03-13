package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.mappers.ImageMapper;
import com.ImageRating.ImageRating.models.Image;
import com.ImageRating.ImageRating.models.Post;
import com.ImageRating.ImageRating.repository.ImageRepository;
import com.ImageRating.ImageRating.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ImageDto> findAllImages() {
        List<Image> images = imageRepository.findAll();
        return images.stream()
                .map(ImageMapper::mapToImageDto)
                .toList();
    }

    @Override
    public ImageDto saveImage(ImageDto imageDto) {
        Image image = ImageMapper.mapToImage(imageDto);
        imageRepository.save(image);
        return ImageMapper.mapToImageDto(image);
    }

    @Override
    public ImageDto getImageById(UUID id) {
        return ImageMapper.mapToImageDto(findOriginalImage(id));
    }

    @Override
    public void updateImage(ImageDto imageDto) {
        Image image = ImageMapper.mapToImage(imageDto);
        imageRepository.save(image);
    }

    @Override
    public void deleteImageById(UUID id) {
        findOriginalImage(id);
        imageRepository.deleteById(id);
    }

    private Image findOriginalImage(UUID imageId) {
        return imageRepository.findById(imageId).orElseThrow(() ->
                new RuntimeException("Post not found " +
                        "//TODO: Add custom exception"));
    }
}
