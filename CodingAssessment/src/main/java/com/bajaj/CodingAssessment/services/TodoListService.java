package com.bajaj.CodingAssessment.services;

import com.bajaj.CodingAssessment.exceptions.EntityNotFoundException;
import com.bajaj.CodingAssessment.models.Product;
import com.bajaj.CodingAssessment.models.TodoList;
import com.bajaj.CodingAssessment.repositories.ProductRepository;
import com.bajaj.CodingAssessment.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Service
@RequestMapping("api/v1/todolist")
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public TodoList create(TodoList todoList){
        return todoListRepository.save(todoList);
    }

    public List<TodoList> getAll(){{
            return todoListRepository.findAll();
        }
    }

    public TodoList get(Long id){
        Optional<TodoList> todoList = todoListRepository.findById(id);
        return todoList.orElse(null);
    }


    public TodoList updateTodoList(Long id, TodoList productDetails) {
        Optional<TodoList> optionalTodoList = todoListRepository.findById(id);
        if (optionalTodoList.isPresent()) {
            TodoList todoList = optionalTodoList.get();
            todoList.setTitle(productDetails.getTitle());
            todoList.setDescription(productDetails.getDescription());
            todoList.setStatus(productDetails.getStatus());
            return todoListRepository.save(todoList);
        }
        throw new EntityNotFoundException("TodoList with id " + id + " not found");
    }

    public void deleteTodoList(Long id) {
        todoListRepository.deleteById(id);
    }

}
