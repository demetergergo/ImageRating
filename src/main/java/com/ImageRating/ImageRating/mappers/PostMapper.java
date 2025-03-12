package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.models.Post;

import java.util.stream.Collectors;

import static com.ImageRating.ImageRating.mappers.ImageMapper.mapToImageDto;

public class PostMapper {
    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getImages().stream().map(ImageMapper::mapToImageDto).collect(Collectors.toList()),
                post.getCreatedOn(),
                post.getUpdatedOn()
        );
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
}
