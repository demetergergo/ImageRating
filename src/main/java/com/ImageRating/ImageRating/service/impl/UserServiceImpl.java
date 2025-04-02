package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.mappers.ProfileMapper;
import com.ImageRating.ImageRating.mappers.RegistrationMapper;
import com.ImageRating.ImageRating.mappers.RoleMapper;
import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.UserEntity;
import com.ImageRating.ImageRating.repository.RoleRepository;
import com.ImageRating.ImageRating.repository.UserRepository;
import com.ImageRating.ImageRating.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        return false;
    }
}
