package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.dto.RegistrationDto;
import com.ImageRating.ImageRating.dto.UserLoginDto;
import com.ImageRating.ImageRating.models.TokenResponse;
import com.ImageRating.ImageRating.service.TokenService;
import com.ImageRating.ImageRating.service.UserRegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ProfileDto register(@RequestBody RegistrationDto registrationDto) {
        return userRegistrationService.registerUser(registrationDto);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDto.userName(), userLoginDto.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "logout success";
    }
}
