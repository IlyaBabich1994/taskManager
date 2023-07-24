package com.learning.crud.model.dto;

import com.learning.crud.model.User;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private String status;
    private String project;
    private List<UserDTO> users; // Ссылка на список пользователей, связанных с задачей
}
