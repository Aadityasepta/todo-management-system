package com.todoapp.repository;

import com.todoapp.entity.Task;
import com.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByUser(User user);
    
    List<Task> findByUserAndStatus(User user, String status);
    
    List<Task> findByUserOrderByCreatedAtDesc(User user);
    
    List<Task> findByReminderDateBeforeAndStatus(LocalDateTime date, String status);
}
