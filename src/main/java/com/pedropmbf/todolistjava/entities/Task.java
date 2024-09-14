package com.pedropmbf.todolistjava.entities;

import com.pedropmbf.todolistjava.entities.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Task implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer taskStatus;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task(Long id, String title, String description, TaskStatus taskStatus) {
        if (title != null) {
            this.title = title;
        }else{
            throw new IllegalArgumentException("Title should not be null");
        }
        if (description != null) {
            this.description = description;
        }else {
            throw new IllegalArgumentException("Description should not be null");
        }
        if (taskStatus != null) {
            setTaskStatus(taskStatus);
        }else {
            throw new IllegalArgumentException("TaskStatus should not be null");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return TaskStatus.valueOf(taskStatus);
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        if (taskStatus != null) {
            this.taskStatus = taskStatus.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(taskStatus, task.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, taskStatus);
    }
}
