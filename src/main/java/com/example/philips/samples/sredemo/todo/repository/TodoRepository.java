package com.example.philips.samples.sredemo.todo.repository;

import com.example.philips.samples.sredemo.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


}
