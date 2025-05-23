package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.CreatePostDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.dto.PostUpdateDto;
import com.ImageRating.ImageRating.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @ResponseBody
    public PostDto createPost(@RequestBody CreatePostDto createPostDto) {
        return postService.savePost(createPostDto);
    }

    @PutMapping("/posts/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
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
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @ResponseBody
    public String deletePost(@PathVariable UUID id) {
        postService.deletePostById(id);
        return "Post deleted";
    }

}
