package com.example.Todo.controller;

import com.example.Todo.model.TodoList;
import com.example.Todo.service.TodoListService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Data
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/list")
public class TodoListController {

    @Autowired
    private final TodoListService todoListService;

    @GetMapping("")
    Iterable<TodoList> getAll() {
        return todoListService.getAll();
    }

    @GetMapping("/{id}")
    Optional<TodoList> getById(@PathVariable("id") Long id) {
        return todoListService.getById(id);
    }

    @PostMapping("")
    TodoList newTodoList(@RequestBody TodoList todoList) {
        return todoListService.newTodoList(todoList);
    }

    @DeleteMapping("/{id}")
    TodoList deleteTodoList(@PathVariable("id") Long id) {
        TodoList todoList = todoListService.deleteById(id);
        if (todoList != null) return todoList;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete list with items");
    }
}
