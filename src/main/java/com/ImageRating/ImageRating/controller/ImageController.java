package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDto>> imageList() {
        return new ResponseEntity<>(imageService.findAllImages(), HttpStatus.OK);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<ImageDto> getImageById(@PathVariable UUID id) {
        return new ResponseEntity<>(imageService.getImageById(id), HttpStatus.OK);
    }

//    @PostMapping("/images/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<ImageDto> createImage(@RequestBody ImageDto imageDto) {
//        ImageDto result = imageService.saveImage(imageDto);
//        return new ResponseEntity<>(result, HttpStatus.CREATED);
//    }

    @PutMapping("/images/{id}/update")
    public ResponseEntity<ImageDto> updateImage(@PathVariable UUID id, @RequestBody ImageDto imageDto) {
        imageDto.setId(id);
        imageService.updateImage(imageDto);
        return new ResponseEntity<>(imageDto, HttpStatus.OK);
    }

    @DeleteMapping("/images/{id}/delete")
    public ResponseEntity<String> deleteImage(@PathVariable UUID id) {
        imageService.deleteImageById(id);
        return new ResponseEntity<>("Image deleted", HttpStatus.OK);
    }
}
