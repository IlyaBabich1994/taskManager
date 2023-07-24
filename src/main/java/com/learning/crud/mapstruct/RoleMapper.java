package com.learning.crud.mapstruct;

import com.learning.crud.model.Role;
import com.learning.crud.model.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDTO roleDTO);

    RoleDTO toRoleDto(Role role);
}
