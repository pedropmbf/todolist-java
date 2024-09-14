package com.pedropmbf.todolistjava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class TaskRequestDto {

    @NotBlank(message = "O titulo nao pode ser nulo")
    private String title;
    @NotBlank(message = "A descricao nao pode ser nula")
    private String description;

    public TaskRequestDto() {

    }

    public TaskRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskRequestDto that = (TaskRequestDto) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
