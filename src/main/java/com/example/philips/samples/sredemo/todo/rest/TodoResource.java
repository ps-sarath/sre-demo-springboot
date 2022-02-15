package com.example.philips.samples.sredemo.todo.rest;

import com.example.philips.samples.sredemo.todo.TodoException;
import com.example.philips.samples.sredemo.todo.model.Todo;
import com.example.philips.samples.sredemo.todo.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
public class TodoResource {

    private final TodoRepository todoRepository;

    public TodoResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ResponseEntity<Page<Todo>> list(@PageableDefault(page = 0, size = 10)
                                           @SortDefault.SortDefaults({
                                                   @SortDefault(sort = "id", direction = Sort.Direction.ASC),
                                                   @SortDefault(sort = "title", direction = Sort.Direction.DESC)
                                           }) Pageable page) {
        return ResponseEntity.ok(todoRepository.findAll(page));

    }

    @PostMapping(value = {"/"})
    public Todo create(Todo todo) {

        if (todo.getId() != null) {
            throw new TodoException("Can't create duplicate item");
        }
        return todoRepository.save(todo);
    }

    @PutMapping(value = {"/"})
    public Todo update(Todo todo) {

        if (todo.getId() == null) {
            throw new TodoException("Can't update a non-existing item");
        }
        return todoRepository.save(todo);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {

        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
            return;
        }

        throw new TodoException("No such item found");
    }
}
