package com.ImageRating.ImageRating.controller;

import com.ImageRating.ImageRating.dto.ProfileDto;
import com.ImageRating.ImageRating.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/promoteToAdmin")
    @ResponseStatus(HttpStatus.OK)
    public String makeAdmin(@RequestBody UUID id) {
        userService.promoteUserToAdmin(id);
        return "User " + SecurityContextHolder.getContext().getAuthentication().getName() + " is now an admin.";
    }

    @PutMapping("/promoteCurrentUserToAdmin")
    @ResponseStatus(HttpStatus.OK)
    public String makeCurrentUserAdmin() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        userService.promoteUserToAdmin(userService.findByUsername(name));
        return "User " + name + " is now an admin.";
    }

    @PutMapping("/demoteFromAdmin")
    @ResponseStatus(HttpStatus.OK)
    public String demoteAdmin(@RequestBody UUID id) {
        userService.demoteUserFromAdmin(id);
        return "User " + SecurityContextHolder.getContext().getAuthentication().getName() + " is no longer an admin.";
    }

    @GetMapping("/getUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileDto> getCurrentUser() {
        return userService.getAllUsers();
    }
}
