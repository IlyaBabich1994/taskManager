package com.learning.crud.repository;

import com.learning.crud.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<Task> findTaskById(Long id);
    List<Task> findAll();
    void deleteById(Long id);
    Task save(Task task);
    List<Task> findTasksByNameIn(List<String> taskNames);
    @Override
    void delete(Task entity);
}
