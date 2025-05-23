package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.UserEntity;
import com.ImageRating.ImageRating.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Logger logger = Logger.getLogger(CustomUserDetailsServiceImpl.class.getName());
        logger.info("User found: " + user.getUsername());
        user.getRoles().stream().forEach(role -> {
            logger.info("Role: " + role.getRole());
        });
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    private Collection<GrantedAuthority> mapRolesToAuthorties(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole().toString())).collect(Collectors.toList());
    }
}
