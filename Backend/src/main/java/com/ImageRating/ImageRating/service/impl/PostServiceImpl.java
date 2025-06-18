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
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private boolean isPostFavoritedByCurrentUser(Post post, String username) {
        return post.getUserLikes().stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public List<PostDto> findAllPosts(String username) {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> PostMapper.mapToPostDto(post, isPostFavoritedByCurrentUser(post, username)))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto savePost(CreatePostDto createPostDto) {
        Post post = PostMapper.mapToPost(createPostDto);
        Post savedPost = postRepository.save(post);
        return PostMapper.mapToPostDto(savedPost);
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

    protected Post findOriginalPost(UUID postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new RuntimeException("Post not found with id: " + postId +
                        " //TODO: Add custom exception"));
    }

    private void inheritFields(Post originalPost, PostUpdateDto postUpdateDto) {
        Post updater = PostMapper.mapToPost(postUpdateDto);
        originalPost.setTitle(updater.getTitle());
        originalPost.setDescription(updater.getDescription());
    }
}
