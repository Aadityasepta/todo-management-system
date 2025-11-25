package com.todoapp.controller;

import com.todoapp.entity.Task;
import com.todoapp.entity.User;
import com.todoapp.service.TaskService;
import com.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam(required = false) String filter, 
                                Authentication authentication, 
                                Model model) {
        User currentUser = userService.findByUsername(authentication.getName());
        List<Task> tasks;

        if (filter != null && !filter.isEmpty()) {
            if (filter.equalsIgnoreCase("DONE") || filter.equalsIgnoreCase("PENDING")) {
                tasks = taskService.getTasksByUserAndStatus(currentUser, filter.toUpperCase());
            } else {
                tasks = taskService.getAllTasksByUser(currentUser);
            }
        } else {
            tasks = taskService.getAllTasksByUser(currentUser);
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        model.addAttribute("currentFilter", filter != null ? filter : "ALL");
        model.addAttribute("username", currentUser.getUsername());
        
        return "dashboard";
    }

    @PostMapping("/tasks/add")
    public String addTask(@ModelAttribute("newTask") Task task, 
                         Authentication authentication) {
        User currentUser = userService.findByUsername(authentication.getName());
        taskService.createTask(task, currentUser);
        return "redirect:/dashboard";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id, Authentication authentication) {
        User currentUser = userService.findByUsername(authentication.getName());
        Task task = taskService.getTaskById(id);
        
        // Check if task belongs to current user
        if (task.getUser().getId().equals(currentUser.getId())) {
            taskService.deleteTask(id);
        }
        
        return "redirect:/dashboard";
    }

    @GetMapping("/tasks/complete/{id}")
    public String markTaskAsComplete(@PathVariable Long id, Authentication authentication) {
        User currentUser = userService.findByUsername(authentication.getName());
        Task task = taskService.getTaskById(id);
        
        // Check if task belongs to current user
        if (task.getUser().getId().equals(currentUser.getId())) {
            taskService.updateTaskStatus(id, "DONE");
        }
        
        return "redirect:/dashboard";
    }

    @GetMapping("/tasks/pending/{id}")
    public String markTaskAsPending(@PathVariable Long id, Authentication authentication) {
        User currentUser = userService.findByUsername(authentication.getName());
        Task task = taskService.getTaskById(id);
        
        // Check if task belongs to current user
        if (task.getUser().getId().equals(currentUser.getId())) {
            taskService.updateTaskStatus(id, "PENDING");
        }
        
        return "redirect:/dashboard";
    }
}
