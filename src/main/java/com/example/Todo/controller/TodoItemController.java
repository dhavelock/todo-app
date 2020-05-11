package com.example.Todo.controller;

import com.example.Todo.model.TodoItem;
import com.example.Todo.service.TodoItemService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Data
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/item")
public class TodoItemController {
    @Autowired
    private final TodoItemService todoItemService;

    @GetMapping("")
    Iterable<TodoItem> getAll() {
        return todoItemService.getAll();
    }

    @GetMapping("/{id}")
    Optional<TodoItem> getById(@PathVariable("id") Long id) {
        return todoItemService.getById(id);
    }

    @PostMapping("")
    TodoItem newTodoItem(@RequestBody TodoItem todoItem, @RequestParam(name = "listId") Long listId) {
        TodoItem createdTodoItem = todoItemService.newTodoItem(todoItem, listId);
        if (createdTodoItem != null) return createdTodoItem;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "createdDate must be in past and listId must exist");
    }

    @DeleteMapping("/{id}")
    TodoItem deleteTodoItem(@PathVariable("id") Long id) {
        TodoItem todoItem = todoItemService.deleteById(id);
        if (todoItem != null) return todoItem;
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to delete item");
    }
}
