package net.javaguides.ems_backend.Repository;

import jakarta.persistence.Id;
import net.javaguides.ems_backend.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}
