package com.learning.crud.controller.rest;

import com.learning.crud.mapstruct.TaskMapper;
import com.learning.crud.model.Task;
import com.learning.crud.model.dto.TaskDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learning.crud.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final Logger logger = LoggerFactory.getLogger(TaskRestController.class);


    public TaskRestController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping("/showById")
    public ResponseEntity<Task> showById(@RequestParam(defaultValue = "1") Long id){
        logger.info("Looking for task by id" + id + "in TaskRestController");
        return ResponseEntity.ok().body(taskService.findTaskById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskDTO>> showAll(){
        logger.info("Looking for all tasks in TaskRestController");
        List<Task> tasks = taskService.findAll();
        List<TaskDTO> taskDTOS = tasks.stream().map(taskMapper::toTaskDto).toList();
        return ResponseEntity.ok().body(taskDTOS);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Task> saveOrUpdate(@RequestBody Task task){
        logger.info("Saving task in TaskRestController. Task: " + task);
        taskService.save(task);
        logger.info("Task saved in TaskRestController. Task: " + task);
        return ResponseEntity.ok().body(task);
    }
}
