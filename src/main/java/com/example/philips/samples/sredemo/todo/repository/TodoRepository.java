package com.example.philips.samples.sredemo.todo.repository;

import com.example.philips.samples.sredemo.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
