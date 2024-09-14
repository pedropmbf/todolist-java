package com.pedropmbf.todolistjava.resources;

import com.pedropmbf.todolistjava.dto.TaskDto;
import com.pedropmbf.todolistjava.dto.TaskRequestDto;
import com.pedropmbf.todolistjava.entities.Task;
import com.pedropmbf.todolistjava.services.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService service;

    //Endpoint for get all tasks
    @GetMapping
    public ResponseEntity<List<TaskDto>> findAll() {
        List<Task> list = service.findAll();
        List<TaskDto> listDto = list.stream().map(x -> new TaskDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    //Endpoint for search tasks from Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Endpoint to create tasks
    //usar o taskrequestDto
    @PostMapping
    public ResponseEntity<TaskDto> insert(@NotNull @RequestBody TaskRequestDto objDto) {
        Task obj = service.fromDto(objDto);
        final var objSaved = service.insert(obj);
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok().body(new TaskDto(objSaved));
    }

    //Endpoint for delete tasks from Id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       service.delete(id);
       return ResponseEntity.noContent().build();
    }

    //Endpoint to update tasks
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable Long id, @RequestBody TaskDto objDto) {
        Task obj = service.updateFromDto(id, objDto);
        return ResponseEntity.ok().build();
    }

}
