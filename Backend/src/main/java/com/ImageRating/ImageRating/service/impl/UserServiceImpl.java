package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.mappers.ProfileMapper;
import com.ImageRating.ImageRating.mappers.RegistrationMapper;
import com.ImageRating.ImageRating.mappers.RoleMapper;
import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.Roles;
import com.ImageRating.ImageRating.models.UserEntity;
import com.ImageRating.ImageRating.repository.RoleRepository;
import com.ImageRating.ImageRating.repository.UserRepository;
import com.ImageRating.ImageRating.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final RoleServiceImpl roleService;
    private final RoleRepository roleRepository;

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(RoleServiceImpl roleService, UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public ProfileDto saveUser(RegistrationDto registrationDto, RoleDto defaultRole) {
        UserEntity userEntity = RegistrationMapper.mapToUserEntity(registrationDto);

        userEntity.setRoles(Collections.singletonList(RoleMapper.mapToRole(defaultRole)));

        userEntity.setPassword(passwordEncoder.encode(registrationDto.password()));
        userRepository.save(userEntity);

        return ProfileMapper.mapToProfileDto(userRepository.findByUsername(registrationDto.userName()).get());
    }

    @Override
    public boolean existsByUsername(String username) {
        return  userRepository.existsByUsername(username);
    }

    @Override
    public UUID findByUsername(String username) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get().getId();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void promoteUserToAdmin(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        RoleDto role = roleService.findByRole(Roles.ADMIN);
        if (user.getRoles().stream().anyMatch(userRole -> userRole.getRole().equals(Roles.ADMIN))) {
            throw new RuntimeException("User is already an admin");
        }
        user.getRoles().add(RoleMapper.mapToRole(role));
        userRepository.save(user);
    }

    @Override
    public void demoteUserFromAdmin(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findByRole(Roles.ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().remove(role);
        userRepository.save(user);
    }

    @Override
    public List<ProfileDto> getAllUsers() {
        return userRepository.findAll().stream().map(ProfileMapper::mapToProfileDto).toList();
    }
}

