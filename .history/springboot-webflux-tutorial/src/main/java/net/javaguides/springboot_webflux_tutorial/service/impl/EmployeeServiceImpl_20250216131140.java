package net.javaguides.springboot_webflux_tutorial.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot_webflux_tutorial.dto.EmployeeDto;
import net.javaguides.springboot_webflux_tutorial.entity.Employee;
import net.javaguides.springboot_webflux_tutorial.mapper.EmployeeMapper;
import net.javaguides.springboot_webflux_tutorial.repository.EmployeeRepository;
import net.javaguides.springboot_webflux_tutorial.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {

        // convert employeedto into employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> savedEmployee = employeeRepository.findById(employeeId);
        return savedEmployee.map((employee) -> EmployeeMapper.mapToEmployeeDto(employee));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employeeFlux = employeeRepository.findAll();
        return employeeFlux.map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());

    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

}
