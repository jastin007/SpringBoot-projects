package net.javguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javguides.sms.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
