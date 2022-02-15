package com.example.philips.samples.sredemo.todo.repository;

import com.example.philips.samples.sredemo.todo.model.Todo;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    Faker faker = new Faker();

    @Test
    void testCrud() {

        String title = "Some title";
        String description = "some description";

        Todo todo = new Todo(title, description);

        todo = todoRepository.save(todo);

        assertNotNull(todo.getId());
        assertEquals(title, todo.getTitle());
        assertEquals(description, todo.getDescription());


    }

}