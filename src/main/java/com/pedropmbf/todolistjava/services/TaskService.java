package com.pedropmbf.todolistjava.services;

import com.pedropmbf.todolistjava.dto.TaskDto;
import com.pedropmbf.todolistjava.dto.TaskRequestDto;
import com.pedropmbf.todolistjava.entities.Task;
import com.pedropmbf.todolistjava.entities.enums.TaskStatus;
import com.pedropmbf.todolistjava.repositories.TaskRepository;
import com.pedropmbf.todolistjava.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //method to find all the tasks from repo
    public List<Task> findAll() {
        return repository.findAll();
    }
    //method to find the Task from id
    public Task findById(Long id) {
        Optional<Task> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //method to find the Task from the title
    public Task findByTitle(String title){
        Optional<Task> obj = repository.findByTitle(title);
        return obj.orElseThrow(() -> new ResourceNotFoundException(title));
    }

    //method to create the Task
    public Task insert(Task obj) {
        try {
            obj.setTaskStatus(TaskStatus.TO_BE_DONE);
            return repository.save(obj);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    //method to push info from TaskDto
    public Task fromDto(TaskRequestDto objDto) {
        return new Task(objDto.getTitle(), objDto.getDescription());
    }

    //method to delete the Task
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    //method to uptade the Task
    public Task update(Long id, Task obj) {
        try {
            Task entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    //method to uptade the Task fromDto
    public Task updateFromDto(Long id, TaskDto objDto) {
        try {
            Task entity = repository.getReferenceById(id);
            updateDataDto(entity, objDto);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    //sub-method to uptade the Task
    private void updateData(Task entity, Task obj) {
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
        entity.setTaskStatus(obj.getTaskStatus());
    }
    //sub-method to uptade the Task fromDto
    private void updateDataDto(Task entity, TaskDto objDto) {
        if(objDto.getTitle() != null) {
            entity.setTitle(objDto.getTitle());
        }
        if(objDto.getDescription() != null) {
            entity.setDescription(objDto.getDescription());
        }
        if(objDto.getTaskStatus() != null) {
            entity.setTaskStatus(objDto.getTaskStatus());
        }
    }
}
