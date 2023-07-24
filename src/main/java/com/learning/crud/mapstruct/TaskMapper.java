package com.learning.crud.mapstruct;

import com.learning.crud.model.Task;
import com.learning.crud.model.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "users", source = "users")
    TaskDTO toTaskDto(Task task);

    @Mapping(target = "users", source = "users")
    Task toTask(TaskDTO taskDTO);
}