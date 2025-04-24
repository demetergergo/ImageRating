package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.service.ImageInteractionService;
import com.ImageRating.ImageRating.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ImageController {
    private ImageService imageService;
    private ImageInteractionService imageInteractionService;

    public ImageController(ImageService imageService, ImageInteractionService imageInteractionService) {
        this.imageService = imageService;
        this.imageInteractionService = imageInteractionService;
    }

    @GetMapping("/images")
    @ResponseStatus(HttpStatus.OK)
    public List<ImageDto> imageList() {
        return imageService.findAllImages();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/images/{id}")
    public ImageDto getImageById(@PathVariable UUID id) {
        return imageService.getImageById(id);
    }

    @DeleteMapping("/images/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteImage(@PathVariable UUID id) {
        imageService.deleteImageById(id);
        return "Image deleted";
    }

    @PutMapping("/images/{id}/like")
    @ResponseStatus(HttpStatus.OK)
    public String likeImage(@PathVariable UUID id) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        imageInteractionService.likeImageToggle(id, userName);
        return "Image like toggled";
    }

//    @PostMapping("/images/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<ImageDto> createImage(@RequestBody ImageDto imageDto) {
//        ImageDto result = imageService.saveImage(imageDto);
//        return new ResponseEntity<>(result, HttpStatus.CREATED);
//    }

//    @PutMapping("/images/{id}/update")
//    @ResponseStatus(HttpStatus.OK)
//    public ImageDto updateImage(@PathVariable UUID id, @RequestBody ImageDto imageDto) {
//        imageDto.setId(id);
//        imageService.updateImage(imageDto);
//        return imageDto;
//    }
}
