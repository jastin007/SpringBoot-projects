package net.javaguides.ems_backend.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.Service.EmployeeService;
import net.javaguides.ems_backend.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    public EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.CreateEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto savedEmployee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> savedEmployee = employeeService.getAllEmployees();
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("{id}")
   public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long EmployeeId ,@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.updateEmployee(EmployeeId,employeeDto);
       return ResponseEntity.ok(savedEmployee);

   }
   @DeleteMapping("{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted successfully");
   }
}
