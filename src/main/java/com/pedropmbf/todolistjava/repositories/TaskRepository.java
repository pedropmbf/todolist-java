package com.pedropmbf.todolistjava.repositories;

import com.pedropmbf.todolistjava.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
