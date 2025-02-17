package net.javaguides.springboot_webflux_tutorial.service;

import net.javaguides.springboot_webflux_tutorial.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);

    Mono<EmployeeDto> getEmployee(String employeeId);

    // returns multiple results
    Flux<EmployeeDto> getAllEmployees();

    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId);
}
