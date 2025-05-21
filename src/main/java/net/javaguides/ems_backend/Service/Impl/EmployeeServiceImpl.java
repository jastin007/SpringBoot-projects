package net.javaguides.ems_backend.Service.Impl;

import net.javaguides.ems_backend.Entity.Employees;
import net.javaguides.ems_backend.Exception.ResourceNotFoundException;
import net.javaguides.ems_backend.Mapper.EmployeeMapper;
import net.javaguides.ems_backend.Repository.EmployeeRepository;
import net.javaguides.ems_backend.Service.EmployeeService;
import net.javaguides.ems_backend.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto CreateEmployee(EmployeeDto employeeDto) {
        Employees employees = EmployeeMapper.MaptoEmployee(employeeDto);
        Employees savedemployeesDto = employeeRepository.save(employees);
        return EmployeeMapper.MaptoEmployeeDto(savedemployeesDto);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
          Employees employees = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id : " +id));
          return EmployeeMapper.MaptoEmployeeDto(employees);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employees> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.MaptoEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployee) {
        Employees employees = employeeRepository.findById(employeeid).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id : " +employeeid));

                       employees.setFirstName(updatedEmployee.getFirstName());
                        employees.setLastName(updatedEmployee.getLastName());
                        employees.setEmail(updatedEmployee.getEmail());
         Employees savedEmployeeobj = employeeRepository.save(employees);
         return EmployeeMapper.MaptoEmployeeDto(savedEmployeeobj);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employees employees = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id : " +id));
        employeeRepository.deleteById(id);

    }


}






