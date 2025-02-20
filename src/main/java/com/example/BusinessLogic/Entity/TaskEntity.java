package com.example.BusinessLogic.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Target;

import java.time.LocalDate;

@Entity
@Table(name = "/task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "dueDate")
    private LocalDate date;
    @Column(name = "completed")
    private boolean completed;

    //empty costructor
    private TaskEntity(){}

    public TaskEntity(boolean completed, LocalDate date, String description, String title, Long id) {
        this.completed = completed;
        this.date = date;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
