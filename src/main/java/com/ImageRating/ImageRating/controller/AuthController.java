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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String admin() {
        return "admin ";
    }
    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public String user() {
        return "user ";
    }


    @GetMapping("/currentUsersRoles")
    @ResponseStatus(HttpStatus.OK)
    public String currentUsersRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        String roles = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));
        return "User: " + name + " has roles: " + roles;
    }


}
