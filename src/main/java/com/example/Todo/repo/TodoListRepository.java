package com.example.Todo.repo;

import com.example.Todo.model.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "list", path = "list")
public interface TodoListRepository extends CrudRepository<TodoList, Long> {
}
