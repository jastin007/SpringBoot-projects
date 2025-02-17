package net.javaguides.springboot_webflux_tutorial.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import net.javaguides.springboot_webflux_tutorial.entity.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {

}
