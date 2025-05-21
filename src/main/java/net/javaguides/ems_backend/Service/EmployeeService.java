package net.javaguides.ems_backend.Service;

import net.javaguides.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
      EmployeeDto CreateEmployee(EmployeeDto employeeDto);

      EmployeeDto getEmployeeById(Long id);

      List<EmployeeDto> getAllEmployees();

      EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployee);

     void deleteEmployee(Long id);

}
