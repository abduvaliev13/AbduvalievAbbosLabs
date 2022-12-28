package ru.edu.bsu.spring.abduvaliev.work1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Work1Application {
    public static void main(String[] args) {
        SpringApplication.run(Work1Application.class, args);
        Session  session = new Session();
        Task task = new Task(23, "Student", Boolean.FALSE, "December"); // вывод в консоль состояние объекта Task
        TaskService taskService = new TaskService();
        taskService.executeStatement(task);
    }
    }

