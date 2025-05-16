package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.models.Post;
import com.ImageRating.ImageRating.repository.ImageRepository;
import com.ImageRating.ImageRating.repository.PostRepository;
import com.ImageRating.ImageRating.repository.UserRepository;
import com.ImageRating.ImageRating.service.PostInteractionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostInteractionServiceImpl implements PostInteractionService {
    private PostRepository postRepository;
    private UserRepository userRepository;
    private PostServiceImpl postServiceImpl;

    public PostInteractionServiceImpl(PostRepository postRepository, UserRepository userRepository, PostServiceImpl postServiceImpl) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postServiceImpl = postServiceImpl;
    }

    @Override
    public void likePostToggle(UUID id, String userName) {
        Post originalPost = postServiceImpl.findOriginalPost(id);
        userRepository.findByUsername(userName).ifPresent(
                userEntity -> {
                    if(originalPost.getUserLikes().contains(userEntity)){
                        originalPost.getUserLikes().remove(userEntity);
                    }else{
                        originalPost.getUserLikes().add(userEntity);
                    }
                }
        );
        postRepository.save(originalPost);
    }
}
