package net.javaguides.springboot_webflux_tutorial.mapper;

import net.javaguides.springboot_webflux_tutorial.dto.EmployeeDto;
import net.javaguides.springboot_webflux_tutorial.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail());
    }
}
