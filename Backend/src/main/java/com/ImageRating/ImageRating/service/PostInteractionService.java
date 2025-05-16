package com.ImageRating.ImageRating.service;

import java.util.UUID;

public interface PostInteractionService {
    void likePostToggle(UUID id, String userName);
}
