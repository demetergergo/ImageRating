package com.ImageRating.ImageRating.dto;

import com.ImageRating.ImageRating.models.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record RoleDto(Long id, Roles role) {}