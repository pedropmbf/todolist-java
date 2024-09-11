package com.pedropmbf.todolistjava.services;

import com.pedropmbf.todolistjava.entities.Task;
import com.pedropmbf.todolistjava.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> obj = Optional.of(repository.findById(id).get());
        return obj.get();
    }

    public Task insert(Task obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
