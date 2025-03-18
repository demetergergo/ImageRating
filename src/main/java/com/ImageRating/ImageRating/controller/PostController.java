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
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PostDto> listPosts() {
        return postService.findAllPosts();
    }

    @PostMapping("/posts/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.savePost(postDto);
    }

    @PutMapping("/posts/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PostDto updatePost(@PathVariable UUID id, @RequestBody PostUpdateDto postUpdateDto) {
        postUpdateDto.setId(id);
        postService.updatePost(postUpdateDto);
        return postService.getPostById(postUpdateDto.getId());
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PostDto getPost(@PathVariable UUID id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/posts/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public String deletePost(@PathVariable UUID id) {
        postService.deletePostById(id);
        return "Post deleted";
    }

}
