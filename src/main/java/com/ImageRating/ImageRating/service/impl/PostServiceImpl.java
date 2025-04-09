package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.dto.CreatePostDto;
import com.ImageRating.ImageRating.dto.PostDto;
import com.ImageRating.ImageRating.dto.PostUpdateDto;
import com.ImageRating.ImageRating.mappers.PostMapper;
import com.ImageRating.ImageRating.models.Post;
import com.ImageRating.ImageRating.repository.PostRepository;
import com.ImageRating.ImageRating.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostMapper::mapToPostDto)
                .toList();
    }

    @Override
    public PostDto savePost(CreatePostDto createPostDto) {
        Post post = PostMapper.mapToPost(createPostDto);
        post.getImages().forEach(image -> image.setPost(post));
        Post postRespone = postRepository.save(post);
        return PostMapper.mapToPostDto(postRespone);
    }

    @Override
    public PostDto getPostById(UUID id) {
        Post post = findOriginalPost(id);
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public void updatePost(PostUpdateDto postUpdateDto) {
        Post post = findOriginalPost(postUpdateDto.getId());
        inheritFields(post, postUpdateDto);
        postRepository.save(post);
    }

    @Override
    public void deletePostById(UUID id) {
        findOriginalPost(id);
        postRepository.deleteById(id);
    }

    private Post findOriginalPost(UUID postDto) {
        return postRepository.findById(postDto).orElseThrow(() ->
                new RuntimeException("Post not found " +
                        "//TODO: Add custom exception"));
    }

    private void inheritFields(Post originalPost, PostUpdateDto postUpdateDto) {
        Post updater = PostMapper.mapToPost(postUpdateDto);
        originalPost.setTitle(updater.getTitle());
        originalPost.setDescription(updater.getDescription());
    }
}
