package com.learning.crud.controller;

import com.learning.crud.model.Task;
import com.learning.crud.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String myTask(){
        return "tasks";
    }

    @GetMapping("/users/{userId}")
    public String getTask(@PathVariable Long taskId, Model model) {
        // Получаем пользователя из сервиса по его ID
        Task task = taskService.findTaskById(taskId);

        // Передаем имя пользователя в модель для использования в шаблоне Thymeleaf
        model.addAttribute("task", task);

        return "task"; // Возвращает имя шаблона Thymeleaf для страницы пользователя
    }

    @GetMapping("/all")
    public String showAll(){
        return "tasks";
    }
}
