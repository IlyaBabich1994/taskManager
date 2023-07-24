package com.learning.crud.mapstruct;

import com.learning.crud.model.Role;
import com.learning.crud.model.Task;
import com.learning.crud.model.User;
import com.learning.crud.model.dto.UserDTO;
import com.learning.crud.service.RoleService;
import com.learning.crud.service.TaskService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "tasks", source = "taskNames", qualifiedByName = "taskNamesToTask"),
            @Mapping(target = "roles", source = "roleNames", qualifiedByName = "roleNamesToRoles")
    })
    abstract User toUser(UserDTO userDTO, @Context TaskService taskService, @Context RoleService roleService);

    @Named("taskNamesToTask")
    default List<Task> taskNamesToTask(List<String> taskNames, @Context TaskService taskService) {
        return taskService.findTasksByNameIn(taskNames);
    }

    @Named("roleNamesToRoles")
    default Set<Role> roleNamesToRoles(List<String> roleNames, @Context RoleService roleService) {
        return new HashSet<>(roleService.findRolesByNameIn(roleNames));
    }

    @Mappings({
            @Mapping(target = "taskNames", source = "tasks", qualifiedByName = "tasksToTaskNames"),
            @Mapping(target = "roleNames", source = "roles", qualifiedByName = "rolesToRoleNames")
    })
    abstract UserDTO toUserDto(User user);

    @Named("tasksToTaskNames")
    default List<String> tasksToTaskNames(List<Task> tasks) {
        return tasks.stream().map(Task::getName).toList();
    }

    @Named("rolesToRoleNames")
    default List<String> rolesToRoleNames(Set<Role> roles) {
        return roles.stream().map(Role::getName).toList();
    }
}
