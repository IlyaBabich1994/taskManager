package com.learning.crud.service;

import com.learning.crud.model.Task;
import com.learning.crud.model.User;
import com.learning.crud.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        logger.info("TaskServiceImpl constructor" + taskRepository);
    }

    @Override
    @Transactional(readOnly = true)
    public Task findTaskById(Long id) {
        logger.info("Looking for task by id" + id + "in TaskServiceImpl");
        return taskRepository.findTaskById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findTaskBuUser(User user) {
        return taskRepository.findTaskByUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id == null) {
            throw new RuntimeException("Id is null");
        }
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findTasksByNameIn(List<String> taskNames) {
        return taskRepository.findTasksByNameIn(taskNames);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        if (task == null) {
            throw new RuntimeException("Task is null");
        }
        return taskRepository.save(task);
    }
}
