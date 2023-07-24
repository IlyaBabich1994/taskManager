package com.learning.crud.service;

import com.learning.crud.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    void saveRole(Role role);
    Optional<Role> findRoleByName(String name);

    List<Role> findRolesByNameIn(List<String> roleNames);
}
