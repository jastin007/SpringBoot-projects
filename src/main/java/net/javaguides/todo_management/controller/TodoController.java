package net.javaguides.todo_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.dto.Tododto;
import net.javaguides.todo_management.service.Todoservice;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private Todoservice todoService;

    // Build Add Todo REST API

    @PostMapping
    public ResponseEntity<Tododto> addTodo(@RequestBody Tododto todoDto) {
        Tododto saveTododto = todoService.addTodo(todoDto);
        return new ResponseEntity<>(saveTododto, HttpStatus.CREATED);
    }

    // Build get Todo Rest Api
    @GetMapping("{id}")
    public ResponseEntity<Tododto> getTodo(@PathVariable("id") Long todoId) {
        Tododto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build get All Todos REST API
    @GetMapping
    public ResponseEntity<List<Tododto>> getAllTodos() {
        List<Tododto> todos = todoService.getAllTodos();
        // return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    // Build update Todos REST API
    @PutMapping("{id}")
    public ResponseEntity<Tododto> updateTodo(@RequestBody Tododto todoDto, @PathVariable("id") Long todoid) {
        Tododto updateddto = todoService.updateTododto(todoDto, todoid);
        return ResponseEntity.ok(updateddto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Employee deleted successfully! ");
    }

    // build complete Todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<Tododto> completeTodo(@PathVariable("id") Long todoid) {
        Tododto updateddto = todoService.completeTododto(todoid);
        return ResponseEntity.ok(updateddto);
    }

    @PatchMapping("{id}/incomplete")
    public ResponseEntity<Tododto> incompleteTodo(@PathVariable("id") Long todoid) {
        Tododto updateddto = todoService.incompleTododto(todoid);
        return ResponseEntity.ok(updateddto);
    }
}
