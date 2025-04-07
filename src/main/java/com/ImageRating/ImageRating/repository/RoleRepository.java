package com.ImageRating.ImageRating.repository;

import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.Roles;
import com.ImageRating.ImageRating.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByRole(Roles Roles);
}