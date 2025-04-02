package com.ImageRating.ImageRating.service.impl;

import com.ImageRating.ImageRating.dto.RoleDto;
import com.ImageRating.ImageRating.mappers.RoleMapper;
import com.ImageRating.ImageRating.models.Roles;
import com.ImageRating.ImageRating.repository.RoleRepository;
import com.ImageRating.ImageRating.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto findByRole(Roles Roles) {
        return RoleMapper.mapToRoleDto(roleRepository.findByRole(Roles).get());
    }
}
