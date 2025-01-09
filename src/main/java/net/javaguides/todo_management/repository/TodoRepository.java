package net.javaguides.todo_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.todo_management.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
