package com.bajaj.CodingAssessment.controllers;

import com.bajaj.CodingAssessment.beens.ResponseHandler;
import com.bajaj.CodingAssessment.models.Product;
import com.bajaj.CodingAssessment.models.TodoList;
import com.bajaj.CodingAssessment.services.ProductService;
import com.bajaj.CodingAssessment.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/todolist")
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Found TodoList", HttpStatus.OK, todoListService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        TodoList todoList = todoListService.get(id);
        return ResponseHandler.createResponse("Found", HttpStatus.OK, todoListService.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody TodoList todoList) {
        TodoList createProduct = todoListService.create(todoList);
        return ResponseHandler.createResponse("Created", HttpStatus.CREATED, createProduct);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodoList(@PathVariable Long id, @RequestBody TodoList todoList) {
        TodoList updatedTodoList = todoListService.updateTodoList(id, todoList);
        return ResponseHandler.createResponse("Product Updated", HttpStatus.OK, updatedTodoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
        return ResponseHandler.deleteResponse("TodoList Deleted", HttpStatus.OK);
    }

}
