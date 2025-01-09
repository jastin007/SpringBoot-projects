package net.javaguides.todo_management.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.todo_management.Entity.Todo;
import net.javaguides.todo_management.Exception.ResourceNotFoundException;
import net.javaguides.todo_management.dto.Tododto;
import net.javaguides.todo_management.repository.TodoRepository;
import net.javaguides.todo_management.service.Todoservice;

@Service
@AllArgsConstructor
public class TodoServiceimpl implements Todoservice {

    private TodoRepository todoRepository;

    private ModelMapper modelmapper;

    @Override
    public Tododto addTodo(Tododto tododto) {
        // TODO Auto-generated method stub
        // convert Tododto into Todo jpa entity
        // Todo todo = new Todo();
        // todo.setTitle(tododto.getTitle());
        // todo.setDescription(tododto.getDescription());
        // todo.setCompleted(tododto.isCompleted());

        Todo todo = modelmapper.map(tododto, Todo.class);
        // Todo jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo jpa entity object into Tododto object
        // Tododto savedTododto = new Tododto();
        // savedTododto.setId(savedTodo.getId());
        // savedTododto.setTitle(savedTodo.getTitle());
        // savedTododto.setDescription(savedTodo.getDescription());
        // savedTododto.setCompleted(savedTodo.isCompleted());
        Tododto savedTododto = modelmapper.map(savedTodo, Tododto.class);
        return savedTododto;
    }

    @Override
    public Tododto getTodo(Long id) {
        // TODO Auto-generated method stub
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return modelmapper.map(todo, Tododto.class);

    }

    @Override
    public List<Tododto> getAllTodos() {
        // TODO Auto-generated method stub
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelmapper.map(todo, Tododto.class)).collect(Collectors.toList());

    }

    @Override
    public Tododto updateTododto(Tododto tododto, Long id) {
        // TODO Auto-generated method stub
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setTitle(tododto.getTitle());
        todo.setDescription(tododto.getDescription());
        // todo.setCompleted(tododto);
        Todo savedtodo = todoRepository.save(todo);
        return modelmapper.map(savedtodo, Tododto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todoRepository.deleteById(id);
    }

    @Override
    public Tododto completeTododto(Long id) {
        // TODO Auto-generated method stub
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setCompleted(Boolean.FALSE);
        Todo savedtodo = todoRepository.save(todo);
        return modelmapper.map(savedtodo, Tododto.class);
    }

    @Override
    public Tododto incompleTododto(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id"));
        todo.setCompleted(Boolean.FALSE);
        Todo savedTodo = todoRepository.save(todo);
        return modelmapper.map(savedTodo, Tododto.class);
        // TODO Auto-generated method stub

    }

}
