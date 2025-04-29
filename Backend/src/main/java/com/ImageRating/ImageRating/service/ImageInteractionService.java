package com.ImageRating.ImageRating.service;

import java.util.UUID;

public interface ImageInteractionService {
    void likeImageToggle(UUID id, String userName);
}
