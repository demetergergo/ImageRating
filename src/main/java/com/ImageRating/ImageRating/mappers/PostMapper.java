package com.ImageRating.ImageRating.mappers;

import com.ImageRating.ImageRating.dto.ImageDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.models.Post;

import java.util.stream.Collectors;

import static com.ImageRating.ImageRating.mappers.ImageMapper.mapToImageDto;

public class PostMapper {
    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.id(),
                post.title(),
                post.description(),
                post.images().stream().map(ImageMapper::mapToImageDto).collect(Collectors.toList()),
                post.createdOn(),
                post.updatedOn()
        );
    }
    public static Post mapToPost(PostDto postDto) {
        return new Post(
                postDto.id(),
                postDto.title(),
                postDto.description(),
                postDto.images().stream().map(ImageMapper::mapToImage).collect(Collectors.toList()),
                postDto.createdOn(),
                postDto.updatedOn()
        );
    }
}
