package com.example.Todo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lid;

    private String name;

    @OneToMany(mappedBy="list")
    private List<TodoItem> items;
}
