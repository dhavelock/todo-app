package com.example.Todo.service;

import com.example.Todo.model.TodoList;
import com.example.Todo.repo.TodoItemRepository;
import com.example.Todo.repo.TodoListRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Data
@Service
public class TodoListService {

    @Autowired
    private final TodoListRepository todoListRepo;

    @Autowired
    private final TodoItemRepository todoItemRepo;

    public Iterable<TodoList> getAll() {
        return todoListRepo.findAll();
    }

    public Optional<TodoList> getById(Long id) {
        return todoListRepo.findById(id);
    }

    public TodoList newTodoList(TodoList todoList) {
        todoList.setItems(Collections.emptyList());
        return todoListRepo.save(todoList);
    }

    public TodoList deleteById(Long id) {
        TodoList todoList = todoListRepo.findById(id).orElse(null);
        if (todoList == null) return null;
        if (!todoList.getItems().isEmpty()) return null;
        todoListRepo.delete(todoList);
        return todoList;
    }
}
