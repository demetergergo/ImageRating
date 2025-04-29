package com.ImageRating.ImageRating.repository;

import com.ImageRating.ImageRating.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
