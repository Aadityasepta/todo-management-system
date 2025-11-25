package com.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TodoManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoManagementSystemApplication.class, args);
    }

}
