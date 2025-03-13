package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.dto.PostUpdateDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<PostDto> findAllPosts();
    PostDto savePost(PostDto postDto);
    PostDto getPostById(UUID id);
    void updatePost(PostUpdateDto postUpdateDto);
    void deletePostById(UUID id);
}
