package net.javaguides.ems_backend.Mapper;

import net.javaguides.ems_backend.Entity.Employees;
import net.javaguides.ems_backend.dto.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeDto MaptoEmployeeDto(Employees employees){
        return new EmployeeDto(
                employees.getId(),
                employees.getFirstName(),
                employees.getLastName(),
                employees.email()
                );
    }

    public static Employees MaptoEmployee(EmployeeDto employeeDto){
        return new Employees(
               employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
