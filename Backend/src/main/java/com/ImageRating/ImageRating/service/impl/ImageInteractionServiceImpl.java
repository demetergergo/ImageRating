package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.models.Image;
import com.ImageRating.ImageRating.models.UserEntity;
import com.ImageRating.ImageRating.repository.ImageRepository;
import com.ImageRating.ImageRating.repository.UserRepository;
import com.ImageRating.ImageRating.service.ImageInteractionService;
import com.ImageRating.ImageRating.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ImageInteractionServiceImpl implements ImageInteractionService {
    private ImageRepository imageRepository;
    private UserRepository userRepository;
    private ImageServiceImpl imageServiceImpl;

    public ImageInteractionServiceImpl(ImageRepository imageRepository, UserRepository userRepository, ImageServiceImpl imageServiceImpl) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.imageServiceImpl = imageServiceImpl;
    }

    @Override
    public void likeImageToggle(UUID id, String userName) {
        Image originalImage = imageServiceImpl.findOriginalImage(id);
        userRepository.findByUsername(userName).ifPresent(
                userEntity -> {
                    if(originalImage.getUserLikes().contains(userEntity)){
                        originalImage.getUserLikes().remove(userEntity);
                    }else{
                        originalImage.getUserLikes().add(userEntity);
                    }
                }
        );
        imageRepository.save(originalImage);
    }
}
