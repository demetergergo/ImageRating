package com.ImageRating.ImageRating.config;

import com.ImageRating.ImageRating.models.Role;
import com.ImageRating.ImageRating.models.Roles;
import com.ImageRating.ImageRating.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByRole(Roles.USER).isEmpty()) {
            roleRepository.save(new Role(null, Roles.USER));
        }
        if (roleRepository.findByRole(Roles.ADMIN).isEmpty()) {
            roleRepository.save(new Role(null, Roles.ADMIN));
        }
    }
}