package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.dto.PostUpdateDto;
import com.ImageRating.ImageRating.models.Image;
import com.ImageRating.ImageRating.models.Post;
import com.ImageRating.ImageRating.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> listPosts() {
        return new ResponseEntity<>(postService.findAllPosts(), HttpStatus.OK);
    }

    @PostMapping("/posts/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto result = postService.savePost(postDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}/update")
    public ResponseEntity<PostUpdateDto> updatePost(@PathVariable UUID id, @RequestBody PostUpdateDto postUpdateDto) {
        postUpdateDto.setId(id);
        postService.updatePost(postUpdateDto);
        return new ResponseEntity<>(postUpdateDto, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable UUID id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}/delete")
    public ResponseEntity<String> deletePost(@PathVariable UUID id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted", HttpStatus.OK);
    }

}
