package net.javaguides.todo_management.service;

import java.util.List;

import net.javaguides.todo_management.dto.Tododto;

public interface Todoservice {
    Tododto addTodo(Tododto tododto);

    Tododto getTodo(Long id);

    List<Tododto> getAllTodos();

    Tododto updateTododto(Tododto tododto, Long id);

    void deleteTodo(Long id);

    Tododto completeTododto(Long id);

    Tododto incompleTododto(Long id);

}
