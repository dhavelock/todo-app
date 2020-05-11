package com.example.Todo.service;

import com.example.Todo.model.TodoItem;
import com.example.Todo.model.TodoList;
import com.example.Todo.repo.TodoItemRepository;
import com.example.Todo.repo.TodoListRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Data
@Service
public class TodoItemService {

    @Autowired
    private final TodoItemRepository todoItemRepo;

    @Autowired
    private final TodoListRepository todoListRepo;

    public Iterable<TodoItem> getAll() {
        return todoItemRepo.findAll();
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepo.findById(id);
    }

    public TodoItem newTodoItem(TodoItem todoItem, Long listId) {
        todoListRepo.findById(listId).ifPresent(todoItem::setList);
        if (todoItem.getList() == null) return null;
        if (todoItem.getCreatedDate().after(new Date())) return null;
        return todoItemRepo.save(todoItem);
    }

    public TodoItem deleteById(Long id) {
        TodoItem todoItem = todoItemRepo.findById(id).orElse(null);
        if (todoItem == null) return null;
        todoItemRepo.delete(todoItem);
        return todoItem;
    }
}
