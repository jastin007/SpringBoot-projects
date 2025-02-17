package net.javaguides.springboot_webflux_tutorial.service;

import net.javaguides.springboot_webflux_tutorial.dto.EmployeeDto;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);

    Mono<EmployeeDto> getEmployee(String employeeId);
}
