package net.javaguides.springboot_webflux_tutorial.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot_webflux_tutorial.dto.EmployeeDto;
import net.javaguides.springboot_webflux_tutorial.service.EmployeeService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // mono means single or empty values and flux means multiple values
    // Build Reactive save employee rest api
    @PostMapping
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);

    }
}
