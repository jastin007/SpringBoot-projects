package net.javguides.sms.Service;

import java.util.List;

import net.javguides.sms.dto.StudentDto;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long studentId);

}
