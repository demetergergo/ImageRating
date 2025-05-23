package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.CreatePostDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.dto.PostUpdateDto;
import com.ImageRating.ImageRating.models.Post;

import java.util.stream.Collectors;

public class PostMapper {
    public static PostDto mapToPostDto(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getDescription(), post.getImages().stream().map(ImageMapper::mapToImageDto).collect(Collectors.toList()), post.getCreatedOn(), post.getUpdatedOn());
    }

    public static Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setImages(postDto.getImages().stream().map(ImageMapper::mapToImage).collect(Collectors.toList()));
        post.setCreatedOn(postDto.getCreatedOn());
        post.setUpdatedOn(postDto.getUpdatedOn());
        return post;
    }

    public static Post mapToPost(PostUpdateDto postUpdateDto) {
        Post post = new Post();
        post.setId(postUpdateDto.getId());
        post.setTitle(postUpdateDto.getTitle());
        post.setDescription(postUpdateDto.getDescription());
        return post;
    }

    public static Post mapToPost(CreatePostDto createPostDto){
        Post post = new Post();
        post.setTitle(createPostDto.getTitle());
        post.setDescription(createPostDto.getDescription());
        post.setImages(createPostDto.getImages().stream().map(ImageMapper::mapToImage).collect(Collectors.toList()));
        return post;
    }
}
