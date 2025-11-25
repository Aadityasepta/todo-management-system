package com.todoapp.service;

import com.todoapp.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(name = "spring.mail.host")
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TaskService taskService;

    /**
     * Send email reminder to user
     */
    public void sendTaskReminder(String toEmail, String taskTitle) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Task Reminder: " + taskTitle);
            message.setText("Hello!\n\nThis is a reminder about your pending task:\n\n" 
                          + "Task: " + taskTitle + "\n\n"
                          + "Please complete it at your earliest convenience.\n\n"
                          + "Best regards,\nTo-Do Management System");
            
            mailSender.send(message);
            System.out.println("Reminder email sent to: " + toEmail);
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }

    /**
     * Scheduled task to check for reminders
     * Runs every day at 9 AM
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void checkAndSendReminders() {
        System.out.println("Checking for task reminders...");
        
        List<Task> tasksForReminder = taskService.getTasksForReminder();
        
        for (Task task : tasksForReminder) {
            sendTaskReminder(
                task.getUser().getEmail(),
                task.getTitle()
            );
        }
        
        System.out.println("Reminder check complete. Sent " + tasksForReminder.size() + " reminders.");
    }
}
