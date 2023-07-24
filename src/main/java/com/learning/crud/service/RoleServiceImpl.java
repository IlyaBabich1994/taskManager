package com.learning.crud.service;

import com.learning.crud.model.Role;
import com.learning.crud.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findRolesByNameIn(List<String> roleNames) {
        return roleRepository.findRolesByNameIn(roleNames);
    }
}
