package com.pedropmbf.todolistjava.config;

import com.pedropmbf.todolistjava.entities.Task;
import com.pedropmbf.todolistjava.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void run(String... args) throws Exception {

        Task task1 = new Task(null,"Task1", "test1", "ToBeDone");
        Task task2 = new Task(null, "Task2", "test2", "ToBeDone");

        taskRepository.saveAll(Arrays.asList(task1, task2));
    }
}
