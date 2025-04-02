package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.dto.UserLoginDto;
import com.ImageRating.ImageRating.models.Roles;
import com.ImageRating.ImageRating.service.RoleService;
import com.ImageRating.ImageRating.service.TokenService;
import com.ImageRating.ImageRating.service.UserRegistrationService;
import com.ImageRating.ImageRating.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRegistrationService userRegistrationService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager, UserRegistrationService userRegistrationService) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/token")
    public String token(@RequestBody UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.userName(), userLoginDto.password()));
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ProfileDto register(@RequestBody RegistrationDto registrationDto) {
        return userRegistrationService.registerUser(registrationDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDto.userName(), userLoginDto.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Authentication loggedinUser = SecurityContextHolder.getContext().getAuthentication();
        loggedinUser.getName();
        return "Logged in " + loggedinUser.getName() + "!";
    }
}
