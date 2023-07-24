package com.learning.crud.model.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String status;
    private String project;
    private List<String> roleNames; // Ссылка на список ролей пользователя
    private List<String> taskNames; // Ссылка на список задач пользователя
}
