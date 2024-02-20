package com.bajaj.CodingAssessment.repositories;

import com.bajaj.CodingAssessment.models.Product;
import com.bajaj.CodingAssessment.models.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Long> {
}
