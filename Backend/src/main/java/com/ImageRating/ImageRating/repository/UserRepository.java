package com.ImageRating.ImageRating.repository;

import com.ImageRating.ImageRating.models.Post;
import com.ImageRating.ImageRating.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
