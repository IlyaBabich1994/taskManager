package com.learning.crud.service;

import com.learning.crud.model.Task;

import java.util.List;

public interface TaskService {
    Task findTaskById(Long id);
    List<Task> findAll();
    void deleteById(Long id);

    List<Task> findTasksByNameIn(List<String> taskNames);
    Task save(Task task);
}
