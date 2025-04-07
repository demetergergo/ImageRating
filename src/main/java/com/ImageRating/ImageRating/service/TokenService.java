package com.ImageRating.ImageRating.service;

import com.ImageRating.ImageRating.models.TokenResponse;
import org.springframework.security.core.Authentication;

public interface TokenService {
    public TokenResponse generateToken(Authentication authentication);
}
