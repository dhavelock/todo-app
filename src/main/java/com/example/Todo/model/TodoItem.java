package com.example.Todo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="list")
    private TodoList list;
}
