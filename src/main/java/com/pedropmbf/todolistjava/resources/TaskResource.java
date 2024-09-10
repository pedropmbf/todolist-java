package com.pedropmbf.todolistjava.resources;

import com.pedropmbf.todolistjava.entities.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @GetMapping
    public ResponseEntity<Task> findAll() {
        Task task = new Task(1L, "Teste", "task de teste", "Ok");
        return ResponseEntity.ok().body(task);
    }
}
